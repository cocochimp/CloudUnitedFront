package com.atguigu.serviceprice.servertest;

import com.atguigu.serviceprice.entity.Person;
import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.entity.PriceFile;
import com.atguigu.serviceprice.service.IPersonService;
import com.atguigu.serviceprice.service.IPriceFileService;
import com.atguigu.serviceprice.service.IPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ServerTest {

    @Autowired
    private IPriceService priceService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IPriceFileService priceFileService;

    @Test
    void test(){
        Price price=new Price();
        price.setName("田强");
        price.setId("10");
        price.setPPriceName("优秀教师");
        price.setPLevel("省级");
        price.setPFid("00001");
        priceService.insertPrice(price);
    }

    @Test
    void testDelete(){
        priceService.deletePrice("1556917001278603266");
    }

    @Test
    void testUpdate(){
        Price p=new Price();
        p.setPid("1556920470857232386");
        p.setName("李将");
        p.setId("00001");
        p.setPPriceName("优秀辅导员");
        p.setPModifiedTime(new Date());
        priceService.updatePrice(p);
    }

    @Test
    void testPageSelect(){
        Map map = priceService.selectPrice(1, 3);
        System.out.println(map);
    }

    @Test
    void selectByName(){
        System.out.println(personService.selectByName("梁秀娟"));
    }

    @Test
    void selectByPriceName(){
        System.out.println(priceService.selectByPriceName("优秀教师"));
    }

    @Test
    void selectByPriceNameAndName(){
        System.out.println(priceService.selectByPriceAndName("张丽","优秀教师"));
    }

    @Test
    void selectPersonByPage(){
        System.out.println(personService.selectPerson(1,3));
    }

    @Test
    void selectList(){
        System.out.println(personService.selectList());
    }

    @Test
    void insertFile(){
        PriceFile priceFile=new PriceFile();
        priceFile.setFName("优秀教师证书");
        priceFile.setFPath("D://temp");
        priceFile.setPid("001");
        priceFileService.insertPriceFile(priceFile);
    }

    @Test
    void selectByname(){
        List<Person> a = personService.selectByName("梁秀娟");
        System.out.println(a);
    }

    @Test
    void selectBynameOrPrice(){
        String name="张丽";
        String price=null;
        long current=1;
        long number=3;
        Map map = priceService.selectByNameOrPrice(name, price, current, number);
        System.out.println(map);
    }
}
