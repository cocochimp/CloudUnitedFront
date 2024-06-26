package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.ResultVo;
import com.atguigu.serviceorganization.service.StaffService;
import com.atguigu.serviceorganization.util.ParamsUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.serviceorganization.service.NationService;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@RestController
@RequestMapping("/Organization/RenWu/National")
@CrossOrigin
@Api(tags = "少数民族接口")
public class NationController {
    ResultVo<Object> resultVo = new ResultVo<>();
    @Autowired
    private NationService nationService;
    @Autowired
    private StaffService staffService;

    //1-3:展示“少数民族”的人员信息
    @ApiOperation(value = "1-3:展示“少数民族”的人员信息")
    @GetMapping("/{page}/{limit}")
    public ResultVo<Object> queryNational(@PathVariable("page") int page,
                                          @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils = staffService.queryPageByNation( new ParamsUtils(page,limit).getParams());
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

    //2-3:“查询”按钮功能：(“少数民族”)
    @ApiOperation(value = "2-3:“查询”按钮功能：(“少数民族”)")
    @GetMapping("/{name}/{page}/{limit}")
    public ResultVo<Object> queryNationalByName(@PathVariable("name") String name,
                                                @PathVariable("page") int page,
                                                @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils =nationService.queryPageBySearch(name,page,limit);
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
