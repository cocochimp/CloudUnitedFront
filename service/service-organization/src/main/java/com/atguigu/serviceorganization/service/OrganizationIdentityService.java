package com.atguigu.serviceorganization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.OrganizationIdentityEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 17:27:02
 */
public interface OrganizationIdentityService extends IService<OrganizationIdentityEntity> {
    OrganizationIdentityEntity getOrganizationIdentityById(String id);

}

