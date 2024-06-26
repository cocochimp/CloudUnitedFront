package com.atguigu.serviceorganization.controller;

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

import com.atguigu.serviceorganization.service.PoliticalService;

import java.util.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@RestController
@RequestMapping("/Organization//RenWu/Category")
@CrossOrigin
@Api(tags = "参政议政接口")
public class PoliticalController {
    ResultVo<Object> resultVo = new ResultVo<>();
    @Autowired
    private StaffService staffService;
    @Autowired
    private PoliticalService politicalService;

    //1-4:展示“参政议政”的人员信息
    @ApiOperation(value = "1-4:展示“参政议政”的人员信息")
    @GetMapping("/{category}/{page}/{limit}")
    public ResultVo<Object> queryCategory(@PathVariable("category") String category,
                                          @PathVariable("page") int page,
                                          @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils = staffService.queryPageByCategory(category, new ParamsUtils(page,limit).getParams());
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

    //2-4:“查询”按钮功能：(“参政议政”)
    @ApiOperation(value = "2-4:“查询”按钮功能：(“参政议政”)")
    @GetMapping("/{category}/{name}/{page}/{limit}")
    public ResultVo<Object> queryCategoryByName(@PathVariable("category") String category,
                                                @PathVariable("name") String name,
                                                @PathVariable("page") int page,
                                                @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils =politicalService.queryPageBySearch(name,category,page,limit);
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
