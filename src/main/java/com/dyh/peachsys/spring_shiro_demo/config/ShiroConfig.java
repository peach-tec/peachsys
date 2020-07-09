package com.dyh.peachsys.spring_shiro_demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Peach-華
 * @version V1.0
 * @desc shiro配置类
 * @copyright &copy; DYH
 * @date 2020/7/8-20:53
 * @address 成都
 */
@Configuration
public class ShiroConfig {
    /**
     * 拦截器
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);//设置安全管理器
        /**
         * 添加过滤器
         * anon:无需认证即可访问
         * authc:必须认证才能访问
         * user:必须拥有"记住我"才能访问
         * perms:拥有对某个资源的权限才能访问
         * role:拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/shiro/index","anno");
        filterMap.put("/shiro/add", "authc");
        filterMap.put("/shiro/update", "perms[/shiro/update]");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        // 如果没有权限，跳转到登录页面
        shiroFilter.setLoginUrl("/shiro/to/login");
        // 如果没有授权，跳转到未授权页面
        shiroFilter.setUnauthorizedUrl("/shiro/401");
        return shiroFilter;
    }

    /**
     * 安全策略
     *
     * @param userRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);//关联UserRealm
        return securityManager;
    }

    /**
     * shiro和thymeleaf整合配置
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
