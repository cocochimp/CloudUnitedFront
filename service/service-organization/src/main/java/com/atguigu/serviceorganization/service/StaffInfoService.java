package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.entity.PoliticalEntity;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.StaffInfoEntity;

import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface StaffInfoService extends IService<StaffInfoEntity> {
    PageUtils getAllStaffInfoByDepartmentId(String id, Map<String, Object> params);

    PageUtils getAllStaffInfoByPartyId(String id, Map<String, Object> params);

    StaffInfoEntity getStaffInfoByPersonId(String id);

    PageUtils getAllStaffInfoByPartyOthersId(String id, Map<String, Object> params);

    PageUtils getAllStaffInfoByCategoryId(List<PoliticalEntity> categories, Map<String, Object> params);

    void getStaffInfoCount(OrganizationVo vo);



}

