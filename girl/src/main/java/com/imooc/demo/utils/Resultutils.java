package com.imooc.demo.utils;

import com.imooc.demo.domain.Result;

public class Resultutils {

    public static Result success(Object object){

        Result result=new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(String Msg,Integer code){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(Msg);
        return result;
    }
}
