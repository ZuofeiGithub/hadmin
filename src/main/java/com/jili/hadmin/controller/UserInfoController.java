package com.jili.hadmin.controller;

import com.jili.hadmin.entity.UserInfo;
import com.jili.hadmin.service.UserInfoService;
import com.jili.hadmin.utils.MD5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户表(UserInfo)表控制层
 *
 * @author makejava
 * @since 2019-03-08 13:09:33
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserInfo selectOne(Integer id) {
        return this.userInfoService.queryById(id);
    }

    @PostMapping("addAdmin")
    public UserInfo addAdmin(String username,String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        try {
            String md5Pwd = MD5Util.getEncryptedPwd(password);
            userInfo.setPassword(md5Pwd);
            userInfo.setBusinessid(0);
            userInfo.setImgurl("http://b-ssl.duitang.com/uploads/item/201812/29/20181229134002_ijheq.jpg");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this.userInfoService.insert(userInfo);
    }

}