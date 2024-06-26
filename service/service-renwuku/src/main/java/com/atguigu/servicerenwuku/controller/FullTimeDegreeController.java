package com.atguigu.servicerenwuku.controller;

import com.atguigu.servicerenwuku.entity.Fulltimedegree;
import com.atguigu.servicerenwuku.entity.ResultVo;
import com.atguigu.servicerenwuku.service.FullTimeDegreeService;
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
@Api(tags  = "全日制学历")
public class FullTimeDegreeController {
    @Autowired
    FullTimeDegreeService service;

    @ApiOperation(value = "查询所有全日制学历")
    @PostMapping("/queryAllFullTimeDegree")//查询所有全日制学历
    public ResultVo queryAllDept(){
        ResultVo<Object> resultVo = new ResultVo();
        List<Fulltimedegree> list=new ArrayList<>();
        try{
            list=service.queryAllFullTimeDegree();
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


    @ApiOperation(value = "增加全日制学历")
    @PostMapping("/addFullTimeDegree")//增加全日制学历
    public ResultVo addFullTimeDegree(Fulltimedegree fulltimedegree){
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try{
            String id=String.valueOf(idWorker.nextId());
            fulltimedegree.setFulltimedegreeId(id);
            service.addFullTimeDegree(fulltimedegree);
            resultVo.setMess("添加全日制学历成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("添加全日制学历失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除全日制学历")
    @PostMapping("/deleteFullTimeDegree")  //根据id删除全日制学历
    public ResultVo deleteFullTimeDegree(String fulltimedegree_id){
        fulltimedegree_id=fulltimedegree_id;
        ResultVo resultVo = new ResultVo();
        try{
            service.deleteFullTimeDegree(fulltimedegree_id);
            resultVo.setMess("删除全日制学历成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除全日制学历失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改全日制学历")
    @PostMapping("/updateFullTimeDegree")  //修改全日制学历
    public ResultVo updateFullTimeDegree(Fulltimedegree fulltimedegree){
        ResultVo resultVo = new ResultVo();
        try{
            service.updateFullTimeDegree(fulltimedegree);
            resultVo.setMess("修改全日制学历成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改全日制学历失败");
            resultVo.setT(false);
        }
        return resultVo;
    }



}
