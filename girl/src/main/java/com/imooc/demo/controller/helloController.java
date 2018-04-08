package com.imooc.demo.controller;

import com.imooc.demo.properties.girlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    girlProperties girlproperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return girlproperties.getCupSize();
    }

}
