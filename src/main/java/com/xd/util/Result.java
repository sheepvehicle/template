package com.xd.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 返回json数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //支持链式编程
public class Result {
    private Integer status;   //状态码 , //0--失败， 1--成功
    private long total;   //返回数据的总长度
    private Object data;    //返回的数据
    private Object rows;    //bootStrapTable返回的数据
    private String message;     //当前json信息描述
    public static final Integer RESPONSE_SUCCESS=0;//成功
    public static final Integer RESPONSE_FAIL=1;//失败
    /**
     * 操作成功,没有数据返回,携带自定义描述信息
     */
    public static Result success(String message) {
        return new Result().setStatus(RESPONSE_SUCCESS).setMessage(message);
    }
    /**
     * 操作成功,有数据返回,携带自定义描述信息
     */
    public static Result success(Object data, String message) {
        return new Result().setStatus(RESPONSE_SUCCESS).setMessage(message).setData(data);
    }
    /**
     * 接口请求成功,有数据返回
     */
    public static Result success(Object data) {
        return new Result().setStatus(RESPONSE_SUCCESS).setData(data).setMessage("");
    }
    /**
     * 分页查询接口请求成功,有数据返回
     */
//    public static Result success(PageInfo data) {
//        return new Result().setStatus(RESPONSE_SUCCESS).setData(data.getList()).setTotal(data.getTotal()).setMessage("");
//    }
    /**
     * bootStrapTable分页查询返回接口
     * 请求成功,返回 map对象
     */
//    public static Result RowsSuccess(PageInfo data) {
//        return new Result().setStatus(RESPONSE_SUCCESS).setRows(data.getList()).setTotal(data.getTotal()).setMessage("");
//    }
    public static Result RowsSuccess(Object data,Integer total) {
        return new Result().setStatus(RESPONSE_SUCCESS).setRows(data).setTotal(total).setMessage("");
    }
    /**
     * 请求成功
     */
    public static Result success() {
        return new Result().setStatus(RESPONSE_SUCCESS).setMessage("");
    }
    /**
     * 操作失败,携带自定义状态码和描述信息
     */
    public static Result error(Integer code, String message) {
        return new Result().setStatus(code).setMessage(message);
    }
    /**
     * 操作失败,没有数据,携带自定义描述信息
     */
    public static Result error(String message) {
        return new Result().setStatus(RESPONSE_FAIL).setMessage(message);
    }
    /**
     * 操作失败
     */
    public static Result error() {
        return new Result().setStatus(RESPONSE_FAIL).setMessage("");
    }

}
