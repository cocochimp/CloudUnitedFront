package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface MinZuDangPaiService extends IService<Person> {

    Map<String, AgeResult> queryAgeDistribution();
    Map<String,AgeResult> queryAgeDistributionByDepartment(String department);

    List<Map<String,Integer>> querySexDistribution();
    List<Map<String,Integer>> querySexDistributionByDepartment(String department);

    List<Map<String,Integer>> queryDegreeDistribution();
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(String department);

    List<Map<String,Integer>> queryTitleDistribution();
    List<Map<String,Integer>> queryTitleDistributionByDepartment(String department);

    List<Integer> queryMemberShip();
    List<Integer> queryIncreaseCount();
    List<Integer> queryMemberShipByDepartment(String department);
    List<Integer> queryIncreaseCountByDepartment(String department);


    List<String> queryParties();
    List<String> queryLevels();
    List<String> queryCategories();
    List<Integer> queryPoliticalArrangementCount();
    List<Integer> queryPoliticalArrangementCountByDepartment(String department);



    Integer queryCount();

    Integer queryCountByDepartment(String department);

    List<Map<String, Integer>> DepartmentCount();

    List<Integer> queryYearOfPolitics();

    Map<String, List<Integer>> politics();
}
