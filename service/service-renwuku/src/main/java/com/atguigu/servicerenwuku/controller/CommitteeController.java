package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Committee;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.CommitteeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags  = "委员会主委副主委委员")
public class CommitteeController {
    @Autowired
    CommitteeService service;
    @ApiOperation(value = "查询所有委员会")
    @PostMapping("/queryCommittee")//查询所有委员会
    public ResultVo queryCommittee(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Committee> list=new ArrayList<>();
        try{
            list=service.queryCommittee();
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
