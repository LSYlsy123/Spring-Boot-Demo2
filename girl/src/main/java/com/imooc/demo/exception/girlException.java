package com.imooc.demo.exception;

import com.imooc.demo.enums.ResultEnum;

//Spring只对RuntimeException异常进行回滚，不回滚Exception
public class girlException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public girlException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }
}
