package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.entity.Title;
import com.atguigu.servicerenwuku.service.TitleService;
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
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags= "职称")
public class TitleController {
    @Autowired
    TitleService service;

    @ApiOperation(value = "查询所有职称")
    @PostMapping("/queryAllTitle")//查询所有职称
    public ResultVo queryAllTitle(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Title> list=new ArrayList<>();
        try{
            list=service.queryAllTitle();
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

    @ApiOperation(value = "增加职称")
    @PostMapping("/addTitle")//增加职称
    public ResultVo addTitle(Title title){
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try{
            String id=String.valueOf(idWorker.nextId());
            title.setTitleId(id);
            service.addTitle(title);
            resultVo.setMess("添加职称成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("添加职称失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除全日制学历")
    @PostMapping("/deleteTitle")  //根据id删除全日制学历
    public ResultVo deleteTitle(String title_id){
        title_id=title_id;
        ResultVo resultVo = new ResultVo();
        try{
            service.deleteTitle(title_id);
            resultVo.setMess("删除职称成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除全日制学历失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改职称")
    @PostMapping("/updateTitle")  //修改职称
    public ResultVo updateTitle(Title title){
        ResultVo resultVo = new ResultVo();
        try{
            service.updateTitle(title);
            resultVo.setMess("修改职称成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改职称失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


}
