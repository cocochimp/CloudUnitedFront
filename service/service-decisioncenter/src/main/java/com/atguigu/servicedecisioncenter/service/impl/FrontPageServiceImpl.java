package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.FrontPageMapper;
import com.atguigu.servicedecisioncenter.service.FrontPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FrontPageServiceImpl extends ServiceImpl<FrontPageMapper, Person> implements FrontPageService {

    @Override
    public Integer queryNationalDistributionOfTeacher() {
        return baseMapper.queryNationalDistributionOfTeacher();
    }

    @Override
    public Integer queryNationalDistributionOfTeacherByDepartment(String department) {
        return baseMapper.queryNationalDistributionOfTeacherByDepartment(department);
    }

    @Override
    public List<Integer> queryGangAoTaiDistribution() {
        return baseMapper.queryGangAoTaiDistribution();
    }

    @Override
    public List<Integer> queryGangAoTaiDistributionByDepartment(String department) {
        return baseMapper.queryGangAoTaiDistributionByDepartment(department);
    }

//    @Override
//    public List<Map<String, Integer>> queryGangAoTaiDistribution() {
//        return baseMapper.queryGangAoTaiDistribution();
//    }
//
//    @Override
//    public List<Map<String, Integer>> queryGangAoTaiDistributionByDepartment(String department) {
//        return baseMapper.queryGangAoTaiDistributionByDepartment(department);
//    }

    @Override
    public List<Integer> queryAwardCountryLevel() {
        return baseMapper.queryAwardCountryLevel();
    }

    @Override
    public List<Integer> queryAwardProvincialLevel() {
        return baseMapper.queryAwardProvincialLevel();
    }

    //查询统战工作对象
    @Override
    public List<Integer> queryWorkObject() {
        return baseMapper.queryWorkObject();
    }

    //通过部门查询统战工作对象
    @Override
    public List<Integer> queryWorkObjectByDepartment(String department) {
        return baseMapper.queryWorkObjectByDepartment(department);
    }

    //首页查询无党派，留学归国人员
    @Override
    public List<Map<String,Integer>> queryWuDangPai() {
        return baseMapper.queryWuDangPai();
    }

    //通过部门首页查询无党派，留学归国人员
    @Override
    public List<Map<String,Integer>> queryWuDangPaiByDepartment(String department) {
        return baseMapper.queryWuDangPaiByDepartment(department);
    }

    //首页查询两代表一委员
    @Override
    public List<Integer> queryLiangDaiBiao() {
        return baseMapper.queryLiangDaiBiao();
    }

    //首页通过部门查询两代表一委员
    @Override
    public List<Integer> queryLiangDaiBiaoByDepartment(String department) {
        return baseMapper.queryLiangDaiBiaoByDepartment(department);
    }


   // 9 全校统战人数
    @Override
    public List<Map<String,Integer>> totalCount() {
        return baseMapper.totalCount();
    }

    //参政议政情况
    @Override
    public List<Integer> politics() {
        return baseMapper.politics();
    }

    @Override
    public List<Map<String, Integer>> queryNonPartyCadres() {
        return baseMapper.queryNonPartyCadres();
    }

    @Override
    public List<Map<String, Integer>> queryNonPartyCadresByDepartment(String department) {
        return baseMapper.queryNonPartyCadresByDepartment(department);
    }

    @Override
    public List<String> queryQuanGuoRenDa() {
        return baseMapper.queryQuanGuoRenDa();
    }



    @Override
    public List<String> queryShiJiZhengXie() {
        return baseMapper.queryShiJiZhengXie();
    }

    @Override
    public List<String> queryShenJiZhengXie() {
        return baseMapper.queryShenJiZhengXie();
    }

    @Override
    public List<String> queryQuanGuoRenDaByDepartment(String department) {
        return baseMapper.queryQuanGuoRenDaByDepartment(department);
    }

    @Override
    public List<String> queryShiJiZhengXieByDepartment(String department) {
        return baseMapper.queryShiJiZhengXieByDepartment(department);
    }

    @Override
    public List<String> queryShenJiZhengXieByDepartment(String department) {
        return baseMapper.queryShenJiZhengXieByDepartment(department);
    }





    @Override
    public List<String> queryCountListOfLiangDaiBiao() {
        List<String> list=new ArrayList<>();
        List<Integer> integers=baseMapper.queryCountListOfLiangDaiBiao();
        for (Integer integer:integers){
            list.add(String.valueOf(integer));
        }
        return list;
    }

    @Override
    public List<String> queryCountListOfLiangDaiBiaoByDepartment(String department) {
        List<String> list=new ArrayList<>();
        List<Integer> integers=baseMapper.queryCountListOfLiangDaiBiaoByDepartment(department);
        for (Integer integer:integers){
            list.add(String.valueOf(integer));
        }
        return list;
    }

    @Override
    public Integer queryNationalDistributionOfStudent() {
        return baseMapper.queryNationalDistributionOfStudent();
    }

    @Override
    public Integer queryNationalDistributionOfStudentByDepartment(String department) {
        return baseMapper.queryNationalDistributionOfStudentByDepartment(department);
    }

    @Override
    public List<String> queryShiRenDa() {
        return baseMapper.queryShiRenDa();
    }

    @Override
    public List<String> queryShiRenDaByDepartment(String department) {
        return baseMapper.queryShiRenDaByDepartment(department);
    }




}
