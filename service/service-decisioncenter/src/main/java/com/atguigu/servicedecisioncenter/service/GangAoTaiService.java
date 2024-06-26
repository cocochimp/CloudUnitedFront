package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface GangAoTaiService extends IService<Person> {

    //1、年龄分布
    Map<String,AgeResult> queryAgeDistribution();
    Map<String,AgeResult> queryAgeDistributionByDepartment(String department);

    //2、性别分布
    List<Map<String,Integer>> querySexDistribution();
    List<Map<String,Integer>> querySexDistributionByDepartment(String department);

    //3、学历分布
    List<Map<String,Integer>> queryDegreeDistribution();
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(String department);

    //4、二级党组织分布
    List<Map<String,Integer>> queryDepartmentDistribution();
    List<Map<String,Integer>> queryDepartmentDistributionByDepartment(String department);

}
