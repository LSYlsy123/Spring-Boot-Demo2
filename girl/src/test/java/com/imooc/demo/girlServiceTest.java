package com.imooc.demo;

import com.imooc.demo.domain.girl;
import com.imooc.demo.service.girlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class girlServiceTest {

    @Autowired
    private girlService girlservice;

    @Test
    @Transactional
    public void findOneTest(){
        girl Girl=girlservice.findOne(6);
        Assert.assertEquals(new Integer(30),Girl.getAge());
    }
}
