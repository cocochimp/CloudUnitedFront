package com.atguigu.serviceorganization.controller;

import java.util.*;

import com.atguigu.serviceorganization.entity.ResultVo;
import com.atguigu.serviceorganization.service.OrganizationService;
import com.atguigu.serviceorganization.service.StaffService;
import com.atguigu.serviceorganization.util.ChineseCharToEnUtil;
import com.atguigu.serviceorganization.util.ParamsUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.serviceorganization.service.DepartmentService;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@CrossOrigin
@RestController
@RequestMapping("/Organization/RenWu/Department")
@Api(tags = "基层统战接口")
public class DepartmentController {

    ResultVo<Object> resultVo = new ResultVo<>();
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StaffService staffService;



    //1-1:展示“基层统战”的人员信息
    @ApiOperation(value = "1-1:展示“基层统战”的人员信息")
    @GetMapping("/{department}/{page}/{limit}")
    public ResultVo<Object> queryDepartment(@PathVariable("department") String department,
                                            @PathVariable("page") int page,
                                            @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils = staffService.queryPageByDepartment(department, new ParamsUtils(page,limit).getParams());
            resultVo.setData(pageUtils.getPageInfo());
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }

    //2-1:“查询”按钮功能：(“基层统战”)
    @ApiOperation(value = "2-1:“查询”按钮功能：(“基层统战”)")
    @GetMapping("/{department}/{name}/{page}/{limit}")
    public ResultVo<Object> queryDepartmentByName(@PathVariable("department") String department,
                                                  @PathVariable("name") String name,
                                                  @PathVariable("page") int page,
                                                  @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils =departmentService.queryPageBySearch(name,department,page,limit);
            resultVo.setData(pageUtils.getPageInfo());
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


}
