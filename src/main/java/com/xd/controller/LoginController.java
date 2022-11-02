package com.xd.controller;

import com.aliyuncs.exceptions.ClientException;
import com.xd.GadUserInfo;
import com.xd.asynctasks.AsynchronousTasksService;
import com.xd.util.BusinessException;
import com.xd.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value="aa",produces="application/json;charset=utf-8")
    public Result adda(@RequestBody GadUserInfo userInfo){
        log.info(userInfo.toString());
        return Result.success();

    }
}
