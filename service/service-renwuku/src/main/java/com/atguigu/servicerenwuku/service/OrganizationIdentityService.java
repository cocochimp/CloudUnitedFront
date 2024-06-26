package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.CurrentPosition;
import com.atguigu.servicerenwuku.entity.OrganizationIdentity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OrganizationIdentityService extends IService<OrganizationIdentity> {
    List<OrganizationIdentity> queryAllOrganizationIdentity();
}
