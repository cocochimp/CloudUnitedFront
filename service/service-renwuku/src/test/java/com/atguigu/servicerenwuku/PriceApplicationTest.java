package com.atguigu.servicerenwuku;

import com.atguigu.servicerenwuku.service.RenwukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PriceApplicationTest {
    @Autowired
    RenwukuService service;

    /*@Test
    public void test(){
        service.queryPeopleByCondition()
    }*/
}

