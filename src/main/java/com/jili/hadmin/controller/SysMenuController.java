package com.jili.hadmin.controller;

import com.jili.hadmin.entity.SysMenu;
import com.jili.hadmin.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2019-03-08 13:24:58
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysMenu selectOne(Integer id) {
        return this.sysMenuService.queryById(id);
    }

    @GetMapping("getMenuList")
    public Object getMenuList(){
        Subject subject = SecurityUtils.getSubject();
        List<Object> list = new ArrayList<>();
        List<SysMenu> sysMenus = new ArrayList<>();
        if(subject.hasRole("ROLE_ADMIN")){
            sysMenus = sysMenuService.getMenuList(1);
        }else if(subject.hasRole("ROLE_USER")){
            sysMenus = sysMenuService.getMenuList(2);
        }
        if(ObjectUtils.isEmpty(sysMenus)){
            list.add(new ArrayList<>());
        }
        list.add(sysMenus);

        return list;
    }

}