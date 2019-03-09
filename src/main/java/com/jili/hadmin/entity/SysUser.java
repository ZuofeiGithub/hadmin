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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}