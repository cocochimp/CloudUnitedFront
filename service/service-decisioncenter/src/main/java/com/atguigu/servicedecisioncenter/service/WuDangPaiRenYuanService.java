package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WuDangPaiRenYuanService extends IService<Person> {

    List<Map<String,Integer>> queryDegreeDistribution(String other_party);
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(String other_party,String department);
    List<Map<String,Integer>> querySexDistribution(String other_party);
    List<Map<String,Integer>> querySexDistributionByDepartment(String other_party,String department);
    Map<String, AgeResult> queryAgeDistribution(String other_party);
    Map<String,AgeResult> queryAgeDistributionByDepartment(String other_party,String department);
    List<Map<String,Integer>> queryTitleDistribution(String other_party);
    List<Map<String,Integer>> queryTitleDistributionByDepartment(String other_party,String department);


    List<Map<String,Integer>> queryDegreeDistributionOfAbroad();
    List<Map<String,Integer>> queryDegreeDistributionByDepartmentOfAbroad(String department);
    List<Map<String,Integer>> querySexDistributionOfAbroad();
    List<Map<String,Integer>> querySexDistributionByDepartmentOfAbroad(String department);
    Map<String, AgeResult> queryAgeDistributionOfAbroad();
    Map<String,AgeResult> queryAgeDistributionByDepartmentOfAbroad(String department);
    List<Map<String,Integer>> queryTitleDistributionOfAbroad();
    List<Map<String,Integer>> queryTitleDistributionByDepartmentOfAbroad(String department);

    List<Map<String, Integer>> queryTimeOfAboard();

    List<Map<String, Integer>> queryTimeOfAboardByDepartment(String department);

    List<Map<String, Integer>> queryWuDangPaiLevel();

    List<Map<String, Integer>> queryWuDangPaiLevelByDepartment(String department);

    Map<String, Integer> queryZhiLianHuiCount();

    Map<String, Integer> queryZhiLianHuiCountByDepartment(String department);

    Map<String, Integer> queryWuDangPaiCount();

    Map<String, Integer> queryWuDangPaiCountByDepartment(String department);

    Map<String, Integer> queryCountOfAbroad();

    Map<String, Integer> queryCountOfAbroadByDepartment(String department);
}
