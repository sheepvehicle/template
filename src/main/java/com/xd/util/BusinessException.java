package com.xd.util;

/**
 * 自定义异常用于支持统一异常处理类
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String msg) {
        super(msg);
    }
}
