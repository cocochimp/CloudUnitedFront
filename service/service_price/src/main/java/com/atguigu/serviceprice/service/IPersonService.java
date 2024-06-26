package com.atguigu.serviceprice.service;

import com.atguigu.serviceprice.entity.Person;

import java.util.List;
import java.util.Map;

public interface IPersonService {
    /*分页查询*/
    Map selectPerson(int current, int number);

    /*查询全部*/
    List<Person> selectList();

    /*根据姓名查询*/
    List<Person> selectByName(String name);
}
