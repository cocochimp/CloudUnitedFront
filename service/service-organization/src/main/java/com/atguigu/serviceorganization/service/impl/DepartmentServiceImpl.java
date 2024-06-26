package com.atguigu.serviceorganization.service.impl;


import com.atguigu.serviceorganization.entity.PartyOthersEntity;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.DepartmentVo;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.DepartmentDao;
import com.atguigu.serviceorganization.entity.DepartmentEntity;
import com.atguigu.serviceorganization.service.DepartmentService;

import java.util.List;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public DepartmentEntity getDepartmentIdByName(String department) {
        QueryWrapper<DepartmentEntity> wrapper = new QueryWrapper<>();
        wrapper.like("department", department);
        DepartmentEntity departmentEntity = baseMapper.selectOne(wrapper);
        return departmentEntity;
    }

    @Override
    public DepartmentEntity getDepartmentIdById(String id) {
        QueryWrapper<DepartmentEntity> wrapper = new QueryWrapper<>();
        wrapper.like("department_id", id);
        DepartmentEntity departmentEntity = baseMapper.selectOne(wrapper);
        return departmentEntity;
    }

    @Override
    public void getAllDepartmentId(List<OrganizationVo> organizationVos) {
        List<DepartmentEntity> list = baseMapper.selectList(new QueryWrapper<DepartmentEntity>());
        extracted(list, organizationVos);
    }

    private void extracted(List<DepartmentEntity> list, List<OrganizationVo> organizationVos) {
        for (DepartmentEntity item : list) {
            OrganizationVo vo = new OrganizationVo();
            vo.setDepartment(item.getDepartment());
            vo.setId(item.getDepartmentId());
            organizationVos.add(vo);
        }
    }

    @Override
    public void getAllDepartmentIdByName(List<OrganizationVo> organizationVos,String name) {
        List<DepartmentEntity> list = baseMapper.selectList(new QueryWrapper<DepartmentEntity>().like("department",name));
        extracted(list, organizationVos);
    }

    @Override
    public QueryResult queryPageBySearch(String name,String department,int page, int limit) {
        PageHelper.startPage(page,limit);
        List<DepartmentVo> list = departmentDao.queryPageBySearch(name, department);
        PageInfo<DepartmentVo> info = new PageInfo<>(list);
        PageUtils pageUtils = new PageUtils(info.getList(), (int) info.getTotal(), limit,page);
        return new QueryResult(pageUtils);
    }
}