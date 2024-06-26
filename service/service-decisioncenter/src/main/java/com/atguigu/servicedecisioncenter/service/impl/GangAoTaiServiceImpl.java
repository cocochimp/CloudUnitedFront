package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.GangAoTaiMapper;
import com.atguigu.servicedecisioncenter.service.GangAoTaiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GangAoTaiServiceImpl extends ServiceImpl<GangAoTaiMapper, Person> implements GangAoTaiService {

    //1、年龄分布
    @Override
    public Map<String,AgeResult> queryAgeDistribution() {
        return baseMapper.queryAgeDistribution();
    }
    @Override
    public Map<String, AgeResult> queryAgeDistributionByDepartment(String department) {
        return baseMapper.queryAgeDistributionByDepartment(department);
    }

    //2、性别分布
    @Override
    public List<Map<String,Integer>> querySexDistribution() {
        return baseMapper.querySexDistribution();
    }
    @Override
    public List<Map<String, Integer>> querySexDistributionByDepartment(String department) {
        return baseMapper.querySexDistributionByDepartment(department);
    }

    //3、学历分布
    @Override
    public List<Map<String,Integer>> queryDegreeDistribution() {
        return baseMapper.queryDegreeDistribution();
    }
    @Override
    public List<Map<String, Integer>> queryDegreeDistributionByDepartment(String department) {
        return baseMapper.queryDegreeDistributionByDepartment(department);
    }

    //4、二级党组织分布
    @Override
    public List<Map<String,Integer>>  queryDepartmentDistribution() {
        return baseMapper.queryDepartmentDistribution();
    }
    @Override
    public List<Map<String, Integer>> queryDepartmentDistributionByDepartment(String department) {
        return baseMapper.queryDepartmentDistributionByDepartment(department);
    }


}
