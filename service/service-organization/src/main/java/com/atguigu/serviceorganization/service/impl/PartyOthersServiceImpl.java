package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.PartyEntity;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.DepartmentVo;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.PartyOthersDao;
import com.atguigu.serviceorganization.entity.PartyOthersEntity;
import com.atguigu.serviceorganization.service.PartyOthersService;

import java.util.List;


@Service("partyOthersService")
public class PartyOthersServiceImpl extends ServiceImpl<PartyOthersDao, PartyOthersEntity> implements PartyOthersService {

    @Autowired
    private PartyOthersDao partyOthersDao;

    @Override
    public PartyOthersEntity getPartyOthersById(String id) {
        QueryWrapper<PartyOthersEntity> wrapper = new QueryWrapper<>();
        PartyOthersEntity partyOthers = baseMapper.selectOne(wrapper.like("p_id", id));
        return partyOthers;
    }

    @Override
    public PartyOthersEntity getPartyOthersByName(String partyOthers) {
        QueryWrapper<PartyOthersEntity> wrapper = new QueryWrapper<>();
        PartyOthersEntity entity = baseMapper.selectOne(wrapper.like("other_party", partyOthers));
        return entity;
    }

    @Override
    public void getAllPartyOthersId(List<OrganizationVo> organizationVos) {
        List<PartyOthersEntity> list = baseMapper.selectList(new QueryWrapper<PartyOthersEntity>());
        extracted(organizationVos, list);
    }

    private void extracted(List<OrganizationVo> organizationVos, List<PartyOthersEntity> list) {
        for(PartyOthersEntity item: list){
            OrganizationVo vo = new OrganizationVo();
            vo.setDepartment(item.getOtherParty());
            vo.setId(item.getPId());
            organizationVos.add(vo);
        }
    }

    @Override
    public void getAllPartyOthersIdByName(List<OrganizationVo> organizationVos, String name) {
        List<PartyOthersEntity> list = baseMapper.selectList(new QueryWrapper<PartyOthersEntity>().like("other_party",name));
        extracted(organizationVos, list);
    }

    @Override
    public QueryResult queryPageBySearch(String name, String partyOthers, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<PartyVo> list = partyOthersDao.queryPageBySearch(name,partyOthers);
        PageInfo<PartyVo> info = new PageInfo<>(list);
        PageUtils pageUtils = new PageUtils(info.getList(), (int) info.getTotal(), limit,page);
        return new QueryResult(pageUtils);
    }
}