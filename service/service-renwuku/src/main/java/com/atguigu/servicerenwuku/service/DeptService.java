package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DeptService extends IService<Dept> {
    //查询所有部门
    List<Dept> queryAllDept();
    //增加部门
    void addDept(Dept dept);
    //删除部门
    void deleteDept(String department_id);
    //修改部门
    void updateDept(Dept dept);
}
