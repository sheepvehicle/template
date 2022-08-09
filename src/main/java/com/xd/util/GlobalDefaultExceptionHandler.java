package com.xd.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * 统一异常处理类 ,异常待补充
 */
@ControllerAdvice  // controller 的 通知。。。 切面。。
public class GlobalDefaultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handleException(HttpServletRequest req, Exception ex) {
        //参数校验失败异常
        if (ex instanceof MethodArgumentNotValidException) {
            String message = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()).get(0);
            info(req, ex, "参数校验失败");
            return Result.error(message);
        }
        //业务异常
        if (ex instanceof BusinessException) {
            info(req, ex, "业务");
            return Result.error(ex.getMessage());
        }
        //非法参数异常异常
        if (ex instanceof IllegalStateException) {
            info(req, ex, "非法参数");
            return Result.error(ex.getMessage());
        }
        logger.error("系统错误！uri:{},错误信息:{}", req.getRequestURI(), ex.getMessage());
        return Result.error(ex.getMessage());
    }

    void info(HttpServletRequest req, Exception ex, String msg) {
        logger.error(msg + "异常！uri:{},错误信息:{}", req.getRequestURI(), ex.getMessage());
    }


}
