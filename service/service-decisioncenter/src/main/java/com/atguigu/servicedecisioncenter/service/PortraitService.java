package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.Person;

import java.util.List;
import java.util.Map;

public interface PortraitService {
    /*根据id查询信息*/
    Map<String,Object> selectPeopleById(String id);

    /*民主党派*/
    List<Person> queryDemocraticParties();

    /*非党派*/
    List<Person> queryNonPartisan();

    /*根据姓名查询*/
    List<Person> queryByName(String name);

    /*根据姓名模糊查询*/
    List<Person> fuzzyQueryByName(String name);
}
