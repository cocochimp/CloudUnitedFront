package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Political;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.PoliticalService;
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
@Api(tags  = "政治安排 人大代表，政协委员 党代表")
public class PoliticalController {
    @Autowired
    PoliticalService service;
    @ApiOperation(value = "查询所有政治安排")
    @PostMapping("/queryAllPolitical")//查询所有政治安排
    public ResultVo queryAllPolitical(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Political> list=new ArrayList<>();
        try{
            list=service.queryAllPolitical();
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
