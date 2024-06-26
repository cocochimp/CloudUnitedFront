package com.atguigu.serviceprice.mapper;

import com.atguigu.serviceprice.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    /*根据姓名查询*/
    @Select("select * from dangpai_personal_info where name=#{name}")
    List<Person> selectByName(String name);
}
