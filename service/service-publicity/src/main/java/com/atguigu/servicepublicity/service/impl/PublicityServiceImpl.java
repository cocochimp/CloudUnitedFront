package com.atguigu.servicepublicity.service.impl;

import com.atguigu.servicepublicity.entity.Publicity;
import com.atguigu.servicepublicity.mapper.PublicityMapper;
import com.atguigu.servicepublicity.service.PublicityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublicityServiceImpl implements PublicityService {

    @Autowired
    private PublicityMapper publicityMapper;

    /*新增*/
    @Override
    public int insert(Publicity publicity) {
        publicity.setCreateTime(new Date());
        publicity.setModifiedTime(new Date());
        int insert = publicityMapper.insert(publicity);
        return insert;
    }

    /*删除*/
    @Override
    public int delete(String xid){
        int rows = publicityMapper.deleteById(xid);
        return rows;
    }

    /*修改*/
    @Override
    public int update(Publicity publicity) {
        publicity.setModifiedTime(new Date());
        int rows = publicityMapper.updateById(publicity);
        return rows;
    }

    /*查询全部*/
    @Override
    public List<Publicity> queryAll() {
        List<Publicity> publicities = publicityMapper.selectList(null);
        return publicities;
    }

    /*按照类型分页查询*/
    @Override
    public Map queryByType(String type,long current,long number) {
        IPage page=new Page(current,number);
        QueryWrapper qw=new QueryWrapper();
        qw.eq("type",type);
        qw.orderByDesc("modified_time");
        publicityMapper.selectPage(page,qw);
        long pages=page.getPages();
        List<Publicity> publicities=page.getRecords();
        long total=page.getTotal();
        Map map=new HashMap();
        map.put("page",pages);
        map.put("total",total);
        map.put("publicity",publicities);
        return map;
    }

    /*按照标题查询*/
    @Override
    public List<Publicity> queryByTitle(String title){
        QueryWrapper qw=new QueryWrapper();
        qw.like("title",title);
        qw.orderByDesc("modified_time");
        List<Publicity> list = publicityMapper.selectList(qw);
        return list;
    }

    /*按xid查询*/
    @Override
    public Publicity queryById(String xid) {
        Publicity publicity = publicityMapper.selectById(xid);
        return publicity;
    }

    /*分页查询*/
    @Override
    public Map queryByPage(long current, long number) {
        IPage page=new Page(current,number);
        publicityMapper.selectPage(page,null);
        long pages=page.getPages();
        List<Publicity> publicities=page.getRecords();
        long total=page.getTotal();
        Map map=new HashMap();
        map.put("page",pages);
        map.put("total",total);
        map.put("publicity",publicities);
        return map;
    }
}
