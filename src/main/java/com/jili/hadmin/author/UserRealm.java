package com.jili.hadmin.author;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

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

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
//        info.addStringPermission("user:admin");
        Subject subject = SecurityUtils.getSubject();
//        UserInfo use = (UserInfo) subject.getPrincipal();
//        SysUser dbUser = sysUserService.queryById(sysUser.getId());
//        Set<String> set = new HashSet<>();
//        set.add(dbUser.getRole());
//        //权限
//        info.setRoles(set);
//        info.addStringPermission(dbUser.getPerms());
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
        //处理session
//        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
//        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
//        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
//        for(Session session:sessions){
//            //清除该用户以前登录时保存的session
//            if(userName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
//                sessionManager.getSessionDAO().delete(session);
//            }
//        }


//        if(ObjectUtils.isEmpty(sysUser))
//        {
//            return null;
//        }
//        //判断密码
//        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),"");
        return null;
    }
}
