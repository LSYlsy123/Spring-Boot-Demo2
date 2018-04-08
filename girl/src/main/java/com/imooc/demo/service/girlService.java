package com.imooc.demo.service;

import com.imooc.demo.domain.girl;
import com.imooc.demo.enums.ResultEnum;
import com.imooc.demo.exception.girlException;
import com.imooc.demo.repository.girlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class girlService{

    @Autowired
    private girlRepository girlrepository;

    //@注释为事物控制
    @Transactional
    public void insertTwo(){

        girl Girl1=new girl();
        Girl1.setCupSize("A");
        Girl1.setAge(18);
        girlrepository.save(Girl1);

        girl Girl2=new girl();
        Girl2.setCupSize("E");
        Girl2.setAge(20);
        girlrepository.save(Girl2);
    }

    public void getAge(Integer id) throws Exception{

        girl Girl=girlrepository.getOne(id);
        Integer age=Girl.getAge();
        if(age<10){

            throw new girlException(ResultEnum.PRIMARY_SCHOOL);

        }else if(age>10&&age<16){

            throw new girlException(ResultEnum.MIDDLE_SCHOOL);

        }
    }

    public girl findOne(Integer id){
        return girlrepository.getOne(id);
    }
}
