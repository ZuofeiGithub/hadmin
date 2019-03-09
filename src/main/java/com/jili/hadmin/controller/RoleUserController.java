package com.jili.hadmin.controller;

import com.jili.hadmin.entity.RoleUser;
import com.jili.hadmin.service.RoleUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户和角色关联表(RoleUser)表控制层
 *
 * @author makejava
 * @since 2019-03-09 10:16:16
 */
@RestController
@RequestMapping("roleUser")
public class RoleUserController {
    /**
     * 服务对象
     */
    @Resource
    private RoleUserService roleUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RoleUser selectOne(Integer id) {
        return this.roleUserService.queryById(id);
    }

}