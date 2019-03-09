package com.jili.hadmin.service.impl;

import com.jili.hadmin.entity.RoleUser;
import com.jili.hadmin.dao.RoleUserDao;
import com.jili.hadmin.service.RoleUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户和角色关联表(RoleUser)表服务实现类
 *
 * @author makejava
 * @since 2019-03-09 10:16:15
 */
@Service("roleUserService")
public class RoleUserServiceImpl implements RoleUserService {
    @Resource
    private RoleUserDao roleUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleUser queryById(Integer id) {
        return this.roleUserDao.queryById(id);
    }

    @Override
    public RoleUser queryByUserId(Integer userId) {
        return this.roleUserDao.queryByUserId(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleUser> queryAllByLimit(int offset, int limit) {
        return this.roleUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    @Override
    public RoleUser insert(RoleUser roleUser) {
        this.roleUserDao.insert(roleUser);
        return roleUser;
    }

    /**
     * 修改数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    @Override
    public RoleUser update(RoleUser roleUser) {
        this.roleUserDao.update(roleUser);
        return this.queryById(roleUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleUserDao.deleteById(id) > 0;
    }
}