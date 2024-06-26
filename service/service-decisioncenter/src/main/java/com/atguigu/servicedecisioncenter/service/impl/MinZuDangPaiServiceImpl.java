package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.MinZuDangPaiMapper;
import com.atguigu.servicedecisioncenter.service.MinZuDangPaiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MinZuDangPaiServiceImpl extends ServiceImpl<MinZuDangPaiMapper, Person> implements MinZuDangPaiService {


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
    public List<Map<String, Integer>> queryDegreeDistribution() {
        return baseMapper.queryDegreeDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryDegreeDistributionByDepartment(String department) {
        return baseMapper.queryDegreeDistributionByDepartment(department);
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistribution() {
        return baseMapper.queryTitleDistribution();
    }

    @Override
    public List<Map<String, Integer>> queryTitleDistributionByDepartment(String department) {
        return baseMapper.queryTitleDistributionByDepartment(department);
    }

    //成员数量
    @Override
    public List<Integer> queryMemberShip() {
        return baseMapper.queryMemberShip();
    }



    @Override
    public List<Integer> queryMemberShipByDepartment(String department) {
        return baseMapper.queryMemberShipByDepartment(department);
    }


    @Override
    public List<Integer> queryIncreaseCountByDepartment(String department) {
        return baseMapper.queryIncreaseCountByDepartment(department);
    }


    @Override
    public List<String> queryParties() {
        return baseMapper.queryParties();
    }

    @Override
    public List<String> queryLevels() {
        return baseMapper.queryLevels();
    }

    @Override
    public List<String> queryCategories() {
        return baseMapper.queryCategories();
    }

    @Override
    public List<Integer> queryPoliticalArrangementCount() {
        return baseMapper.queryPoliticalArrangementCount();
    }

    @Override
    public List<Integer> queryPoliticalArrangementCountByDepartment(String department) {
        return baseMapper.queryPoliticalArrangementCountByDepartment(department);
    }



    @Override
    public Integer queryCount() {
        return baseMapper.queryCount();
    }

    @Override
    public Integer queryCountByDepartment(String department) {
        return baseMapper.queryCountByDepartment(department);
    }

    @Override
    public List<Map<String, Integer>> DepartmentCount() {
        return baseMapper.DepartmentCount();
    }

    @Override
    public List<Integer> queryYearOfPolitics() {
        return baseMapper.queryYearOfPolitics();
    }

    @Override
    public Map<String, List<Integer>> politics() {
        Map<String, List<Integer>> map=new HashMap<>();
        List<Integer> countList=baseMapper.queryPolitics();
        List<String>  partyList=baseMapper.queryParties();
        int i=0;
        for(String party:partyList){
            map.put(party,countList.subList(i,i+3));
            i+=3;
        }
        return map;
    }


    //查询新发展成员数量
    @Override
    public List<Integer> queryIncreaseCount() {
        return baseMapper.queryIncreaseCount();
    }
}
