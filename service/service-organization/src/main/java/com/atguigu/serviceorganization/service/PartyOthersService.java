package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.entity.PartyEntity;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.PartyOthersEntity;

import java.util.List;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface PartyOthersService extends IService<PartyOthersEntity> {
    PartyOthersEntity getPartyOthersById(String id);

    PartyOthersEntity getPartyOthersByName(String partyOthers);

    void getAllPartyOthersId(List<OrganizationVo> organizationVos);


    void getAllPartyOthersIdByName(List<OrganizationVo> organizationVos,String name);

    QueryResult queryPageBySearch(String name, String partyOthers, int page, int limit);
}

