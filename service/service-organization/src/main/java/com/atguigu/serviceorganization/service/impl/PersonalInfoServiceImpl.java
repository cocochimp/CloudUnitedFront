package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.StaffInfoEntity;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.PersonalInfoDao;
import com.atguigu.serviceorganization.entity.PersonalInfoEntity;
import com.atguigu.serviceorganization.service.PersonalInfoService;

import java.util.List;
import java.util.Map;


@Service("personalInfoService")
public class PersonalInfoServiceImpl extends ServiceImpl<PersonalInfoDao, PersonalInfoEntity> implements PersonalInfoService {


    @Override
    public PersonalInfoEntity getPersonalInfoById(String id) {
        QueryWrapper<PersonalInfoEntity> wrapper = new QueryWrapper<>();
        PersonalInfoEntity info = baseMapper.selectOne(wrapper.like("id", id));
        return info;
    }

    @Override
    public PageUtils getAllStaffInfoByLessNation(String id, Map<String, Object> params) {
        QueryWrapper<PersonalInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.ne("nation_id", id);

        IPage<PersonalInfoEntity> page = this.page(
                new Query<PersonalInfoEntity>().getPage(params),
                wrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }
}