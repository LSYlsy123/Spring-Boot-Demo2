package com.imooc.demo.handle;

import com.imooc.demo.domain.Result;
import com.imooc.demo.exception.girlException;
import com.imooc.demo.utils.Resultutils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if (e instanceof girlException){
            girlException girlexception=(girlException)e;
            return Resultutils.error(girlexception.getMessage(),girlexception.getCode());
        }else {
            logger.error("[系统异常]{}",e);
            return Resultutils.error("未知错误", -1);
        }
    }

}
