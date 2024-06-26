package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Dept;
import com.atguigu.servicerenwuku.entity.Party;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.DeptService;
import com.atguigu.servicerenwuku.service.PartyService;
import com.atguigu.servicerenwuku.util.IdWorker;
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
@RequestMapping("/service/party")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags  = "民主党派七个民主党派")
public class PartyController {
    @Autowired
    PartyService service;

    @ApiOperation(value = "查询所有党派")
    @PostMapping("/queryAllParty")//查询所有党派
    public ResultVo queryAllParty(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Party> list=new ArrayList<>();
        try{
            list=service.queryAllParty();
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

    @ApiOperation(value = "增加党派")
    @PostMapping("/addParty")//增加党派
    public ResultVo addParty(Party party){
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try{
            String id=String.valueOf(idWorker.nextId());
            party.setPartyId(id);
            service.addParty(party);
            resultVo.setMess("添加党派成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("添加党派失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除党派")
    @PostMapping("/deleteParty")  //根据id删除党派
    public ResultVo deleteParty(String party_id){
        party_id=party_id;
        ResultVo resultVo = new ResultVo();
        try{
            service.deleteParty(party_id);
            resultVo.setMess("删除党派成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除部门失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改党派")
    @PostMapping("/updateParty")  //修改党派
    public ResultVo updateParty(Party party){
        ResultVo resultVo = new ResultVo();
        try{
            service.updateParty(party);
            resultVo.setMess("修改党派成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改党派失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


}
