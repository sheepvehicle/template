package com.xd.config;

import com.xd.realm.AccoutRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Scanner;

/**
 * shiro配置文件
 */
//@Configuration
public class ShiroConfig {

    @Bean
    public AccoutRealm accoutRealm() {
        return new AccoutRealm();
    }

    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("accoutRealm") AccoutRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        HashMap<String, String> hashMap = new HashMap<>();
//        authc表示会被拦截
//        hashMap.put("/main","authc");
//        hashMap.put("/user","authc");
        hashMap.put("/**","authc");
//        hashMap.put("/js/*.js","anon");
//        hashMap.put("/js/*.css","anon");
        hashMap.put("/js/**","anon");
        hashMap.put("/login/login","anon");
        hashMap.put("/register","anon");
        hashMap.put("/user","anon");
        hashMap.put("/index","anon");
        factoryBean.setFilterChainDefinitionMap(hashMap);
        factoryBean.setLoginUrl("/index");
        return factoryBean;
    }
}
