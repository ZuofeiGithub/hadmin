package com.jili.hadmin.author;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        return null;
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
        String name = "eric";
        String password = "123456";
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(!token.getUsername().equals(name)){
            System.out.println("用户不存在");
            return null;//shiro底层会抛出UnKonowAccount异常
        }
        //判断密码
        return new SimpleAuthenticationInfo("",password,"");
    }
}
