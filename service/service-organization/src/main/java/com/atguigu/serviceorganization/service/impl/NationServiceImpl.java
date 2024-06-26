package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.atguigu.serviceorganization.vo.PersonVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.NationDao;
import com.atguigu.serviceorganization.entity.NationEntity;
import com.atguigu.serviceorganization.service.NationService;

import java.util.List;


@Service("nationService")
public class NationServiceImpl extends ServiceImpl<NationDao, NationEntity> implements NationService {

    @Autowired
    private NationDao nationDao;
    @Override
    public NationEntity getHanNation() {
        QueryWrapper<NationEntity> wrapper = new QueryWrapper<>();
        NationEntity entity = this.baseMapper.selectOne(wrapper.like("nation", "汉族"));
        return entity;
    }

    @Override
    public QueryResult queryPageBySearch(String name, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<PersonVo> list = nationDao.queryPageBySearch(name);
        PageInfo<PersonVo> info = new PageInfo<>(list);
        PageUtils pageUtils = new PageUtils(info.getList(), (int) info.getTotal(), limit,page);
        return new QueryResult(pageUtils);
    }
    
}