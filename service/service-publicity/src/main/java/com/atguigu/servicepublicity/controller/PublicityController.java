package com.atguigu.servicepublicity.controller;

import com.atguigu.commonutils.R;
import com.atguigu.servicepublicity.entity.Publicity;
import com.atguigu.servicepublicity.entity.ResultVo;
import com.atguigu.servicepublicity.service.PublicityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publicity/servicepublicity/publicity")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api("统战宣传")
@EnableSwagger2
public class PublicityController {
    @Autowired
    private PublicityService publicityService;

    @ApiOperation(value = "新增统战宣传信息")
    @PostMapping("/insertPublicity")
    public ResultVo insertPublicity(Publicity publicity){
        ResultVo resultVo=new ResultVo();
        try {
            publicityService.insert(publicity);
            resultVo.setMess("新增成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("新增失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "删除统战宣传信息")
    @PostMapping("/deletePublicity")
    public ResultVo deletePublicity(String xid){
        ResultVo resultVo=new ResultVo();
        try {
            publicityService.delete(xid);
            resultVo.setMess("删除成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改统战宣传信息")
    @PostMapping("/updatePublicity")
    public ResultVo updatePublicity(Publicity publicity){
        ResultVo resultVo=new ResultVo();
        Publicity p=new Publicity();
        p.setXid(publicity.getXid());
        if (publicity.getTitle()!=null){
            p.setTitle(publicity.getTitle());
        }
        if (publicity.getContent()!=null){
            p.setContent(publicity.getContent());
        }
        if (publicity.getAuthor()!=null){
            p.setAuthor(publicity.getAuthor());
        }
        if (publicity.getType()!=null){
            p.setType(publicity.getType());
        }
        try {
            publicityService.update(p);
            resultVo.setMess("修改成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "查询所有宣传信息")
    @PostMapping("/selectAll")
    public ResultVo selectAll(){
        ResultVo resultVo=new ResultVo();
        try {
            List<Publicity> publicities = publicityService.queryAll();
            resultVo.setT(publicities);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("修改失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "按照类型查询")
    @PostMapping("/selectByType")
    public ResultVo selectByType(String type,long current,long number){
        ResultVo resultVo=new ResultVo();
        try{
            Map map = publicityService.queryByType(type, current, number);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
        }
        return resultVo;
    }

    @ApiOperation(value = "按照标题查询")
    @PostMapping("/selectByTitle")
    public ResultVo selectByTitle(String title){
        ResultVo resultVo=new ResultVo();
        try{
            List<Publicity> publicities=publicityService.queryByTitle(title);
            resultVo.setT(publicities);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value="按照xid查询")
    @PostMapping("/selectByXid")
    public ResultVo selectByXid(String xid){
        ResultVo resultVo=new ResultVo();
        try {
            Publicity publicity = publicityService.queryById(xid);
            resultVo.setT(publicity);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/selectByPage")
    public ResultVo selectByPage(long current,long number){
        ResultVo resultVo=new ResultVo();
        try {
            Map map = publicityService.queryByPage(current, number);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

}
