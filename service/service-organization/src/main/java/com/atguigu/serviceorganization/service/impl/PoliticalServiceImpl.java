package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.DepartmentEntity;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.PoliticalDao;
import com.atguigu.serviceorganization.entity.PoliticalEntity;
import com.atguigu.serviceorganization.service.PoliticalService;

import java.util.List;


@Service("politicalService")
public class PoliticalServiceImpl extends ServiceImpl<PoliticalDao, PoliticalEntity> implements PoliticalService {

    @Autowired
    private PoliticalDao politicalDao;

    @Override
    public List<PoliticalEntity> getPoliticalByName(String category) {
        return baseMapper.selectList(new QueryWrapper<PoliticalEntity>().like("category",category));
    }

    @Override
    public void getAllPoliticalId(List<OrganizationVo> organizationVos) {
        List<PoliticalEntity> list = baseMapper.selectList(new QueryWrapper<PoliticalEntity>());
        extracted(organizationVos, list);
    }

    @Override
    public void getAllPoliticalIdByName(List<OrganizationVo> organizationVos, String name) {
        List<PoliticalEntity> list = baseMapper.selectList(new QueryWrapper<PoliticalEntity>().like("category",name));
        extracted(organizationVos, list);
    }

    private void extracted(List<OrganizationVo> organizationVos, List<PoliticalEntity> list) {
        for(PoliticalEntity item: list){
            OrganizationVo vo = new OrganizationVo();
            if(StringUtils.isNotEmpty(item.getPoliticalposition())) {
                vo.setDepartment(item.getPoliticalposition() + item.getCategory());
            }else{
                vo.setDepartment( item.getCategory());
            }
            vo.setId(item.getPoliticalpositionId());
            organizationVos.add(vo);
        }
    }

    @Override
    public QueryResult queryPageBySearch(String name, String category, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<PartyVo> list = politicalDao.queryPageBySearch(name,category);
        PageInfo<PartyVo> info = new PageInfo<>(list);
        PageUtils pageUtils = new PageUtils(info.getList(), (int) info.getTotal(), limit,page);
        return new QueryResult(pageUtils);
    }
}