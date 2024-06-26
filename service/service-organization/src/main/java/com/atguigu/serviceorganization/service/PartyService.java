package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.PartyEntity;

import java.util.List;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface PartyService extends IService<PartyEntity> {
    PartyEntity getPartyById(String id);

    PartyEntity getPartyByName(String party);

    void getAllPartyId(List<OrganizationVo> organizationVos);

    void getAllPartyIdByName(List<OrganizationVo> organizationVos,String name);

    QueryResult queryPageBySearch(String name, String party, int page, int limit);

}

