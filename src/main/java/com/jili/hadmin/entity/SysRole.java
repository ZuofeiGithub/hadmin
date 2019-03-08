package com.jili.hadmin.entity;

import java.io.Serializable;

/**
 * 角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2019-03-08 16:31:27
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 279125248845857759L;
    //角色id
    private Integer id;
    //角色名称
    private String roleName;
    
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}