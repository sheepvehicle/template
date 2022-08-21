package com.xd.asynctasks;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 短信工具类 异步任务
 */
@Component
@Slf4j
public class AsynchronousTasksService {
    //不用改
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    //这个需要自己的
    static final String accessKeyId = "LTAI5tQ7MAzRNCBNKjZgq2Yq";
    static final String accessKeySecret = "QflP0gp0DaCjST2Hrj3LYAhd4YiZQ4";
    static final String templateCode = "SMS_168825399";
    static final String signName = "快速指定文件夹清理";

    @Async
    public void sendSms(String telephone, String code) throws ClientException {
        // 可自助调整超时时间
        log.info("执行了任务");
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(telephone);
        request.setSignName(signName);

        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            log.info("短信发送成功！");
        } else {
            log.info("短信发送失败！");
            //统一异常类没有生效
            //throw new BusinessException("短信发送失败");
        }
    }

    /**
     * 每次调用生成一次四位数的随机数
     */
    public static String getFourCode() {
        Random random = new Random();
        return "" + (random.nextInt(8999) + 1000);
    }

    /**
     * 每次调用生成一次六位数的随机数
     */
    public static String getSixCode() {
        Random random = new Random();
        return "" + (random.nextInt(899999) + 100000);
    }
}
