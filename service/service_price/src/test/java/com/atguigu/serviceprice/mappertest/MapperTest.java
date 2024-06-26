package com.atguigu.serviceprice.mappertest;

import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.mapper.PersonMapper;
import com.atguigu.serviceprice.mapper.PriceMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
public class MapperTest {
    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private PersonMapper personMapper;

    /*测试插入*/
    @Test
    void test(){
        Price p=new Price();
        p.setId("3");
        p.setName("张丽");
        p.setPLevel("省级");
        p.setPPriceName("优秀教师");
        p.setPFid("1");
        Date date=new Date();
        p.setPUploadTime(date);
        p.setPModifiedTime(date);
        priceMapper.insert(p);
    }

    /*测试删除*/
    @Test
    void testDelete(){
        priceMapper.deleteById("1556915114420617217");
    }

    /*测试修改*/
    @Test
    void testModified(){
        Price p=new Price();
        p.setPid("1556920470857232386");
        p.setName("章时");
        p.setId("10");
        p.setPLevel("国家级");
        p.setPModifiedTime(new Date());
        priceMapper.updateById(p);
    }

    @Test
    void testPage(){
        IPage page=new Page(1,3);
        priceMapper.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testSelectByName(){
        System.out.println(priceMapper.selectByName("张丽"));
    }

    @Test
    void selectByPriceName(){
        System.out.println(priceMapper.selectByPriceName("优秀辅导员"));
    }

    @Test
    void selectByPriceAndName(){
        System.out.println(priceMapper.selectByPriceAndName("张丽","优秀教师"));
    }

    @Test
    void testPage2(){
        System.out.println("运行");
    }

    @Test
    void personall(){
        System.out.println(personMapper.selectList(null));
    }

    @Test
    void selectByName(){
        System.out.println(personMapper.selectByName("梁秀娟"));
    }

}
