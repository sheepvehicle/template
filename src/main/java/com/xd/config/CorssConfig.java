package com.xd.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 该配置为前后端分离项目解决跨域问题的配置
 */
@Configuration
public class CorssConfig {

    // 当前跨域请求最大有效时长 这里默认一天
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //设置请求源地址
        corsConfiguration.addAllowedHeader("*"); // 设置请求头
        corsConfiguration.addAllowedMethod("*"); // 设置请求方法
        corsConfiguration.setMaxAge(MAX_AGE); //设置最大有效时长
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
