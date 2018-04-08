package com.imooc.demo.controller;

import com.imooc.demo.domain.Result;
import com.imooc.demo.domain.girl;
import com.imooc.demo.repository.girlRepository;
import com.imooc.demo.service.girlService;
import com.imooc.demo.utils.Resultutils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class girlController {

    private final static Logger logger= LoggerFactory.getLogger(girlController.class);

    @Autowired
    private girlRepository girlrepository;

    @Autowired
    private girlService girlservice;

    /**
     *查询女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<girl> girlList(){

        return girlrepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     * @Valid后跟需要验证的对象
     */
    @PostMapping(value = "/girls")
    public Result<girl> girlAdd(@Valid girl Girl, BindingResult bindingResult){
        //如果验证错误，把错误信息返回
        if (bindingResult.hasErrors()){
            //System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //并返回空值
            //return null;
            //return bindingResult.getFieldError().getDefaultMessage();

            return Resultutils.error(bindingResult.getFieldError().getDefaultMessage(),0);
        }
        Girl.setAge(Girl.getAge());
        Girl.setCupSize(Girl.getCupSize());

        return Resultutils.success(girlrepository.save(Girl));
    }

    //查询一个女生
//    @GetMapping(value = "/girls/{id}")
//    public Optional<girl> girlFindOne(@PathVariable("id") Integer id){
//        return girlrepository.findById(id);
//    }

    //修改一个女生
    @PutMapping(value = "/girls/{id}")
    public girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        girl Girl=new girl();
        Girl.setId(id);
        Girl.setCupSize(cupSize);
        Girl.setAge(age);
        return girlrepository.save(Girl);
    }

    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlrepository.deleteById(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/{age}")
    public List<girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlrepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlservice.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{

        girlservice.getAge(id);

    }
}
