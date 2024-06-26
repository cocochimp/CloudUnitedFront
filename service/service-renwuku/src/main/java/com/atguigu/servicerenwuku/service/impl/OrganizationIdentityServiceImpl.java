package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.OrganizationIdentity;
import com.atguigu.servicerenwuku.mapper.OrganizationIdentityMapper;
import com.atguigu.servicerenwuku.service.OrganizationIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationIdentityServiceImpl extends ServiceImpl<OrganizationIdentityMapper, OrganizationIdentity> implements OrganizationIdentityService {
    @Override
    public List<OrganizationIdentity> queryAllOrganizationIdentity() {
        return baseMapper.selectList(null);
    }
}
