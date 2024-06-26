package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.WuDangPaiRenYuanMapper;
import com.atguigu.servicedecisioncenter.service.WuDangPaiRenYuanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WuDangPaiRenYuanImpl extends ServiceImpl<WuDangPaiRenYuanMapper, Person> implements WuDangPaiRenYuanService {
    @Override
    public List<Map<String, Integer>> queryDegreeDistribution(String other_party) {
        return baseMapper.queryDegreeDistribution(other_party);
    }

    @Override
    public List<Map<String, Integer>> queryDegreeDistributionByDepartment(String other_party, String department) {
        return baseMapper.queryDegreeDistributionByDepartment(other_party,department);
    }

    @Override
    public List<Map<String, Integer>> querySexDistribution(String other_party) {
        return baseMapper.querySexDistribution(other_party);
    }

    @Override
    public List<Map<String, Integer>> querySexDistributionByDepartment(String other_party, String department) {
        return baseMapper.querySexDistributionByDepartment(other_party,department);
    }

    @Override
    public Map<String, AgeResult> queryAgeDistribution(String other_party) {
        return baseMapper.queryAgeDistribution(other_party);
    }

    @Override
    public Map<String, AgeResult> queryAgeDistributionByDepartment(String other_party, String department) {
        return baseMapper.queryAgeDistributionByDepartment(other_party,department);
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistribution(String other_party) {
        return baseMapper.queryTitleDistribution(other_party);
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistributionByDepartment(String other_party, String department) {
        return baseMapper.queryTitleDistributionByDepartment(other_party,department);
    }

    @Override
    public List<Map<String, Integer>> queryDegreeDistributionOfAbroad() {
        return baseMapper.queryDegreeDistributionOfAbroad();
    }

    @Override
    public List<Map<String, Integer>> queryDegreeDistributionByDepartmentOfAbroad(String department) {
        return baseMapper.queryDegreeDistributionByDepartmentOfAbroad(department);
    }

    @Override
    public List<Map<String, Integer>> querySexDistributionOfAbroad() {
        return baseMapper.querySexDistributionOfAbroad();
    }

    @Override
    public List<Map<String, Integer>> querySexDistributionByDepartmentOfAbroad(String department) {
        return baseMapper.querySexDistributionByDepartmentOfAbroad(department);
    }

    @Override
    public Map<String, AgeResult> queryAgeDistributionOfAbroad() {
        return baseMapper.queryAgeDistributionOfAbroad();
    }

    @Override
    public Map<String, AgeResult> queryAgeDistributionByDepartmentOfAbroad(String department) {
        return baseMapper.queryAgeDistributionByDepartmentOfAbroad(department);
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistributionOfAbroad() {
        return baseMapper.queryTitleDistributionOfAbroad();
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistributionByDepartmentOfAbroad(String department) {
        return baseMapper.queryTitleDistributionByDepartmentOfAbroad(department);
    }

    @Override
    public List<Map<String, Integer>> queryTimeOfAboard() {
        return baseMapper.queryTimeOfAboard();
    }

    @Override
    public List<Map<String, Integer>> queryTimeOfAboardByDepartment(String department) {
        return baseMapper.queryTimeOfAboardByDepartment(department);
    }

    @Override
    public List<Map<String, Integer>> queryWuDangPaiLevel() {
        return baseMapper.queryWuDangPaiLevel();
    }

    @Override
    public List<Map<String, Integer>> queryWuDangPaiLevelByDepartment(String department) {
        return baseMapper.queryWuDangPaiLevelByDepartment(department);
    }

    @Override
    public Map<String, Integer> queryZhiLianHuiCount() {
        return baseMapper.queryZhiLianHuiCount();
    }

    @Override
    public Map<String, Integer> queryZhiLianHuiCountByDepartment(String department) {
        return baseMapper.queryZhiLianHuiCountByDepartment(department);
    }

    @Override
    public Map<String, Integer> queryWuDangPaiCount() {
        return baseMapper.queryWuDangPaiCount();
    }

    @Override
    public Map<String, Integer> queryWuDangPaiCountByDepartment(String department) {
        Map<String, Integer> wuDangPaiMap = baseMapper.queryWuDangPaiCountByDepartment(department);
        Map<String, Integer> zhiLianHuiMap = baseMapper.queryZhiLianHuiCountByDepartment(department);
        wuDangPaiMap.put("count",Integer.valueOf(String.valueOf(wuDangPaiMap.get("count")))+Integer.valueOf(String.valueOf(zhiLianHuiMap.get("count"))));
        return wuDangPaiMap;
    }

    @Override
    public Map<String, Integer> queryCountOfAbroad() {
        return baseMapper.queryCountOfAbroad();
    }

    @Override
    public Map<String, Integer> queryCountOfAbroadByDepartment(String department) {
        return baseMapper.queryCountOfAbroadByDepartment(department);
    }
}
