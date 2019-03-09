package com.jili.hadmin.entity;

import java.io.Serializable;

/**
 * 用户和角色关联表(RoleUser)实体类
 *
 * @author makejava
 * @since 2019-03-09 10:16:13
 */
public class RoleUser implements Serializable {
    private static final long serialVersionUID = -16742561502517936L;
    //用户ID
    private Integer userId;
    //角色ID
    private Integer roleId;
    
    private Integer id;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}