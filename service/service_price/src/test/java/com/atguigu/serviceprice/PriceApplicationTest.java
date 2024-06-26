package com.atguigu.serviceprice;

import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class PriceApplicationTest {
    @Autowired
    private PriceMapper priceMapper;

    @Test
    void test(){
        Price p=new Price();
        p.setId("1");
        p.setPPriceName("先进个人");
//        p.setPFilePath("D://file//temp");
        Date date=new Date();
        p.setPUploadTime(date);
        priceMapper.insert(p);
    }
}
