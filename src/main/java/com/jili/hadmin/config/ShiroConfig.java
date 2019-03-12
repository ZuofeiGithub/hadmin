package com.jili.hadmin.config;

import com.ibeetl.starter.BeetlTemplateCustomize;
import com.jili.hadmin.author.UserRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.beetl.core.GroupTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
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
//        //授权过滤器
//        filterMap.put("/admin","perms[ROLE_ADMIN]");
        //设置未授权提示页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("about");
        filterMap.put("/login","anon");
        filterMap.put("/admin","authc");
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
        //注入Cookie(记住我)管理器(remenberMeManager)
        securityManager.setRememberMeManager(rememberMeManager());
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
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //rememberme cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey deskey = keyGenerator.generateKey();
            byte[] cipherKey = Base64.decode(deskey.getEncoded());
            cookieRememberMeManager.setCipherKey(cipherKey);
            cookieRememberMeManager.setCookie(rememberMeCookie());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        simpleCookie.setHttpOnly(true);
        //记住我cookie生效时间,默认30天 ,单位秒：60 * 60 * 24 * 30
        simpleCookie.setMaxAge(259200);

        return simpleCookie;
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
