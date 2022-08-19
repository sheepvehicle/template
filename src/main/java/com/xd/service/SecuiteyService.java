package com.xd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecuiteyService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;



    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        //查询数据库查看用户是否存在 抛异常
        if (!"admin".equals(username)) {//模拟从数据库中查询
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 2.把查询出来的密码(注册时就已经加密后存入数据库的)进行解析，或者直接把密码放入构造方法
        String password = passwordEncoder.encode("123");//将密码加密模拟数据中的密文
        // 赋予当前用户权限admin,normal权限 权限要是集合类型的
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc,ROLE_abcc"));
    }


}

