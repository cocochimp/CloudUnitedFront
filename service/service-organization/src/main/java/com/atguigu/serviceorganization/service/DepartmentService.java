package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.extension.service.IService;

import com.atguigu.serviceorganization.entity.DepartmentEntity;

import java.util.List;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface DepartmentService extends IService<DepartmentEntity> {
    DepartmentEntity getDepartmentIdByName(String department);

    DepartmentEntity getDepartmentIdById(String id);

    void getAllDepartmentId(List<OrganizationVo> organizationVos);

    void getAllDepartmentIdByName(List<OrganizationVo> organizationVos,String name);

    QueryResult queryPageBySearch(String name,String department,int page, int limit);
}

