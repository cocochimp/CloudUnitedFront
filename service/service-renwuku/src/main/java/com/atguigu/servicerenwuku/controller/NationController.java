package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Nation;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.NationService;
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
@Api(tags  = "56个民族")
public class NationController {
    @Autowired
    NationService service;

    @ApiOperation(value = "查询所有民族")
    @PostMapping("/queryAllNations")//查询所有民族
    public ResultVo queryAllNations(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Nation> list=new ArrayList<>();
        try{
            list=service.queryAllNations();
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
