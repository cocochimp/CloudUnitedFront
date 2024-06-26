package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.JobLevel;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.JobLevelService;
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
@Api(tags  = "职位级别厅级科级处级")
public class JobLevelController {
    @Autowired
    JobLevelService service;

    @ApiOperation(value = "查询所有现任职位级别")
    @PostMapping("/queryAllJobLevel")//查询所有职位级别
    public ResultVo queryAllJobLevel(){
        ResultVo<Object> resultVo = new ResultVo();
        List<JobLevel> list=new ArrayList<>();
        try{
            list=service.queryAllJobLevel();
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

}
