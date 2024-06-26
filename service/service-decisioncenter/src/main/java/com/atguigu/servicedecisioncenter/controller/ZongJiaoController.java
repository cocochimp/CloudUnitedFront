package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.ZongJiaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/service/servicedecisioncenter/ZongJiao")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "6、宗教接口")
public class ZongJiaoController {

    @Autowired
    ZongJiaoService service;

    ResultVo resultVo = new ResultVo();

    //1-1、查询年龄分布(无参)
    @ApiOperation(value = "1-1、年龄分布(主页)")
    @PostMapping("/queryAge")
    public ResultVo queryAge(){
        try{
            Map<String, AgeResult> integerList=service.queryAgeDistribution();

            List<String> key=new ArrayList<>(integerList.keySet());
            List<Object> value=new ArrayList<>(integerList.values());

            Map<String, List<Object>> map = new HashMap<>();
            map.put("age", Arrays.asList(key.toArray()));
            map.put("value",value);

            resultVo.setT(map);

//            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-2、查询年龄分布(有参)
    @ApiOperation(value = "1-2、年龄分布(点击学院分)")
    @PostMapping("/queryAge/{department}")
    public ResultVo queryAgeByDepartment(@PathVariable("department") String department){

        try{
            Map<String, AgeResult> integerList=service.queryAgeDistributionByDepartment(department);

            List<String> key=new ArrayList<>(integerList.keySet());
            List<Object> value=new ArrayList<>(integerList.values());

            Map<String, List<Object>> map = new HashMap<>();
            map.put("age", Arrays.asList(key.toArray()));
            map.put("value",value);

            resultVo.setT(map);

//            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
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


    //3-1、查询宗教分布(不带参)
    @ApiOperation(value = "3-1、宗教分布(主页)")
    @PostMapping("/queryReligion")
    public ResultVo queryReligion(){
        try{
            List<Map<String, Integer>> integerList=service.queryReligionDistribution();

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

    //3-2、查询宗教分布(带参)
    @ApiOperation(value = "3-2、宗教分布(点击学院分)")
    @PostMapping("/queryReligion/{department}")
    public ResultVo queryReligionByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String, Integer>> integerList=service.queryReligionDistributionByDepartment(department);

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

    //4、二级党组织分布(无参)
    @ApiOperation(value = "4、二级党组织分布(无参)")
    @PostMapping("/queryDepartment")
    public ResultVo queryDepartment(){
        try{
            List<String> integerList=service.queryDepartment();
            List<Integer> integers = service.queryDepartmentTotal();

            Map<String, List<Object>> map = new HashMap<>();

            map.put("department", Arrays.asList(integerList.toArray()));
            map.put("total",Arrays.asList(integers.toArray()));

            resultVo.setT(map);

//            resultVo.setT(integerList);
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
