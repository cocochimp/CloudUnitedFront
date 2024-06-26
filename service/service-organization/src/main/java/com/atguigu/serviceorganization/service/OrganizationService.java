package com.atguigu.serviceorganization.service;


import com.atguigu.serviceorganization.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
public interface OrganizationService extends IService<Person> {

    //1、"基层统战"模块
    //1-1:23个“基层统战”的人员信息
    List<Map<String,Integer>> queryDepartment(@Param("department") String department, @Param("page") int page, @Param("limit") int limit);

    //1-2:23个“基层统战”的人员信息(总数量)
    Integer queryDepartmentCount(@Param("department") String department);

    //1-3:“查询”按钮功能：(通过name)
    List<Map<String,Integer>> queryDepartmentByName(@Param("department") String department,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //1-4:“查询”按钮功能：(通过name)(总数量)
    Integer queryDepartmentByNameCount(@Param("department") String department,@Param("name") String name);



    //2、“民主党派、群团组织”模块
    //2-1:“民主党派、群团组织”的人员信息
    List<Map<String,Integer>> queryParty(@Param("party") String party,@Param("page") int page,@Param("limit") int limit);

    //2-2:“民主党派、群团组织”的人员信息(总数量)
    Integer queryPartyCount(@Param("party") String party);

    //2-3:“查询”按钮功能：(通过name)
    List<Map<String,Integer>> queryPartyByName(@Param("party") String party,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //2-4:“查询”按钮功能：(通过name)(总数量)
    Integer queryPartyByNameCount(@Param("party") String party,@Param("name") String name);



    //3、"少数民族"模块
    //3-1:"少数民族"的人员信息
    List<Map<String,Integer>> queryNational(@Param("page") int page,@Param("limit") int limit);

    //3-2:"少数民族"的人员信息(总数量)
    Integer queryNationalCount();

    //3-3:“查询”按钮功能：(通过name)
    List<Map<String,Integer>> queryNationalByName(@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //3-4:“查询”按钮功能：(通过name)(总数量)
    Integer queryNationalByNameCount(@Param("name") String name);



    //4、"参政议政"模块
    //4-1:"参政议政"人员信息
    List<Map<String,Integer>> queryPolitical(@Param("category") String category,@Param("page") int page,@Param("limit") int limit);

    //4-2:"参政议政"人员信息(总数量)
    Integer queryPoliticalCount(@Param("category") String category);

    //4-3:“查询”按钮功能：(通过name)
    List<Map<String,Integer>> queryPoliticalByName(@Param("category") String category,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //4-4:“查询”按钮功能：(通过name)(总数量)
    Integer queryPoliticalByNameCount(@Param("category") String category,@Param("name") String name);


    //5、修改功能
    //5-1、（"基层统战"和“民主党派”模块）：
    void updatePersonal(Person_personal person_personal);
    void updateStaff(Person_staff person_staff);
    //5-2、("知联会")
    void updateStaffZhiLianHui(Person_staff person_staff);


    //6、删除功能：
    void deletePersonal(String id);
    void deleteStaff(String id);

    //7-1、查询“基层统战”种类
    List<Map<String,String>>  queryChildrenByDepartment();
    //7-2、查询“民主党派”种类
    List<Map<String,String>>  queryChildrenByParty();
    //7-3、查询“群团组织”种类
    List<Map<String,String>>  queryChildrenByPartyOther();
    //7-4、查询“参政议政”种类
    List<Map<String,String>>  queryChildrenByPolitical();



    //8-1、添加“基层统战”种类
    void insertChildrenByDepartment(Department department);
    //8-2、添加“民主党派”种类
    void insertChildrenByParty(Party party);
    //8-3、添加“群团组织”种类
    void insertChildrenByPartyOther(PartyOthers partyothers);
    //8-4、添加“参政议政”种类
    void insertChildrenByPolitical(Political political);

    //9-1、修改“基层统战”导航栏
    void updateChildrenByDepartment(Department department);
    //9-2、修改“民主党派”导航栏
    void updateChildrenByParty(Party party);
    //9-3、修改“群团组织”导航栏
    void updateChildrenByPartyOther(PartyOthers partyothers);
    //9-4、修改“参政议政”导航栏
    void updateChildrenByPolitical(Political political);

    //10-1、删除“基层统战”导航栏
    void deleteChildrenByDepartment(Department department);
    //10-2、删除“民主党派”导航栏
    void deleteChildrenByParty(Party party);
    //10-3、删除“群团组织”导航栏
    void deleteChildrenByPartyOther(PartyOthers partyothers);
    //10-4、删除“参政议政”导航栏
    void deleteChildrenByPolitical(Political political);

    //11-1、查询全部导航栏
    List<Map<String,Integer>> queryAllZuZhi(int page,int limit);
    //11-2、查询全部导航栏数量
    List<Map<String,Integer>> queryAllZuZhiCount();
    //11-3、模糊查询组织
    List<Map<String, Integer>> queryZuZhiMoHu(String title, int page, int limit);
    //11-4、模糊查询组织数量
    List<Map<String,Integer>> queryZuZhiCountMoHu(String title);


}
