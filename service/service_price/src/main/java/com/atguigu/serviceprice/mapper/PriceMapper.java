package com.atguigu.serviceprice.mapper;

import com.atguigu.serviceprice.entity.Price;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PriceMapper extends BaseMapper<Price> {

    @Select("select * from huojiang_price where name=#{name} and id_delete=0")
    List<Price> selectByName(String name);

    @Select("select * from huojiang_price where p_priceName=#{pPriceName} and id_delete=0")
    List<Price> selectByPriceName(String pPriceName);

    @Select("select * from huojiang_price where p_priceName=#{pPriceName} and name=#{name} and id_delete=0")
    List<Price> selectByPriceAndName(String name,String pPriceName);
}
