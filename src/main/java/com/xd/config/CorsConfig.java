package com.xd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot  解决跨域-- 最新2.40版本以上得跨域
 */
//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override  // allowedOriginPatterns
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
                .allowedOriginPatterns("*") // 2.40 以上的
                //.allowedOrigins("*") // 2.40 一下的
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS","get","post","put","delete")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
