package com.jili.hadmin.entity;

import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2019-03-09 09:48:29
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = -10334058390326324L;
    //用户id
    private Integer id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //关联商家id
    private Integer businessid;
    //商家管理员头像
    private String imgurl;
    
    private String salt;



    private String token;


    public Integer getId() {
        return id;
    }

    public SysUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SysUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public SysUser setBusinessid(Integer businessid) {
        this.businessid = businessid;
        return this;
    }

    public String getImgurl() {
        return imgurl;
    }

    public SysUser setImgurl(String imgurl) {
        this.imgurl = imgurl;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public SysUser setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getToken() {
        return token;
    }

    public SysUser setToken(String token) {
        this.token = token;
        return this;
    }
}