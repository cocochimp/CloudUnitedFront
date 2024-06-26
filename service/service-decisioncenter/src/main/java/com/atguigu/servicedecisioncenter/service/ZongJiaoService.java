package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface ZongJiaoService extends IService<Person> {

    Map<String, AgeResult> queryAgeDistribution();
    Map<String,AgeResult> queryAgeDistributionByDepartment(String department);

    List<Map<String,Integer>> querySexDistribution();
    List<Map<String,Integer>> querySexDistributionByDepartment(String department);

    List<Map<String,Integer>> queryReligionDistribution();
    List<Map<String,Integer>> queryReligionDistributionByDepartment(String department);

    List<String> queryDepartment();
    List<Integer> queryDepartmentTotal();

}
