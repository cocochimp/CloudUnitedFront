package com.atguigu.serviceprice.service;

import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.entity.priceAndFile;

import java.util.List;
import java.util.Map;

public interface IPriceService {
    /*上传奖项*/
    void insertPrice(Price price);

    /*删除奖项*/
    void deletePrice(String pid);

    /*修改奖项*/
    void updatePrice(Price price);

    /*分页查询*/
    Map selectPrice(int current, int number);

    /*根据姓名查询*/
    List<Price> selectByName(String name);

    /*根据获奖名称查询*/
    List<Price> selectByPriceName(String pPriceName);

    /*根据姓名和获奖名称查询*/
    List<Price> selectByPriceAndName(String name,String pPriceName);

    /*按照姓名或获奖名称分页查询*/
    Map selectByNameOrPrice(String name,String price,long current,long number);

    /*根据id返回获奖信息*/
    priceAndFile selectById(String pid);
}
