package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.exception.AllException;
import com.atguigu.serviceorganization.mapper.OrganizationMapper;
import com.atguigu.serviceorganization.service.*;
import com.atguigu.serviceorganization.util.ChineseCharToEnUtil;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.util.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//解决跨域问题@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/Organization")
@Api(tags = "组织库接口")
public class OrganizationController {

    ResultVo<Object> resultVo = new ResultVo<>();
    ChineseCharToEnUtil chineseCharToEnUtil = new ChineseCharToEnUtil();
    @Autowired
    OrganizationService OrganizationService;
    @Autowired
    OrganizationMapper OrganizationMapper;
    @Autowired
    StaffService staffService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PartyOthersService partyOthersService;
    @Autowired
    PartyService partyService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticalService politicalService;

    //9:组织管理:(展示全部组织信息)
    @ApiOperation(value = "9:组织管理:(展示全部组织信息)")
    @GetMapping("/ZuZhi/queryAll/{page}/{limit}")
    public ResultVo<Object> queryChildren(@PathVariable("page") int page,
                                          @PathVariable("limit") int limit)
    {
        try{
            QueryResult pageUtils = staffService.queryPageByOrganization(page,limit);
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


    //9-1:模糊查询组织
    @ApiOperation(value = "9-1:模糊查询组织")
    @GetMapping(value = {"/ZuZhi/queryZuZhiMoHu/{title}/{page}/{limit}","/ZuZhi/queryZuZhiMoHu/{page}/{limit}"})
    public ResultVo<Object> queryChildren(@PathVariable(value = "title",required = false) String title,@PathVariable("page") int page,
                                          @PathVariable("limit") int limit)
    {
        if (title==null){
            title="";
        }
        try{
            QueryResult pageUtils =staffService.queryPageBySearch(page,limit,title);
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



    //3:修改功能:
    @ApiOperation(value = "3:修改人物功能[通过id]")
    @PostMapping("/RenWu/update")
    public ResultVo<Object> Update(Person person)
    {
        try{
            Person_personal person_personal = new Person_personal(person.getId(), person.getName(),person.getPhone(),person.getNativePlace());
            Person_staff person_staff = new Person_staff(person.getId(),person.getPartyId(),person.getDepartmentId(),person.getJoinPartyDate(),person.getOrganizationId());

            //判断是否是知联会的人员信息
            if(person.getPartyId().equals("6948211641926422548")){
                OrganizationService.updatePersonal(person_personal);
                OrganizationService.updateStaffZhiLianHui(person_staff);
            }else{
                OrganizationService.updatePersonal(person_personal);
                OrganizationService.updateStaff(person_staff);
            }

            resultVo.setMess("修改人物库成员成功");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    //4:删除功能:(通过人物id)
    @ApiOperation(value = "4:删除人物功能:[通过id]")
    @GetMapping("/RenWu/delete/{id}")
    public ResultVo<Object> DeleteById(@PathVariable("id") String id)
    {
        try{
            OrganizationService.deletePersonal(id);
            OrganizationService.deleteStaff(id);

            resultVo.setMess("删除成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("删除失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


    //5-1:"基层统战"的导航栏
    @ApiOperation(value = "5-1:导航栏信息:(基层统战)")
    @GetMapping("/ZuZhi/Department")
    public ResultVo<Object> queryChildrenByDepartment()
    {
        try{
            Map<String,Object> router = new HashMap<>();
            List<Map<String,Object>> children = new ArrayList<>();
            Map<String,Object> Router = new HashMap<>();
            List<Map<String, String>> info = OrganizationService.queryChildrenByDepartment();

            Iterator<Map<String, String>> iterator = info.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map<String, String> result = iterator.next();

                Map<String,Object> child = new HashMap<>();
                child.put("path","/".concat((chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","")).replaceAll("\\s*","").replaceAll("[^(A-Za-z)]","")));
                child.put("component",chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","").replaceAll("\\s*","").replaceAll("[^(A-Za-z)]",""));
                child.put("meta",result);

                children.add(index++,child);
            }

            Map<String,Object> meta = new HashMap<>();
            meta.put("title","基层统战");

            router.put("path","/department");
            router.put("component","department");
            router.put("meta",meta);
            router.put("children",children);

            Router.put("router",router);

            resultVo.setData(Router);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


    //5-2:"民主党派"的导航栏
    @ApiOperation(value = "5-2:导航栏信息:(民主党派)")
    @GetMapping("/ZuZhi/Party")
    public ResultVo<Object> queryChildrenByParty()
    {
        try{
            Map<String,Object> router = new HashMap<>();
            List<Map<String,Object>> children = new ArrayList<>();
            Map<String,Object> Router = new HashMap<>();
            List<Map<String, String>> info = OrganizationService.queryChildrenByParty();

            Iterator<Map<String, String>> iterator = info.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map<String, String> result = iterator.next();

                Map<String,Object> child = new HashMap<>();
                child.put("path","/".concat((chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","")).replaceAll("\\s*","").replaceAll("[^(A-Za-z)]","")));
                child.put("component",chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","").replaceAll("\\s*","").replaceAll("[^(A-Za-z)]",""));
                child.put("meta",result);

                children.add(index++,child);
            }

            Map<String,Object> meta = new HashMap<>();
            meta.put("title","民主党派");


            router.put("path","/party");
            router.put("component","party");
            router.put("meta",meta);
            router.put("children",children);

            Router.put("router",router);

            resultVo.setData(Router);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


    //5-3:"群团组织"的导航栏
    @ApiOperation(value = "5-3:导航栏信息:(群团组织)")
    @GetMapping("/ZuZhi/PartyOther")
    public ResultVo<Object> queryChildrenByPartyOther()
    {
        try{
            Map<String,Object> router = new HashMap<>();
            List<Map<String,Object>> children = new ArrayList<>();
            Map<String,Object> Router = new HashMap<>();
            List<Map<String, String>> info = OrganizationService.queryChildrenByPartyOther();

            Iterator<Map<String, String>> iterator = info.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map<String, String> result = iterator.next();

                Map<String,Object> child = new HashMap<>();
                child.put("path","/".concat((chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","")).replaceAll("\\s*","").replaceAll("[^(A-Za-z)]","")));
                child.put("component",chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","").replaceAll("\\s*","").replaceAll("[^(A-Za-z)]",""));
                child.put("meta",result);

                children.add(index++,child);
            }

            Map<String,Object> meta = new HashMap<>();
            meta.put("title","群团组织");

            router.put("path","/partyOther");
            router.put("component","partyOther");
            router.put("meta",meta);
            router.put("children",children);

            Router.put("router",router);

            resultVo.setData(Router);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


    //5-4:"参政议政"的导航栏
    @ApiOperation(value = "5-4:导航栏信息:(参政议政)")
    @GetMapping("/ZuZhi/Political")
    public ResultVo<Object> queryChildrenByPolitical()
    {
        try{
            Map<String,Object> router = new HashMap<>();
            List<Map<String,Object>> children = new ArrayList<>();
            Map<String,Object> Router = new HashMap<>();
            List<Map<String, String>> info = OrganizationService.queryChildrenByPolitical();

            Iterator<Map<String, String>> iterator = info.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                Map<String, String> result = iterator.next();

                Map<String,Object> child = new HashMap<>();
                child.put("path","/".concat((chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","")).replaceAll("\\s*","").replaceAll("[^(A-Za-z)]","")));
                child.put("component",chineseCharToEnUtil.getPingYin(result.values().toString()).replace("[", "").replace("]","").replaceAll("\\s*","").replaceAll("[^(A-Za-z)]",""));
                child.put("meta",result);

                children.add(index++,child);
            }

            Map<String,Object> meta = new HashMap<>();
            meta.put("title","参政议政");

            router.put("path","/political");
            router.put("component","political");
            router.put("meta",meta);
            router.put("children",children);

            Router.put("router",router);

            resultVo.setData(Router);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);}
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setData(false);
        }
        return resultVo;
    }


    //6-1:增加导航栏功能(基层统战):
    @ApiOperation(value = "6-1:增加导航栏功能(基层统战)[通过id和新名称department]")
    @PostMapping("/ZuZhi/Department/insert")
    public ResultVo<Object> InsertByDepartment(Department department)
    {
        try{
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            long id = idWorker.nextId();

            Department department01 = new Department(id,department.getDepartment());
            OrganizationService.insertChildrenByDepartment(department01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByDepartment();
        result.setMess("添加导航栏成功");
        return result;
    }

    //6-2:增加导航栏功能(民主党派):
    @ApiOperation(value = "6-2:增加导航栏功能(民主党派)[通过id和新名称party]")
    @PostMapping("/ZuZhi/Party/insert")
    public ResultVo<Object> InsertByParty(Party party)
    {
        try{
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            long id = idWorker.nextId();

            Party party01 = new Party(id,party.getParty());
            OrganizationService.insertChildrenByParty(party01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByParty();
        result.setMess("添加导航栏成功");
        return result;
    }

    //6-3:增加导航栏功能(群团组织):
    @ApiOperation(value = "6-3:增加导航栏功能(群团组织)[通过id和新名称otherParty]")
    @PostMapping("/ZuZhi/PartyOther/insert")
    public ResultVo<Object> InsertByPartyOthers(PartyOthers partyothers)
    {
        try{
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            long id = idWorker.nextId();

            PartyOthers partyothers01 = new PartyOthers(id,partyothers.getOtherParty());
            OrganizationService.insertChildrenByPartyOther(partyothers01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPartyOther();
        result.setMess("添加导航栏成功");
        return result;
    }


    //6-4:增加导航栏功能(参政议政):
    @ApiOperation(value = "6-4:增加导航栏功能(参政议政)[通过id和新名称category]")
    @PostMapping("/ZuZhi/Political/insert")
    public ResultVo<Object> InsertByPolitical(Political political)
    {
        try{
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            long id = idWorker.nextId();

            Political political01 = new Political(id,political.getCategory());
            OrganizationService.insertChildrenByPolitical(political01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPolitical();
        result.setMess("添加导航栏成功");
        return result;
    }


    //7-1:修改导航栏功能(基层统战):
    @ApiOperation(value = "7-1:修改导航栏功能(基层统战)[通过id]")
    @PostMapping("/ZuZhi/Department/update")
    public ResultVo<Object> UpdateByDepartment(Department department)
    {
        try{
            Department department01 = new Department(department.getId(),department.getDepartment());
            OrganizationService.updateChildrenByDepartment(department01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByDepartment();
        result.setMess("修改导航栏成功");
        return result;
    }

    //7-2:修改导航栏功能(民主党派):
    @ApiOperation(value = "7-2:修改导航栏功能(民主党派)[通过id]")
    @PostMapping("/ZuZhi/Party/update")
    public ResultVo<Object> UpdateByParty(Party party)
    {
        try{
            Party Party = new Party(party.getId(),party.getParty());
            OrganizationService.updateChildrenByParty(Party);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByParty();
        result.setMess("修改导航栏成功");
        return result;
    }

    //7-3:修改导航栏功能(群团组织):
    @ApiOperation(value = "7-3:修改导航栏功能(群团组织)[通过id]")
    @PostMapping("/ZuZhi/PartyOther/update")
    public ResultVo<Object> UpdateByPartyOther(PartyOthers partyothers)
    {
        try{
            PartyOthers PartyOthers = new PartyOthers(partyothers.getId(),partyothers.getOtherParty());
            OrganizationService.updateChildrenByPartyOther(PartyOthers);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPartyOther();
        result.setMess("修改导航栏成功");
        return result;
    }

    //7-4:修改导航栏功能(参政议政):
    @ApiOperation(value = "7-4:修改导航栏功能(参政议政)[通过id]")
    @PostMapping("/ZuZhi/Political/update")
    public ResultVo<Object> UpdateByPolitical(Political political)
    {
        try{
            Political Political = new Political(political.getId(),political.getCategory());
            OrganizationService.updateChildrenByPolitical(Political);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPolitical();
        result.setMess("修改导航栏成功");
        return result;
    }


    //8-1:删除导航栏功能(基层统战):
    @ApiOperation(value = "8-1:删除导航栏功能(基层统战)[通过名称department]")
    @PostMapping("/ZuZhi/Department/delete")
    public ResultVo<Object> DeleteByDepartment(Department department)
    {
        try{
            Department department01 = new Department(department.getId(),department.getDepartment());
            OrganizationService.deleteChildrenByDepartment(department01);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByDepartment();
        result.setMess("删除导航栏成功");
        return result;
    }

    //8-2:删除导航栏功能(基层统战):
    @ApiOperation(value = "8-2:删除导航栏功能(民主党派)[通过名称party]")
    @PostMapping("/ZuZhi/Party/delete")
    public ResultVo<Object> DeleteByParty(Party party)
    {
        try{
            Party Party = new Party(party.getId(),party.getParty());
            OrganizationService.deleteChildrenByParty(Party);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByParty();
        result.setMess("删除导航栏成功");
        return result;
    }

    //8-3:删除导航栏功能(基层统战):
    @ApiOperation(value = "8-3:删除导航栏功能(群团组织)[通过名称otherParty]")
    @PostMapping("/ZuZhi/PartyOthers/delete")
    public ResultVo<Object> DeleteByPartyOthers(PartyOthers partyOthers)
    {
        try{
            PartyOthers PartyOthers = new PartyOthers(partyOthers.getId(),partyOthers.getOtherParty());
            OrganizationService.deleteChildrenByPartyOther(PartyOthers);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPartyOther();
        result.setMess("删除导航栏成功");
        return result;
    }

    //8-4:删除导航栏功能(基层统战):
    @ApiOperation(value = "8-4:删除导航栏功能(参政议政)[通过名称category]")
    @PostMapping("/ZuZhi/Political/delete")
    public ResultVo<Object> DeleteByPolitical(Political political)
    {
        try{
            Political Political = new Political(political.getId(),political.getCategory());
            OrganizationService.deleteChildrenByPolitical(Political);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }

        ResultVo<Object> result = queryChildrenByPolitical();
        result.setMess("删除导航栏成功");
        return result;
    }


}

