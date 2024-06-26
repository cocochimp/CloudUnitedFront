package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.mapper.OrganizationMapper;
import com.atguigu.serviceorganization.service.OrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Person> implements OrganizationService {


    @Override
    public List<Map<String, Integer>> queryDepartment(String department, int page, int limit) {
        return baseMapper.queryDepartment(department,page,limit);
    }

    @Override
    public Integer queryDepartmentCount(String department) {
        return baseMapper.queryDepartmentCount(department);
    }

    @Override
    public List<Map<String, Integer>> queryDepartmentByName(String department, String name, int page, int limit) {
        return baseMapper.queryDepartmentByName(department,name,page,limit);
    }

    @Override
    public Integer queryDepartmentByNameCount(String department, String name) {
        return baseMapper.queryDepartmentByNameCount(department,name);
    }

    @Override
    public List<Map<String, Integer>> queryParty(String party, int page, int limit) {
        return baseMapper.queryParty(party,page,limit);
    }

    @Override
    public Integer queryPartyCount(String party) {
        return baseMapper.queryPartyCount(party);
    }

    @Override
    public List<Map<String, Integer>> queryPartyByName(String party, String name, int page, int limit) {
        return baseMapper.queryPartyByName(party,name,page,limit);
    }

    @Override
    public Integer queryPartyByNameCount(String party, String name) {
        return baseMapper.queryPartyByNameCount(party,name);
    }

    @Override
    public List<Map<String, Integer>> queryNational(int page, int limit) {
        return baseMapper.queryNational(page,limit);
    }

    @Override
    public Integer queryNationalCount() {
        return baseMapper.queryNationalCount();
    }

    @Override
    public List<Map<String, Integer>> queryNationalByName(String name, int page, int limit) {
        return baseMapper.queryNationalByName(name,page,limit);
    }

    @Override
    public Integer queryNationalByNameCount(String name) {
        return baseMapper.queryNationalByNameCount(name);
    }

    @Override
    public List<Map<String, Integer>> queryPolitical(String category, int page, int limit) {
        return baseMapper.queryPolitical(category,page,limit);
    }

    @Override
    public Integer queryPoliticalCount(String category) {
        return baseMapper.queryPoliticalCount(category);
    }

    @Override
    public List<Map<String, Integer>> queryPoliticalByName(String category, String name, int page, int limit) {
        return baseMapper.queryPoliticalByName(category,name,page,limit);
    }

    @Override
    public Integer queryPoliticalByNameCount(String category, String name) {
        return baseMapper.queryPoliticalByNameCount(category,name);
    }

    @Override
    public void updatePersonal(Person_personal person_personal) {
        baseMapper.updatePersonal(person_personal);
    }

    @Override
    public void updateStaff(Person_staff person_staff) {
        baseMapper.updateStaff(person_staff);
    }


    @Override
    public void updateStaffZhiLianHui(Person_staff person_staff) {
        baseMapper.updateStaffZhiLianHui(person_staff);
    }

    @Override
    public void deletePersonal(String id) {
        baseMapper.deletePersonal(id);
    }

    @Override
    public void deleteStaff(String id) {
        baseMapper.deleteStaff(id);
    }

    @Override
    public List<Map<String, String>> queryChildrenByDepartment() {
        return baseMapper.queryChildrenByDepartment();
    }

    @Override
    public List<Map<String, String>> queryChildrenByParty() {
        return baseMapper.queryChildrenByParty();
    }

    @Override
    public List<Map<String, String>> queryChildrenByPartyOther() {
        return baseMapper.queryChildrenByPartyOther();
    }

    @Override
    public List<Map<String, String>> queryChildrenByPolitical() {
        return baseMapper.queryChildrenByPolitical();
    }

    @Override
    public void insertChildrenByDepartment(Department department) {
        baseMapper.insertChildrenByDepartment(department);
    }

    @Override
    public void insertChildrenByParty(Party party) {
        baseMapper.insertChildrenByParty(party);
    }

    @Override
    public void insertChildrenByPartyOther(PartyOthers partyothers) {
        baseMapper.insertChildrenByPartyOther(partyothers);
    }

    @Override
    public void insertChildrenByPolitical(Political political) {
        baseMapper.insertChildrenByPolitical(political);
    }

    @Override
    public void updateChildrenByDepartment(Department department) {
        baseMapper.updateChildrenByDepartment(department);
    }

    @Override
    public void updateChildrenByParty(Party party) {
        baseMapper.updateChildrenByParty(party);
    }

    @Override
    public void updateChildrenByPartyOther(PartyOthers partyothers) {
        baseMapper.updateChildrenByPartyOther(partyothers);
    }

    @Override
    public void updateChildrenByPolitical(Political political) {
        baseMapper.updateChildrenByPolitical(political);
    }

    @Override
    public void deleteChildrenByDepartment(Department department) {
        baseMapper.deleteChildrenByDepartment(department);
    }

    @Override
    public void deleteChildrenByParty(Party party) {
        baseMapper.deleteChildrenByParty(party);
    }

    @Override
    public void deleteChildrenByPartyOther(PartyOthers partyothers) {
        baseMapper.deleteChildrenByPartyOther(partyothers);
    }

    @Override
    public void deleteChildrenByPolitical(Political political) {
        baseMapper.deleteChildrenByPolitical(political);
    }

    @Override
    public List<Map<String, Integer>> queryAllZuZhi(int page, int limit) {
        return baseMapper.queryAllZuZhi(page,limit);
    }

    @Override
    public List<Map<String, Integer>> queryAllZuZhiCount() {
        return baseMapper.queryAllZuZhiCount();
    }

    @Override
    public List<Map<String, Integer>> queryZuZhiMoHu(String title, int page, int limit) {
        return baseMapper.queryZuZhiMoHu(title,page,limit);
    }

    @Override
    public List<Map<String, Integer>> queryZuZhiCountMoHu(String title) {
        return baseMapper.queryZuZhiCountMoHu(title);
    }

}
