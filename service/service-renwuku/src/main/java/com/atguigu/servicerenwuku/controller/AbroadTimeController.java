package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.AbroadTime;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.AbroadTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "留学时间")
public class AbroadTimeController {
    @Autowired
    AbroadTimeService service;

    @PostMapping("/queryAbroadTime")
    @ApiOperation("查询留学时间")
    public ResultVo queryAbroadTime() {
        ResultVo<Object> resultVo = new ResultVo();
        List<AbroadTime> list = new ArrayList<>();
        try {
            list = service.queryAbroadTime();
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

}