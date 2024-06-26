package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Dept;
import com.atguigu.servicerenwuku.mapper.DeptMapper;
import com.atguigu.servicerenwuku.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    //查询所有部门
    @Override
    public List<Dept> queryAllDept() {
        return baseMapper.selectList(null);
    }

    //增加部门
    @Override
    public void addDept(Dept dept) {
        baseMapper.insert(dept);
    }

    //删除部门
    @Override
    public void deleteDept(String department_id) {
        baseMapper.deleteById(department_id);
    }

    //修改部门
    @Override
    public void updateDept(Dept dept) {
        baseMapper.updateById(dept);
    }
}
