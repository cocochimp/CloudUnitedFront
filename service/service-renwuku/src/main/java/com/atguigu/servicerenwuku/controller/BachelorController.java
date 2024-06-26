package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Bachelor;
import com.atguigu.servicerenwuku.entity.Campus;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.BachelorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags ="学位")
public class BachelorController {
    @Autowired
    BachelorService service;


    @PostMapping("/queryBachelor")
    @ApiOperation("查询学位")
    public ResultVo queryBachelor(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Bachelor> list=new ArrayList<>();
        try{
            list=service.queryBachelor();
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