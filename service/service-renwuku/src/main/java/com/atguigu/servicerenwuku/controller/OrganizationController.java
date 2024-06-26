package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.OrganizationIdentity;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.OrganizationIdentityService;
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
@Api(tags ="组织身份管理员和普通成员")
public class OrganizationController {
    @Autowired
    OrganizationIdentityService service;
    @ApiOperation(value = "查询组织身份管理员和普通成员")
    @PostMapping("/queryAllOrganizationIdentity")//查询组织身份管理员和普通成员
    public ResultVo queryAllOrganizationIdentity(){
        ResultVo<Object> resultVo = new ResultVo();
        List<OrganizationIdentity> list=new ArrayList<>();
        try{
            list=service.queryAllOrganizationIdentity();
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
