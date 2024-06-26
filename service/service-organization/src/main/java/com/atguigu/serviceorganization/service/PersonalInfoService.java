package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.PersonalInfoEntity;

import java.util.Map;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface PersonalInfoService extends IService<PersonalInfoEntity> {
    PersonalInfoEntity getPersonalInfoById(String id);

    PageUtils getAllStaffInfoByLessNation(String id, Map<String, Object> params);
}

