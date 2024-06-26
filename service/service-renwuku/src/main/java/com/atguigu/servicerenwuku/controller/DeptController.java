package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Dept;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.DeptService;
import com.atguigu.servicerenwuku.util.IdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags  = "二级党组织学院部门")
public class DeptController {
    @Autowired
    DeptService service;

    @ApiOperation(value = "查询所有部门")
    @PostMapping("/queryAllDept")//查询所有部门
    public ResultVo queryAllDept(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Dept> list=new ArrayList<>();
        try{
            list=service.queryAllDept();
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "增加部门")
    @PostMapping("/addDept")//增加部门
    public ResultVo addCurrentPosition(Dept dept){
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try{
            String id=String.valueOf(idWorker.nextId());
            dept.setDepartmentId(id);
            service.addDept(dept);
            resultVo.setMess("添加部门成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("添加部门失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除部门")
    @PostMapping("/deleteDept")  //根据id删除部门
    public ResultVo deleteDept(String department_id){
        department_id=department_id;
        ResultVo resultVo = new ResultVo();
        try{
            service.deleteDept(department_id);
            resultVo.setMess("删除部门成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除部门失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改部门")
    @PostMapping("/updateDept")  //修改部门
    public ResultVo updateDept(Dept dept){
        ResultVo resultVo = new ResultVo();
        try{
            service.updateDept(dept);
            resultVo.setMess("修改部门成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改部门失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


}
