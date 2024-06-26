package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.ResultVo;
import com.atguigu.serviceorganization.service.OrganizationService;
import com.atguigu.serviceorganization.service.PartyOthersService;
import com.atguigu.serviceorganization.service.StaffService;
import com.atguigu.serviceorganization.util.ChineseCharToEnUtil;
import com.atguigu.serviceorganization.util.ParamsUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.serviceorganization.service.PartyService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@RestController
@RequestMapping("/Organization/RenWu/Party")
@CrossOrigin
@Api(tags = "民主党派接口")
public class PartyController {
    ResultVo<Object> resultVo = new ResultVo<>();
    @Autowired
    private PartyService partyService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private PartyOthersService partyOthersService;

    //1-2、展示“民主党派”的人员信息
    @ApiOperation(value = "1-2:展示“民主党派、群团组织”的人员信息")
    @GetMapping("/{party}/{page}/{limit}")
    public ResultVo<Object> queryParty(@PathVariable("party") String party,
                                       @PathVariable("page") int page,
                                       @PathVariable("limit") int limit)
    {
        try{
            if(party.equals("知联会")){
                QueryResult pageUtils = staffService.queryPageByPartyOthers(party, new ParamsUtils(page, limit).getParams());
                resultVo.setData(pageUtils.getPageInfo());
            }else if(party.equals("无党派人士")){
                QueryResult pageUtils = staffService.queryPageByPartyOthers(party, new ParamsUtils(page, limit).getParams());
                QueryResult pageUtils2 = staffService.queryPageByPartyOthers("知联会", new ParamsUtils(page, limit).getParams());
                Map<String, Object> pageInfo = pageUtils.getPageInfo();
                Map<String, Object> pageInfo2 = pageUtils2.getPageInfo();
                //将pageInfo和pageInfo2收集成一个流
                Stream<Map.Entry<String, Object>> concat = Stream.concat(pageInfo.entrySet().stream(), pageInfo2.entrySet().stream());
                //然后将其收集成一个新的map
                Map<String, Object> map = concat.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2));
                resultVo.setData(map);
            }else {
                QueryResult pageUtils = staffService.queryPageByParty(party, new ParamsUtils(page, limit).getParams());
                resultVo.setData(pageUtils.getPageInfo());
            }
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }

    //2-2:“查询”按钮功能：(“民主党派”)
    @ApiOperation(value = "2-2:“查询”按钮功能：(“民主党派、群团组织”)")
    @GetMapping("/{party}/{name}/{page}/{limit}")
    public ResultVo<Object> queryPartyByName(@PathVariable("party") String party,
                                             @PathVariable("name") String name,
                                             @PathVariable("page") int page,
                                             @PathVariable("limit") int limit)
    {
        try{
            if(party.equals("无党派人士")||party.equals("知联会")) {
                QueryResult pageUtils = partyOthersService.queryPageBySearch(name, party, page, limit);
                resultVo.setData(pageUtils.getPageInfo());
            }else{
                QueryResult pageUtils = partyService.queryPageBySearch(name, party, page, limit);
                resultVo.setData(pageUtils.getPageInfo());
            }
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
