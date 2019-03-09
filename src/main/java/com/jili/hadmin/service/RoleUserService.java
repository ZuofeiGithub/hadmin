package com.jili.hadmin.service;

import com.jili.hadmin.entity.RoleUser;
import java.util.List;

/**
 * 用户和角色关联表(RoleUser)表服务接口
 *
 * @author makejava
 * @since 2019-03-09 10:16:15
 */
public interface RoleUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleUser queryById(Integer id);

    /**
     * 通过用户id找到角色id
     * @param userId 用户id
     * @return 实例对象
     */
    RoleUser queryByUserId(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    RoleUser insert(RoleUser roleUser);

    /**
     * 修改数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    RoleUser update(RoleUser roleUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}