package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.*;
import com.atguigu.servicerenwuku.service.CurrentPositionService;
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
@Api(tags ="现任职务如专任教师，教辅人员，行政人员，其他")
public class CurrentPositionController {
    @Autowired
    CurrentPositionService service;
    @ApiOperation(value = "查询所有现任职位")
    @PostMapping("/queryAllCurrentPosition")//查询所有现任职位
    public ResultVo queryallPosition(){
        ResultVo<Object> resultVo = new ResultVo();
        List<CurrentPosition> list=new ArrayList<>();
        try{
            list=service.queryAllCurrentPosition();
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

    @ApiOperation(value = "增加现任职位")
    @PostMapping("/addCurrentPosition")//增加现任职位
    public ResultVo addCurrentPosition(CurrentPosition currentPosition){
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try{
            String id=String.valueOf(idWorker.nextId());
            currentPosition.setCurrentPositionId(id);
            service.addCurrentPosition(currentPosition);
            resultVo.setMess("添加现任职务成员成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("添加现任职位失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除现任职务")
    @PostMapping("/deleteCurrentPosition")  //根据id删除现任职务
    public ResultVo deleteCurrentPosition(String currentPosition_id){
        currentPosition_id=currentPosition_id;
        ResultVo resultVo = new ResultVo();
        try{
            service.deleteCurrentPosition(currentPosition_id);
            resultVo.setMess("删除现任职务成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除现任职务失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改现任职务")
    @PostMapping("/updateCurrentPosition")  //修改现任职务
    public ResultVo updateCurrentPosition(CurrentPosition currentPosition){
        ResultVo resultVo = new ResultVo();
        try{
            service.updateCurrentPosition(currentPosition);
            resultVo.setMess("修改现任职务成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改现任职务失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


}
