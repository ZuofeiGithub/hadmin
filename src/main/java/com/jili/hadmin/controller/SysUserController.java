package com.jili.hadmin.controller;

import com.jili.hadmin.entity.SysUser;
import com.jili.hadmin.json.ErrorMsg;
import com.jili.hadmin.service.SysUserService;
import com.jili.hadmin.utils.MD5Util;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2019-03-09 09:32:45
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    private static final int SALT_LENGTH = 12;
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        return this.sysUserService.queryById(id);
    }

    @PostMapping("addAdmin")
    public ErrorMsg addAdmin(String username, String password) {
        ErrorMsg msg = new ErrorMsg();
        SysUser isexist = sysUserService.queryByUserName(username);
        if (ObjectUtils.isEmpty(isexist)) {
            SysUser sysUser = new SysUser();
            sysUser.setBusinessid(0);
            sysUser.setImgurl("");
            sysUser.setUsername(username);
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            // 将随机数放入盐变量中
            random.nextBytes(salt);
            sysUser.setSalt(salt.toString());
            String md5Pwd = MD5Util.salt_md5(password, salt.toString());
            sysUser.setPassword(md5Pwd);
            msg.setData(this.sysUserService.insert(sysUser));
            msg.setErrcode(0);
            msg.setErrmsg("添加成功");
        }else{
            msg.setErrcode(200);
            msg.setErrmsg("用户已经存在");
            msg.setData(null);
        }
        return msg;
    }

}