package com.xd.config;

/*
import com.xd.handler.ErrorAuthenticationFailureHandler;
import com.xd.handler.SucceedAuthenticationSuccessHandler;
import com.xd.service.SecuiteyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


//@Configuration
//@EnableWebSecurity    // 添加 security 过滤器
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)    // 启用方法级别的权限认证
public class SecuityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SecuiteyService secuiteyService;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 自动建表，第一次启动的时候需要建表，第二次启动的时候需要注释掉
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login.html").//设置自定义页面
                usernameParameter("username").// 自定义的登录参数 请求中的用户名是什么 就写什么
                passwordParameter("password").// 自定义的登录参数 请求中的用户名是什么 就写什么
                loginProcessingUrl("/login").//请求登录的url  当发现/login时认为是登录，必须和表单提交的地址一样，去执行UserDetailsServiceImpl
//                successForwardUrl("/success").//登录成功后的页面 必须是post请求
//                failureForwardUrl("/er");//登录失败后的页面 必须是post请求
        successHandler(new SucceedAuthenticationSuccessHandler("http://www.baidu.com")).//成功跳转到自定义成功页面
                failureHandler(new ErrorAuthenticationFailureHandler("http://www.baidu.com")); //失败跳转到自定义失败页面

        //授权认证
        http.authorizeRequests().
                antMatchers("/login.html", "/er", "/js/**", "**\*.js").permitAll().//放行的请求
                antMatchers("/success").anonymous().//允许匿名访问
                antMatchers("/er").hasAuthority("admin").//具有什么权限可以访问一个
                antMatchers("/toError").
                hasAnyAuthority("/admin", "toError", "ROLE_admin").//具有什么权限什么角色可以访问该url
                antMatchers("/toMain").hasRole("admin").//什么角色可以访问
                antMatchers("toWin").hasIpAddress("127.0.0.1").//哪些ip可以访问
                anyRequest().authenticated(); //除以上的请求所有请求都拦截
//                anyRequest().access("@myServiceImpl.hasPermission(request,authentication)"); //调用自定义权限控制的类和方法

        http.cors();//允许跨域，配置后SpringSecurity会自动寻找name=corsConfigurationSource的Bean
        http.csrf().disable();//关闭CSRF防御

        http.rememberMe().
                rememberMeParameter("remember").//提交是记住我功能时的属性值,提交登录时要提交一个remember属性值为boolean
                tokenValiditySeconds(60).//设置默认时间
                userDetailsService(secuiteyService). //自定义的登录逻辑
                tokenRepository(persistentTokenRepository); //持久层对象

        http.logout().logoutUrl("/logout");//退出登录的请求路径
    }

    //因为数据库中的密码不可能是明文 所以需要一个 密码编码器
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/

class SecuityConfig{}
