package com.jili.hadmin.controller;

import com.jili.hadmin.constant.URL;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 左飞
 * @Date: 2019/3/7 16:34
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "backapi")
public class BackController {

    @PostMapping(value = "/login")
    public String login(String name,String password){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(name);
        token.setPassword(password.toCharArray());
        //3.执行登陆方法
        try {
            subject.login(token);
            //登陆成功
            System.out.println("登陆成功");
            return "redirect:admin";
        }catch (UnknownAccountException e){
            //e.printStackTrace();
            //登陆失败
            //用户名不存在
            System.out.println("用户不存在");
        }catch (IncorrectCredentialsException e){
            //密码错误
            System.out.println("密码错误");
        }

        return URL.LOGIN;
    }
}
