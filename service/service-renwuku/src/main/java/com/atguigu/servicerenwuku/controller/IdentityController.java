package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.Identity;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.IdentityService;
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
@Api(tags ="身份教师或者学生")
public class IdentityController {
    @Autowired
    IdentityService service;

    @ApiOperation(value = "查询所有身份")
    @PostMapping("/queryAllIdentities")//查询所有身份教师或者学生
    public ResultVo queryAllIdentities(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Identity> list=new ArrayList<>();
        try{
            list=service.queryAllIdentities();
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
