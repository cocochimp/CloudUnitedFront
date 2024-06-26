package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.WuDangPaiRenYuanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/service/servicedecisioncenter/WuDangPaiRenYuan")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "3、无党派、留学归国人员")
public class WuDangPaiRenYuanController {

    @Autowired
    WuDangPaiRenYuanService service;

    ResultVo resultVo = new ResultVo();

    //无党派人士、知联会
    //1-1、查询学历分布(一参)
    @ApiOperation(value = "1-1、学历分布(点击无党派人士、知联会分)")
    @PostMapping("/queryDegree/{other_party}")
    public ResultVo queryDegree(@PathVariable("other_party") String other_party) {
        try {
            List<Map<String, Integer>> integerList = service.queryDegreeDistribution(other_party);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.queryDegreeDistribution("知联会");
                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("total")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("total")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("total", integer1 + integer2);

                    integerList.set(i, map);
                }

            }
            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-2、查询学历分布(两参)
    @ApiOperation(value = "1-2、学历分布(点击无党派人士、知联会分)和(点击学院分)")
    @PostMapping("/queryDegree/{other_party}/{department}")
    public ResultVo queryDegreeByDepartment(@PathVariable("other_party") String other_party, @PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.queryDegreeDistributionByDepartment(other_party, department);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.queryDegreeDistributionByDepartment("知联会", department);
                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("total")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("total")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("total", integer1 + integer2);

                    integerList.set(i, map);
                }

            }
            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-1、查询性别分布(一参)
    @ApiOperation(value = "2-1、性别分布(点击无党派人士、知联会分)")
    @PostMapping("/querySex/{other_party}")
    public ResultVo querySex(@PathVariable("other_party") String other_party) {
        try {
            List<Map<String, Integer>> integerList = service.querySexDistribution(other_party);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.querySexDistribution("知联会");

                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("total")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("total")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("total", integer1 + integer2);

                    integerList.set(i, map);
                }
            }
            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-2、查询性别分布(两参)
    @ApiOperation(value = "2-2、性别分布(点击无党派人士、知联会分)和(点击学院分)")
    @PostMapping("/querySex/{other_party}/{department}")
    public ResultVo querySexByDepartment(@PathVariable("other_party") String other_party, @PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.querySexDistributionByDepartment(other_party, department);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.querySexDistributionByDepartment("知联会", department);

                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("total")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("total")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("total", integer1 + integer2);

                    integerList.set(i, map);
                }
            }

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //3-1、查询年龄分布(一参)
    @ApiOperation(value = "3-1、年龄分布(点击无党派人士、知联会分)")
    @PostMapping("/queryAge/{other_party}")
    public ResultVo queryAge(@PathVariable("other_party") String other_party) {
        try {
            Map<String, AgeResult> integerList = service.queryAgeDistribution(other_party);


            List<String> key = new ArrayList<>(integerList.keySet());
            List<Object> value = new ArrayList<>(integerList.values());

            if (other_party.equals("无党派人士")) {
                Map<String, AgeResult> zhilianhui = service.queryAgeDistribution("知联会");
                List<Object> valueZhilianhui = new ArrayList<>(zhilianhui.values());

                for (int i = 0; i < integerList.size(); i++) {
                    Integer value1 = Integer.valueOf(String.valueOf(value.get(i)));
                    Integer value2 = Integer.valueOf(String.valueOf(valueZhilianhui.get(i)));
                    Integer sum = value2 + value1;

                    value.set(i, sum);
                }
            }

            Map<String, List<Object>> map = new HashMap<>();
            map.put("age", Arrays.asList(key.toArray()));
            map.put("value", value);


            resultVo.setT(map);

//            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //3-2、查询年龄分布(两参)
    @ApiOperation(value = "3-2、年龄分布(点击无党派人士、知联会分)和(点击学院分)")
    @PostMapping("/queryAge/{other_party}/{department}")
    public ResultVo queryAgeByDepartment(@PathVariable("other_party") String other_party, @PathVariable("department") String department) {

        try {
            Map<String, AgeResult> integerList = service.queryAgeDistributionByDepartment(other_party, department);

            List<String> key = new ArrayList<>(integerList.keySet());
            List<Object> value = new ArrayList<>(integerList.values());


            if (other_party.equals("无党派人士")) {
                Map<String, AgeResult> zhilianhui = service.queryAgeDistributionByDepartment("知联会",department);
                List<Object> valueZhilianhui = new ArrayList<>(zhilianhui.values());

                for (int i = 0; i < integerList.size(); i++) {
                    Integer value1 = Integer.valueOf(String.valueOf(value.get(i)));
                    Integer value2 = Integer.valueOf(String.valueOf(valueZhilianhui.get(i)));
                    Integer sum = value2 + value1;

                    value.set(i, sum);
                }
            }
            Map<String, List<Object>> map = new HashMap<>();
            map.put("age", Arrays.asList(key.toArray()));
            map.put("value", value);

            resultVo.setT(map);

//            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-1、查询职称分布(一参)
    @ApiOperation(value = "4-1、职称分布(点击无党派人士、知联会分)")
    @PostMapping("/queryTitle/{other_party}")
    public ResultVo queryTitle(@PathVariable("other_party") String other_party) {
        try {
            List<Map<String, Integer>> integerList = service.queryTitleDistribution(other_party);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.queryTitleDistribution("知联会");

                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("count")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("count")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("count", integer1 + integer2);

                    integerList.set(i, map);
                }
            }

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-2、查询职称分布(两参)
    @ApiOperation(value = "4-2、职称分布(点击无党派人士、知联会分)和(点击学院分)")
    @PostMapping("/queryTitle/{other_party}/{department}")
    public ResultVo queryTitleByDepartment(@PathVariable("other_party") String other_party, @PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.queryTitleDistributionByDepartment(other_party, department);

            if (other_party.equals("无党派人士")) {
                List<Map<String, Integer>> zhilianhui = service.queryTitleDistributionByDepartment("知联会", department);

                for (int i = 0; i < integerList.size(); i++) {
                    Integer integer1 = Integer.valueOf(String.valueOf(integerList.get(i).get("count")));
                    Integer integer2 = Integer.valueOf(String.valueOf(zhilianhui.get(i).get("count")));

                    Map<String, Integer> map = integerList.get(i);
                    map.put("count", integer1 + integer2);

                    integerList.set(i, map);
                }
            }

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }
    //5-2无党派人员级别分布
    @ApiOperation(value = "5-1 无党派人员级别分布")
    @PostMapping("/queryWuDangPaiLevel")
    public ResultVo queryWuDangPaiLevel(){
        try{
            List<Map<String,Integer>> integerList=service.queryWuDangPaiLevel();
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

    //5-1无党派人员级别分布(带参)
    @ApiOperation(value = "5-1 无党派人员级别分布(带参)")
    @PostMapping("/queryWuDangPaiLevel/{department}")
    public ResultVo queryWuDangPaiLevel(String department){
        try{
            List<Map<String,Integer>> integerList=service.queryWuDangPaiLevelByDepartment(department);
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

   //6-1 知联会总数(无参)
   @ApiOperation(value = "6-1 知联会总数(无参)")
   @PostMapping("/queryZhiLianHuiCount")
   public ResultVo queryZhiLianHuiCount(){
       try{
           Map<String,Integer> map=new HashMap<>();
           map=service.queryZhiLianHuiCount();
           resultVo.setT(map);
           resultVo.setMess("查询成功");
           resultVo.setOk(true);
       } catch (Exception e){
           e.printStackTrace();
           resultVo.setMess("查询失败");
           resultVo.setT(false);
       }
       return resultVo;
   }

    //6-2 知联会总数(带参)
    @ApiOperation(value = "6-2 知联会总数(带参)")
    @PostMapping("/queryZhiLianHuiCountByDepartment/{department}")
    public ResultVo queryZhiLianHuiCountByDepartment(String department){
        try{
            Map<String,Integer> map=new HashMap<>();
            map=service.queryZhiLianHuiCountByDepartment(department);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //6-3 无党派总数(无参)
    @ApiOperation(value = "6-3 无党派总数(无参)")
    @PostMapping("/queryWuDangPaiCount")
    public ResultVo queryWuDangPaiCount(){
        try{
            Map<String,Integer> map=new HashMap<>();
            map=service.queryWuDangPaiCount();
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //6-4 无党派总数(带参)
    @ApiOperation(value = "6-4 无党派总数(带参)")
    @PostMapping("/queryWuDangPaiCountByDepartment/{department}")
    public ResultVo queryWuDangPaiCountByDepartment(String department){
        try{
            Map<String,Integer> map=new HashMap<>();
            map=service.queryWuDangPaiCountByDepartment(department);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }



    //留学人士
    //1-1、查询学历分布(无参)
    @ApiOperation(value = "1-3、学历分布(点击留学归国人员分)")
    @PostMapping("/queryDegreeOfAboard")
    public ResultVo queryDegreeOfAbroad(){
        try{
            List<Map<String,Integer>> integerList=service.queryDegreeDistributionOfAbroad();

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

    //1-2、查询学历分布(有参)
    @ApiOperation(value = "1-4、学历分布(点击留学归国人员分)和(点击学院分)")
    @PostMapping("/queryDegreeOfAboard/{department}")
    public ResultVo queryDegreeOfAboardByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String,Integer>> integerList=service.queryDegreeDistributionByDepartmentOfAbroad(department);

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

    //2-1、查询性别分布(无参)
    @ApiOperation(value = "2-3、性别分布(点击留学归国人员分)")
    @PostMapping("/querySexOfAboard")
    public ResultVo querySexOfAboard(){
        try{
            List<Map<String, Integer>> integerList=service.querySexDistributionOfAbroad();

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

    //2-2、查询性别分布(有参)
    @ApiOperation(value = "2-4、性别分布(点击留学归国人员分)和(点击学院分)")
    @PostMapping("/querySexOfAboard/{department}")
    public ResultVo querySexOfAboardByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String, Integer>> integerList=service.querySexDistributionByDepartmentOfAbroad(department);

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

    //3-1、查询年龄分布(无参)
    @ApiOperation(value = "3-3、年龄分布(点击留学归国人员分)")
    @PostMapping("/queryAgeOfAboard")
    public ResultVo queryAgeOfAboard(){
        try{
            Map<String, AgeResult> integerList=service.queryAgeDistributionOfAbroad();

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

    //3-2、查询年龄分布(有参)
    @ApiOperation(value = "3-4、年龄分布(点击留学归国人员分)和(点击学院分)")
    @PostMapping("/queryAgeOfAboard/{department}")
    public ResultVo queryAgeOfAboardByDepartment(@PathVariable("department") String department){
        try{
            Map<String, AgeResult> integerList=service.queryAgeDistributionByDepartmentOfAbroad(department);

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

    //4-1、查询职称分布(无参)
    @ApiOperation(value = "4-3、职称分布(点击留学归国人员分)")
    @PostMapping("/queryTitleOfAboard")
    public ResultVo queryTitleOfAboard(){
        try{
            List<Map<String, Integer>> integerList=service.queryTitleDistributionOfAbroad();

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
    @ApiOperation(value = "4-4、职称分布(点击留学归国人员分)和(点击学院分)")
    @PostMapping("/queryTitleOfAboard/{department}")
    public ResultVo queryTitleOfAboardByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String,Integer>> integerList=service.queryTitleDistributionByDepartmentOfAbroad(department);

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


    //5留学时间分布（无参）
    @ApiOperation(value = "5留学时间分布（无参）")
    @PostMapping("/queryTimeOfAboard")
    public ResultVo queryTimeOfAboard(){
        try{
            List<Map<String, Integer>> integerList=service.queryTimeOfAboard();

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

    //5留学时间分布（有参）
    @ApiOperation(value = "5留学时间分布（带参）")
    @PostMapping("/queryTimeOfAboardByDepartment/{department}")
    public ResultVo queryTimeOfAboardByDepartment(@PathVariable("department") String department){
        try{
            List<Map<String, Integer>> integerList=service.queryTimeOfAboardByDepartment(department);

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
    //6-1 留学归国总数(无参)
    @ApiOperation(value = "6-1 留学归国总数(无参)")
    @PostMapping("/queryCountOfAbroad")
    public ResultVo queryCountOfAbroad(){
        try{
            Map<String,Integer> map=new HashMap<>();
            map=service.queryCountOfAbroad();
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //6-2 留学归国总数(带参)
    @ApiOperation(value = "6-2 留学归国总数(带参)")
    @PostMapping("/queryCountOfAbroadByDepartment/{department}")
    public ResultVo queryCountOfAbroadByDepartment(String department){
        try{
            Map<String,Integer> map=new HashMap<>();
            map=service.queryCountOfAbroadByDepartment(department);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }



}
