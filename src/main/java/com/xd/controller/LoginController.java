package com.xd.controller;

import com.aliyuncs.exceptions.ClientException;
import com.xd.asynctasks.AsynchronousTasksService;
import com.xd.util.BusinessException;
import com.xd.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private AsynchronousTasksService asynchronousTasksService;

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

    @GetMapping("/{phone}")
    public Result sendSMS(@PathVariable String phone) {
        try {
            asynchronousTasksService.sendSms(phone, AsynchronousTasksService.getFourCode());
        } catch (ClientException e) {
          throw  new BusinessException("验证码输入有误");
        }
        return Result.success();
    }
}
