package com.imooc.demo.domain;

/**
 * http请求返回的最外层对象
 * @param <T>
 */

public class Result<T> {

    //错误码
    private Integer code;

    //提示信息
    private String Msg;

    //具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
