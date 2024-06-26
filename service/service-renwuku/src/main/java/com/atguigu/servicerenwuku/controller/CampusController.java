package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.Campus;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.CampusService;
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
@Api(tags ="校区：主校区海滨校区阳江校区霞山校区")
public class CampusController {
    @Autowired
    CampusService service;

    @ApiOperation(value = "查询所有校区")
    @PostMapping("/queryAllCampuses")//查询所有校区
    public ResultVo queryAllCampuses(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Campus> list=new ArrayList<>();
        try{
            list=service.queryAllCampuses();
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
