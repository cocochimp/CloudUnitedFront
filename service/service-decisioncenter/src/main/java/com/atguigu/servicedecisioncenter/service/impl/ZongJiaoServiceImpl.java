package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.ZongJiaoMapper;
import com.atguigu.servicedecisioncenter.service.ZongJiaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ZongJiaoServiceImpl extends ServiceImpl<ZongJiaoMapper, Person> implements ZongJiaoService {


    @Override
    public Map<String, AgeResult> queryAgeDistribution() {
        return baseMapper.queryAgeDistribution();
    }

    @Override
    public Map<String, AgeResult> queryAgeDistributionByDepartment(String department) {
        return baseMapper.queryAgeDistributionByDepartment(department);
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
    public List<Map<String, Integer>> queryReligionDistribution() {
        return baseMapper.queryReligionDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryReligionDistributionByDepartment(String department) {
        return baseMapper.queryReligionDistributionByDepartment(department);
    }

    @Override
    public List<String> queryDepartment() {
        return baseMapper.queryDepartment();
    }

    @Override
    public List<Integer> queryDepartmentTotal() {
        return baseMapper.queryDepartmentTotal();
    }
}
