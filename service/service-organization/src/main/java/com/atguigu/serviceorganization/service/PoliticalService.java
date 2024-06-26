package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.PoliticalEntity;

import java.io.Serializable;
import java.util.List;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface PoliticalService extends IService<PoliticalEntity> {
    List<PoliticalEntity> getPoliticalByName(String category);

    void getAllPoliticalId(List<OrganizationVo> organizationVos);

    void getAllPoliticalIdByName(List<OrganizationVo> organizationVos,String name);

    QueryResult queryPageBySearch(String name, String category, int page, int limit);
}

