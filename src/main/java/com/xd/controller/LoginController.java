package com.xd.controller;

import com.xd.util.Result;
import lombok.experimental.Accessors;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginController {
    @RequestMapping("/login")
    public Result login(/**User user**/) {
        /**
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPwd());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Result.error();
        }
         */
        return Result.success();

    }
}
