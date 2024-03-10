package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.PersonVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RenwukuTest {
    @Autowired
    RenwukuService service;
    @Test
    public void queryallpeople(){
        List<PersonVo> list=new ArrayList<>();
        list= service.queryallpeople();
        System.out.println(list.toString());
        return ;
    }
}
