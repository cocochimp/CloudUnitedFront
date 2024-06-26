package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.ShaoShuMinZuMapper;
import com.atguigu.servicedecisioncenter.service.ShaoShuMinZuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShaoShuMinZuServiceImpl extends ServiceImpl<ShaoShuMinZuMapper, Person> implements ShaoShuMinZuService {
    @Override
    public List<Map<String, Integer>> queryDegreeDistribution() {
        return baseMapper.queryDegreeDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryDegreeDistributionByDepartment(String department) {
        return baseMapper.queryDegreeDistributionByDepartment(department);
    }

    @Override
    public List<Map<String, Integer>> querySexDistribution() {
        return baseMapper.querySexDistribution();
    }

    @Override
    public List<Map<String, Integer>> querySexDistributionByDepartment(String department) {
        return baseMapper.querySexDistributionByDepartment(department);
    }

    @Override
    public List<Map<String, Integer>> queryDepartmentDistribution() {
        return baseMapper.queryDepartmentDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryNationalDistribution() {
        return baseMapper.queryNationalDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryNationalDistributionByDepartment(String department) {
        return baseMapper.queryNationalDistributionByDepartment(department);
    }

    @Override
    public List<String> queryTotalTitle() {
        return baseMapper.queryTotalTitle();
    }

    @Override
    public List<String> queryTotalByDepartmentTitle(String department) {
        return baseMapper.queryTotalByDepartmentTitle(department);
    }

    @Override
    public List<Integer> queryTotalTotal() {
        return baseMapper.queryTotalTotal();
    }

    @Override
    public List<Integer> queryTotalByDepartmentTotal(String department) {
        return baseMapper.queryTotalByDepartmentTotal(department);
    }

    @Override
    public Integer queryCountOfTeacher() {
        return baseMapper.queryCountOfTeacher();
    }

    @Override
    public Integer queryCountOfTeacherByDepartment(String department) {
        return baseMapper.queryCountOfTeacherByDepartment(department);
    }



    @Override
    public List<Map<String, Integer>> queryTitleDistribution() {
        return baseMapper.queryTitleDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistributionByDepartment(String department) {
        return baseMapper.queryTitleDistributionByDepartment(department);
    }




}
