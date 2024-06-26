package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Area;
import com.atguigu.servicerenwuku.entity.JobLevel;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.AreaService;
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
@Api(tags ="区域大陆，台湾区域，澳门区域，香港区域，台属")
public class AreaController {
    @Autowired
    AreaService service;

    @ApiOperation(value = "查询所有区域")
    @PostMapping("/queryAllAreas")//查询所有区域
    public ResultVo queryAllAreas(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Area> list=new ArrayList<>();
        try{
            list=service.queryAllAreas();
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
