package com.jili.hadmin.config;

import com.ibeetl.starter.BeetlTemplateCustomize;
import com.jili.hadmin.author.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.beetl.core.GroupTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/3/7 15:45
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * 常用过滤器 anon:无需认证 authc:必须认证
         * user:如果使用rememberMe的功能可以直接访问
         * perms:有资源权限才可以访问
         * role:得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //修改跳转地址
        shiroFilterFactoryBean.setLoginUrl("/login");
        //授权过滤器
        filterMap.put("/admin","perms[user:admin]");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("about");
        filterMap.put("/login","anon");
//        filterMap.put("/admin","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //管理realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建Realm Shiro连接数据的桥梁
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize(){
        return new BeetlTemplateCustomize() {
            @Override
            public void customize(GroupTemplate groupTemplate) {
                groupTemplate.registerFunctionPackage("so",new ShiroExt());
            }
        };
    }
}
