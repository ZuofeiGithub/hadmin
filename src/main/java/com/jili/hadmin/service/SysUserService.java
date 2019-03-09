package com.jili.hadmin.service;

import com.jili.hadmin.entity.SysUser;
import java.util.List;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2019-03-09 09:32:44
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);


    /**
     * 通过USERNAME查询单条数据
     *
     * @param username 名字
     * @return 实例对象
     */
    SysUser queryByUserName(String username);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}