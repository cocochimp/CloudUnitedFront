package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShaoShuMinZuService extends IService<Person> {

    List<Map<String,Integer>> queryDegreeDistribution();
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(String department);

    List<Map<String,Integer>> querySexDistribution();
    List<Map<String,Integer>> querySexDistributionByDepartment(String department);

    List<Map<String,Integer>> queryDepartmentDistribution();

    List<Map<String,Integer>> queryNationalDistribution();
    List<Map<String,Integer>> queryNationalDistributionByDepartment(String department);

    List<String> queryTotalTitle();
    List<String> queryTotalByDepartmentTitle(String department);
    List<Integer> queryTotalTotal();
    List<Integer> queryTotalByDepartmentTotal(String department);

    Integer queryCountOfTeacher();

    Integer queryCountOfTeacherByDepartment(String department);


    List<Map<String, Integer>> queryTitleDistribution();

    List<Map<String, Integer>> queryTitleDistributionByDepartment(String department);


}
