package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Bachelor;
import com.atguigu.servicerenwuku.entity.Politics;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.PoliticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags ="政治面貌")
public class PoliticsController {
    @Autowired
    PoliticsService service;


    @PostMapping("/queryPolitics")
    @ApiOperation("查询政治面貌")
    public ResultVo queryPolitics(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Politics> list=new ArrayList<>();
        try{
            list=service.queryPolitics();
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