package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.PartyDao;
import com.atguigu.serviceorganization.entity.PartyEntity;
import com.atguigu.serviceorganization.service.PartyService;

import java.util.List;


@Service("partyService")
public class PartyServiceImpl extends ServiceImpl<PartyDao, PartyEntity> implements PartyService {

    @Autowired
    private PartyDao partyDao;

    @Override
    public PartyEntity getPartyById(String id) {
        QueryWrapper<PartyEntity> wrapper = new QueryWrapper<>();
        PartyEntity party = baseMapper.selectOne(wrapper.like("party_id", id));
        return party;
    }

    @Override
    public PartyEntity getPartyByName(String party) {
        QueryWrapper<PartyEntity> wrapper = new QueryWrapper<>();
        PartyEntity partyEntity = baseMapper.selectOne(wrapper.like("party", party));
        return partyEntity;
    }

    @Override
    public void getAllPartyId(List<OrganizationVo> organizationVos) {
        List<PartyEntity> list = baseMapper.selectList(new QueryWrapper<PartyEntity>());
        extracted(organizationVos, list);
    }

    private void extracted(List<OrganizationVo> organizationVos, List<PartyEntity> list) {
        for(PartyEntity item: list){
            OrganizationVo vo = new OrganizationVo();
            vo.setDepartment(item.getParty());
            vo.setId(item.getPartyId());
            organizationVos.add(vo);
        }
    }

    @Override
    public void getAllPartyIdByName(List<OrganizationVo> organizationVos, String name) {
        List<PartyEntity> list = baseMapper.selectList(new QueryWrapper<PartyEntity>().like("party",name));
        extracted(organizationVos, list);
    }

    @Override
    public QueryResult queryPageBySearch(String name, String party, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<PartyVo> list = partyDao.queryPageBySearch(name,party);
        PageInfo<PartyVo> info = new PageInfo<>(list);
        PageUtils pageUtils = new PageUtils(info.getList(), (int) info.getTotal(), limit,page);
        return new QueryResult(pageUtils);
    }
}