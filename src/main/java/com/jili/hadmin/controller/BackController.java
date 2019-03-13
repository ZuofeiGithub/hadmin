package com.jili.hadmin.controller;

import com.aliyuncs.exceptions.ClientException;
import com.jili.hadmin.annotation.UserLoginToken;
import com.jili.hadmin.entity.SysUser;
import com.jili.hadmin.json.BaseResp;
import com.jili.hadmin.json.LoginResp;
import com.jili.hadmin.json.RegisterData;
import com.jili.hadmin.json.RegisterResp;
import com.jili.hadmin.service.SysUserService;
import com.jili.hadmin.service.TokenService;
import com.jili.hadmin.utils.MD5Util;
import com.jili.hadmin.utils.RandomValidateCodeUtil;
import com.jili.hadmin.utils.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.jili.hadmin.utils.AlicomDysmsUtil.sendSms;

/**
 * @Author: 左飞
 * @Date: 2019/3/7 16:34
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "backapi")
public class BackController {
    @Resource
    private SysUserService sysUserService;

    @Resource
    RedisService redisService;

    @Resource
    TokenService tokenService;

    @PostMapping(value = "/login")
    @ResponseBody
    public BaseResp login(String username, String password,boolean rememberMe){
        /**
         * 使用Shiro编写认证操作
         */
        BaseResp resp = new LoginResp();
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        SysUser user = sysUserService.queryByUserName(username);
        if(!ObjectUtils.isEmpty(user)){
            String md5Pwd = MD5Util.salt_md5(password,user.getSalt());
            token.setPassword(md5Pwd.toCharArray());
        }
        token.setRememberMe(rememberMe);
        //3.执行登陆方法
        try {
            subject.login(token);
            //登陆成功
            resp.setErrcode(0).setErrmsg("登陆成功");
            String access_token = tokenService.getToken(user);
            System.out.println(access_token);
        }catch (UnknownAccountException e){
            //e.printStackTrace();
            //登陆失败
            //用户名不存在
            resp.setErrcode(200).setErrmsg("用户不存在");
        }catch (IncorrectCredentialsException e){
            //密码错误
            resp.setErrcode(300).setErrmsg("密码错误");
        }
        return resp;
    }

    @GetMapping("getmessage")
    @UserLoginToken
    @ResponseBody
    public String getMessage() {
        return "通过验证";
    }






    @PostMapping("/verifycode")
    @ResponseBody
    public BaseResp verifycode(HttpServletRequest request,String phone){
        BaseResp resp = new RegisterResp();
        RegisterData data = new RegisterData();
        try {
            sendSms(phone, request.getSession(), "SMS_152852628");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        String code = request.getSession().getAttribute("smscode").toString();
        redisService.set("code" + phone, code, 1800L);
        data.setExpire(60);
        ((RegisterResp) resp).setData(data);
        resp.setErrmsg("获取验证码成功");
        resp.setErrcode(0);
        return resp;
    }



    @RequestMapping(value = "/getimageverify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            System.out.println("获取验证码失败");
        }
    }


    @PostMapping("/register")
    @ResponseBody
    public BaseResp register(HttpSession session, String phone, String code, String password, String captcha){
        BaseResp resp = new BaseResp();
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        if(!ObjectUtils.isEmpty(phone)&&!ObjectUtils.isEmpty(code)&&!ObjectUtils.isEmpty(password)&&!ObjectUtils.isEmpty(captcha)&&!ObjectUtils.isEmpty(random)) {
            String authentycode = redisService.get("code" + phone).toString();
            if (!ObjectUtils.isEmpty(authentycode) && !code.equals(authentycode)) {
                resp.setErrmsg("短信验证码填写错误").setErrcode(100);
            } else if (!random.equals(captcha)) {
                resp.setErrmsg("验证码填写错误").setErrcode(100);
            } else if(!ObjectUtils.isEmpty(sysUserService.queryByUserName(phone))){
                resp.setErrmsg("用户已经存在").setErrcode(100);
            }
            else {
                SysUser sysUser = new SysUser();
                String salt = MD5Util.getSalt();
                String md5Pwd = MD5Util.salt_md5(password,salt);
                sysUser.setUsername(phone).setSalt(salt).setPassword(md5Pwd).setBusinessid(0).setImgurl("");
                if(!ObjectUtils.isEmpty(sysUserService.insert(sysUser))){
                    resp.setErrcode(0).setErrmsg("注册成功");
                }else{
                    resp.setErrcode(100).setErrmsg("注册失败");
                }
            }
        }else{
            resp.setErrmsg("请将信息填写完整再提交").setErrcode(100);
        }
        return resp;
    }
}
