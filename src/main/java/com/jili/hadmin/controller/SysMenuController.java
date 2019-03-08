package com.jili.hadmin.controller;

import com.jili.hadmin.entity.SysMenu;
import com.jili.hadmin.service.SysMenuService;
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
        List<Object> list = new ArrayList<>();
        list.add(sysMenuService.getMenuList());
        return list;
    }

}