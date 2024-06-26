package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.GangAoTaiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service/servicedecisioncenter/GangAoTai")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "5、港澳台接口")
public class GangAoTaiController {

    @Autowired
    GangAoTaiService service;

    ResultVo resultVo = new ResultVo();

    //1-1、查询年龄分布(不带参)
    @ApiOperation(value = "1-1、年龄分布(主页)")
    @PostMapping("/queryAge")
    public ResultVo queryAge(){
        try{
            Map<String,AgeResult> integerList=service.queryAgeDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-2、查询年龄分布(不带参)
    @ApiOperation(value = "1-2、年龄分布(点击学院分)")
    @PostMapping("/queryAge/{department}")
    public ResultVo queryAgeByDepartment(@PathVariable("department") String department){
        try{
            Map<String,AgeResult> integerList=service.queryAgeDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-1、查询性别分布(不带参)
    @ApiOperation(value = "2-1、性别分布(主页)")
    @PostMapping("/querySex")
    public ResultVo querySex(){
        try{
            List<Map<String, Integer>> integerList=service.querySexDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-2、查询性别分布(带参)
    @ApiOperation(value = "2-2、性别分布(点击学院分)")
    @PostMapping("/querySex/{department}")
    public ResultVo querySexByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String, Integer>> integerList=service.querySexDistributionByDepartment(department);
            System.out.println(service.querySexDistributionByDepartment(department));

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //3-1、查询学历分布(不带参)
    @ApiOperation(value = "3-1、学历分布(主页)")
    @PostMapping("/queryDegree")
    public ResultVo queryDegree(){
        try{
            List<Map<String, Integer>> integerList=service.queryDegreeDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //3-2、查询学历分布(带参)
    @ApiOperation(value = "3-2、学历分布(点击学院分)")
    @PostMapping("/queryDegree/{department}")
    public ResultVo queryDegreeByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String,Integer>> integerList=service.queryDegreeDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-1、查询二级党组织分布(不带参)
    @ApiOperation(value = "4-1、二级党组织分布(主页)")
    @PostMapping("/queryDepartment")
    public ResultVo queryDepartment(){
        try{
            List<Map<String, Integer>> integerList=service.queryDepartmentDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-2、查询二级党组织分布(带参)
    @ApiOperation(value = "4-2、二级党组织分布(点击学院分)")
    @PostMapping("/queryDepartment/{department}")
    public ResultVo queryDepartmentByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String,Integer>> integerList=service.queryDepartmentDistributionByDepartment(department);


            resultVo.setT(integerList);
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
