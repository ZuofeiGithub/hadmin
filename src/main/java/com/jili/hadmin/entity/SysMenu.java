package com.jili.hadmin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单权限表(SysMenu)实体类
 *
 * @author makejava
 * @since 2019-03-08 13:24:58
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 220148939568120263L;
    //菜单id
    private Integer id;
    //菜单名称
    private String title;
    //父菜单ID
    private Integer parentId;
    //请求地址
    private String href;
    //菜单图标
    private String icon;
    //菜单类型（M目录 C菜单 ）
    private String menuType;

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<SysMenu> getList() {
        return list;
    }

    public void setList(List<SysMenu> list) {
        this.list = list;
    }

    private List<SysMenu> list;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

}