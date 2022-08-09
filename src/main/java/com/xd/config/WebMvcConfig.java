package com.xd.config;


import com.xd.intercept.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 该配置可以配置拦截器等设置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截器拦截哪些,放行哪些
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/**");
        ;
    }

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();

    }
}
