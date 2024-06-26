package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.MinZuDangPaiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service/servicedecisioncenter/MinZuDangPai")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "2、民主党派接口")
public class MinZuDangPaiController {

    @Autowired
    MinZuDangPaiService service;

    ResultVo resultVo = new ResultVo();

    //1-1、查询年龄分布(不带参)
    @ApiOperation(value = "1-1、年龄分布(主页)")
    @PostMapping("/queryAge")
    public ResultVo queryAge(){
        try{
            Map<String, AgeResult> integerList=service.queryAgeDistribution();

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

    //1-3、成员数量 年龄分布 性别 学历 职称 各学院人员总数
    @ApiOperation(value = "1-3、成员数量 年龄分布 性别 学历 职称 各学院人员总数")
    @PostMapping("/queryCount")
    public ResultVo queryCount(){
        try{
            Integer count=service.queryCount();

            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-4、成员数量 年龄分布 性别 学历 职称 各学院人员总数
    @ApiOperation(value = "1-4、成员数量 年龄分布 性别 学历 职称 各学院人员总数")
    @PostMapping("/queryCountByDepartment")
    public ResultVo queryCountByDepartment(@PathVariable("department") String department){
        try{
            Integer count=service.queryCountByDepartment(department);

            resultVo.setT(count);
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

    //4-1、查询职称分布(无参)
    @ApiOperation(value = "4-1、职称分布(主页)")
    @PostMapping("/queryTitle")
    public ResultVo queryTitle(){
        try{
            List<Map<String, Integer>> integerList=service.queryTitleDistribution();

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

    //4-2、查询职称分布(有参)
    @ApiOperation(value = "4-2、职称分布(点击学院分)")
    @PostMapping("/queryTitle/{department}")
    public ResultVo queryTitleByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String,Integer>> integerList=service.queryTitleDistributionByDepartment(department);

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

    //5-1、成员数量
    @ApiOperation(value = "5-1、成员数量(主页)")
    @PostMapping("/MemberShip")
    public ResultVo MemberShip() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> memberShip = new ArrayList<>();
        List<Integer> memberShip1 = new ArrayList<>();
        try {
            parties = service.queryParties();
            memberShip1 = service.queryMemberShip();
            for (Integer integer : memberShip1) {
                memberShip.add(String.valueOf(integer));
            }
            map.put("parties", parties);
            map.put("memberShip", memberShip);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //5-2、成员数量通过部门热点
    @ApiOperation(value = "5-2、成员数量(点击学院分)")
    @PostMapping("/MemberShip/{department}")
    public ResultVo MemberShip(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> memberShip = new ArrayList<>();
        List<Integer> memberShip1 = new ArrayList<>();
        try {
            parties = service.queryParties();
            memberShip1 = service.queryMemberShipByDepartment(department);
            for (Integer integer : memberShip1) {
                memberShip.add(String.valueOf(integer));
            }
            map.put("parties", parties);
            map.put("memberShip", memberShip);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }




    //7-1、党外干部政治安排
    @ApiOperation(value = "7-1、党外干部政治安排(主页)")
    @PostMapping("/PoliticalArrangement")
    public ResultVo PoliticalArrangement() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> levels = new ArrayList<>();        //全国，省，市，县
        List<String> categories = new ArrayList<>();    //人大代表,政协委员
        List<Integer> count=new ArrayList<>();          //党外干部政治安排数量
        List<Integer> count1 = new ArrayList<>();        //不同级别人大代表数量
        List<Integer> count2 = new ArrayList<>();       //不同级别政协委员数量
        List<String>  renDa=new ArrayList<>();
        List<String>   zhenXie=new ArrayList<>();
        try {
            levels = service.queryLevels();            //查询不同级别党外干部政治安排全国，省，市，县
            categories = service.queryCategories();    //查询不同职位党外干部政治安排人大代表，政协委员
            count = service.queryPoliticalArrangementCount();      //查询党外干部政治安排数量
            count1=count.subList(0,4);           //查询不同级别人大代表数量
            count2=count.subList(4,8);        //查询不同级别政协委员数量
            for (Integer integer : count1) {
                renDa.add(String.valueOf(integer));
            }
            for (Integer integer:count2){
                zhenXie.add(String.valueOf(integer));
            }
            map.put("levels", levels);
            map.put("categories", categories);
            map.put("renda",renDa);
            map.put("zhenxie",zhenXie);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //7-2、党外干部政治安排
    @ApiOperation(value = "7-2、党外干部政治安排(点击学院分)")
    @PostMapping("/PoliticalArrangement/{department}")
    public ResultVo PoliticalArrangement(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> levels = new ArrayList<>();        //全国，省，市，县
        List<String> categories = new ArrayList<>();    //人大代表,政协委员
        List<Integer> count=new ArrayList<>();          //党外干部政治安排数量
        List<Integer> count1 = new ArrayList<>();        //不同级别人大代表数量
        List<Integer> count2 = new ArrayList<>();       //不同级别政协委员数量
        List<String>  renDa=new ArrayList<>();
        List<String>   zhenXie=new ArrayList<>();
        try {
            levels = service.queryLevels();            //查询不同级别党外干部政治安排全国，省，市，县
            categories = service.queryCategories();    //查询不同职位党外干部政治安排人大代表，政协委员
            count = service.queryPoliticalArrangementCountByDepartment(department);      //查询党外干部政治安排数量
            count1=count.subList(0,4);           //查询不同级别人大代表数量
            count2=count.subList(4,8);        //查询不同级别政协委员数量
            for (Integer integer : count1) {
                renDa.add(String.valueOf(integer));
            }
            for (Integer integer:count2){
                zhenXie.add(String.valueOf(integer));
            }
            map.put("levels", levels);
            map.put("categories", categories);
            map.put("renda",renDa);
            map.put("zhenxie",zhenXie);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //8-1、新发展成员数量
    @ApiOperation(value = "8-1、新发展成员数量(主页)")
    @PostMapping("/IncreaseCount")
    public ResultVo queryIncreaseCount() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> increaseCount = new ArrayList<>();
        List<Integer> increaseCount1 = new ArrayList<>();
        try {
            parties = service.queryParties();
            increaseCount1 = service.queryIncreaseCount();
            for (Integer integer : increaseCount1) {
                increaseCount.add(String.valueOf(integer));
            }
            map.put("parties", parties);
            map.put("increaseCount", increaseCount);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //8-2、新发展成员数量
    @ApiOperation(value = "8-2、新发展成员数量(点击学院分)")
    @PostMapping("/IncreaseCount/{department}")
    public ResultVo queryIncreaseCount(String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> increaseCount = new ArrayList<>();
        List<Integer> increaseCount1 = new ArrayList<>();
        try {
            parties = service.queryParties();
            increaseCount1 = service.queryIncreaseCountByDepartment(department);
            for (Integer integer : increaseCount1) {
                increaseCount.add(String.valueOf(integer));
            }
            map.put("parties", parties);
            map.put("increaseCount", increaseCount);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }


    @ApiOperation(value = "9-1 各学院人员数量")
    @PostMapping("/DepartmentCount")
    public ResultVo DepartmentCount() {
        ResultVo resultVo = new ResultVo();
        List<Map<String,Integer>> list;
        try {
            list=service.DepartmentCount();
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    @ApiOperation(value = "10 参政议政情况")
    @PostMapping("/politics")
    public ResultVo politics() {
        ResultVo resultVo = new ResultVo();
        Map<String,List<Integer>> map;
        try {
            List<Integer> yearList=service.queryYearOfPolitics();
            map=service.politics();
            map.put("年份",yearList);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

}
