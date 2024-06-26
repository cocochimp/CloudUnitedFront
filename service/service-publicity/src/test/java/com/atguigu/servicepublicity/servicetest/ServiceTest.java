package com.atguigu.servicepublicity.servicetest;

import com.atguigu.servicepublicity.entity.Publicity;
import com.atguigu.servicepublicity.service.PublicityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private PublicityService publicityService;

    @Test
    public void insert(){
        Publicity p=new Publicity();
        p.setTitle("大学生创新创业国家级申报");
        p.setContent("2022届全国大学生创新创业申报书");
        p.setAuthor("test");
        p.setType("统战理论");
        publicityService.insert(p);
    }

    @Test
    public void delete(){
        publicityService.delete("1560136200906014722");
    }

    @Test
    public void selectByType(){
        Map map = publicityService.queryByType("统战理论", 1, 2);
        System.out.println(map);
    }

    @Test
    public void selectByTitle(){
        List<Publicity> publicities = publicityService.queryByTitle("挑战杯国家级");
        System.out.println(publicities);
    }

    @Test
    public void selectById(){
        Publicity publicity = publicityService.queryById("1560142284286738433");
        System.out.println(publicity);
    }

    @Test
    public void selectByPage(){
        Map map = publicityService.queryByPage(0, 3);
        System.out.println(map);
    }
}
