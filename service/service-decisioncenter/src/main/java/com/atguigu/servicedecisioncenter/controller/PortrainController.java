package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.PortraitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service/servicedecisioncenter/portrain")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "7、人物画像接口")
@Slf4j
public class PortrainController {
    @Autowired
    private PortraitService portraitService;

    /*姓名模糊查询*/
    @ApiOperation(value = "5、姓名搜索模糊查询")
    @GetMapping("/fuzzyQueryByName")
    public ResultVo fuzzyQueryByName(@RequestParam(required = false,value = "name") String name){
        ResultVo resultVo=new ResultVo();
        try {
            if (name==null){
                resultVo.setT(null);
            }else{
                List<Person> people = portraitService.fuzzyQueryByName(name);
                resultVo.setT(people);
            }
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "1、人物画像个人信息查询")
    @PostMapping("/queryPeopleInfoByid")
    public ResultVo queryPeopleById(String id){
        ResultVo resultVo = new ResultVo();

        try {
            Map<String, Object> map = portraitService.selectPeopleById(id);
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

    /*民主党派人物*/
    @ApiOperation(value = "2、民主党派人物列表")
    @PostMapping("/queryDemocraticParties")
    public ResultVo queryDemocraticParties(){
        ResultVo resultVo=new ResultVo();
        try {
            List<Person> people = portraitService.queryDemocraticParties();
            resultVo.setT(people);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    /*非党派人物*/
    @ApiOperation(value = "3、非党派人物列表")
    @PostMapping("/queryNonPartisan")
    public ResultVo queryNonPartisan(){
        ResultVo resultVo=new ResultVo();
        try {
            List<Person> people = portraitService.queryNonPartisan();
            resultVo.setT(people);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    /*姓名查询*/
    @ApiOperation(value = "4、姓名搜索查询")
    @PostMapping("/queryByName")
    public ResultVo queryByName(String name){
        ResultVo resultVo=new ResultVo();
        try {
            List<Person> people = portraitService.queryByName(name);
            resultVo.setT(people);
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
