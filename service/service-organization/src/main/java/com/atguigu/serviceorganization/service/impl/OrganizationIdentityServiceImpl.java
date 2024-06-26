package com.atguigu.serviceorganization.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.OrganizationIdentityDao;
import com.atguigu.serviceorganization.entity.OrganizationIdentityEntity;
import com.atguigu.serviceorganization.service.OrganizationIdentityService;


@Service("organizationIdentityService")
public class OrganizationIdentityServiceImpl extends ServiceImpl<OrganizationIdentityDao, OrganizationIdentityEntity> implements OrganizationIdentityService {


    @Override
    public OrganizationIdentityEntity getOrganizationIdentityById(String id) {
        QueryWrapper<OrganizationIdentityEntity> wrapper = new QueryWrapper<>();
        OrganizationIdentityEntity identityEntity = baseMapper.selectOne(wrapper.like("o_id", id));
        return identityEntity;
    }

}