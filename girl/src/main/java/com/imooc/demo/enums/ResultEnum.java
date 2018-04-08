package com.imooc.demo.enums;

public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(200,"你可能还在上小学"),
    MIDDLE_SCHOOL(201,"你可能还在上初中"),

    ;

    private Integer code;

    private String Msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        Msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return Msg;
    }
}
