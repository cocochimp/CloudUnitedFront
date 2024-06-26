package com.atguigu.servicepublicity.mappertest;

import com.atguigu.servicepublicity.entity.Publicity;
import com.atguigu.servicepublicity.mapper.PublicityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {
    @Autowired
    private PublicityMapper publicityMapper;

    @Test
    public void test(){
        System.out.println("测试");
    }

    @Test
    public void insert(){
        Publicity p=new Publicity();
        p.setTitle("大学生创新创业国家级申报");
        p.setContent("2022届全国大学生创新创业申报书");
        p.setAuthor("test");
        p.setType("统战理论");
        publicityMapper.insert(p);
    }
}
