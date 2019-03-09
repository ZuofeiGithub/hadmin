package com.jili.hadmin.author;

import com.jili.hadmin.entity.RoleUser;
import com.jili.hadmin.entity.SysRole;
import com.jili.hadmin.entity.SysUser;
import com.jili.hadmin.service.RoleUserService;
import com.jili.hadmin.service.SysRoleService;
import com.jili.hadmin.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 左飞
 * @Date: 2019/3/7 15:49
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RoleUserService roleUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        if(!ObjectUtils.isEmpty(user)) {
            RoleUser roleUser = roleUserService.queryByUserId(user.getId());
            if (!ObjectUtils.isEmpty(roleUser)) {
                SysRole role = sysRoleService.queryById(roleUser.getRoleId());
                if (!ObjectUtils.isEmpty(role)) {
                    Set<String> set = new HashSet<>();
                    set.add(role.getRole());
                    //权限
                    info.setRoles(set);
                    info.addStringPermission(role.getRole());
                }
            }
        }
        return info;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑");
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        SysUser sysUser = sysUserService.queryByUserName(userName);

        //取出盐并编码
        ByteSource salt = ByteSource.Util.bytes(sysUser.getSalt());
        if(ObjectUtils.isEmpty(sysUser))
        {
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),salt,"");
    }
}
