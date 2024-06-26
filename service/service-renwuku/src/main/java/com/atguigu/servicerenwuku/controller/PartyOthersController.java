package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.CurrentPosition;
import com.atguigu.servicerenwuku.entity.PartyOthers;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.CurrentPositionService;
import com.atguigu.servicerenwuku.service.PartyOthersService;
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
@Api(tags  = "民主党派外的类别无党派人士，知联会")
public class PartyOthersController {
    @Autowired
    PartyOthersService service;
    @ApiOperation(value = "查询民主党派之外的类别所有信息")
    @PostMapping("/queryAllPartyOthers")//查询民主党派之外的类别所有信息
    public ResultVo queryallPosition(){
        ResultVo<Object> resultVo = new ResultVo();
        List<PartyOthers> list=new ArrayList<>();
        try{
            list=service.queryAllPartyOthers();
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
