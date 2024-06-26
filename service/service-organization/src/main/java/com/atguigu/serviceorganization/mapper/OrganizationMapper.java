package com.atguigu.serviceorganization.mapper;

import com.atguigu.serviceorganization.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrganizationMapper extends BaseMapper<Person> {

    //1、"基层统战"模块
    //1-1:23个“基层统战”的人员信息
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and d.department= #{department}  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryDepartment(@Param("department") String department,@Param("page") int page,@Param("limit") int limit);

    //1-2:23个“基层统战”的人员信息(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id  and d.department= #{department}  ")
    Integer queryDepartmentCount(@Param("department") String department);

    //1-3:“查询”按钮功能：(通过name)
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and d.department= #{department} and p.name like concat('%',#{name},'%')  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryDepartmentByName(@Param("department") String department,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //1-4:“查询”按钮功能：(通过name)(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and d.department= #{department}  and p.name like concat('%',#{name},'%') ")
    Integer queryDepartmentByNameCount(@Param("department") String department,@Param("name") String name);



    //2、“民主党派、群团组织”模块
    //2-1:“民主党派、群团组织”的人员信息
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and pa.party= #{party}  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryParty(@Param("party") String party,@Param("page") int page,@Param("limit") int limit);

    //2-2:“民主党派、群团组织”的人员信息(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and pa.party= #{party}   ")
    Integer queryPartyCount(@Param("party") String party);

    //2-3:“查询”按钮功能：(通过name)
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and pa.party= #{party} and p.name like concat('%',#{name},'%')  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryPartyByName(@Param("party") String party,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //2-4:“查询”按钮功能：(通过name)(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and pa.party= #{party} and p.name like concat('%',#{name},'%') ")
    Integer queryPartyByNameCount(@Param("party") String party,@Param("name") String name);



    //3、"少数民族"模块
    //3-1:"少数民族"的人员信息
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_nation n " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and p.nation_id=n.nation_id and n.nation!='汉族' " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryNational(@Param("page") int page,@Param("limit") int limit);

    //3-2:"少数民族"的人员信息(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_nation n " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and p.nation_id=n.nation_id and n.nation!='汉族'")
    Integer queryNationalCount();

    //3-3:“查询”按钮功能：(通过name)
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_nation n " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and p.nation_id=n.nation_id and n.nation!='汉族' and p.name like concat('%',#{name},'%')  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryNationalByName(@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //3-4:“查询”按钮功能：(通过name)(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_nation n " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and p.nation_id=n.nation_id and n.nation!='汉族' and p.name like concat('%',#{name},'%')")
    Integer queryNationalByNameCount(@Param("name") String name);


    //4、"参政议政"模块
    //4-1:"参政议政"人员信息
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_political po " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id and s.politicalPosition_id=po.politicalPosition_id and po.category= #{category}  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryPolitical(@Param("category") String category,@Param("page") int page,@Param("limit") int limit);

    //4-2:"参政议政"人员信息(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_political po " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.politicalPosition_id=po.politicalPosition_id and s.organization_id=o.o_id and po.category=#{category}")
    Integer queryPoliticalCount(@Param("category") String category);

    //4-3:“查询”按钮功能：(通过name)
    @Select("select p.id,pa.party,d.department,p.name,p.phone,p.nativePlace,o.o_identity,s.joinPartyDate " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_political po " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.politicalPosition_id=po.politicalPosition_id and po.category=#{category} and s.organization_id=o.o_id and name like concat('%',#{name},'%')  " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryPoliticalByName(@Param("category") String category,@Param("name") String name,@Param("page") int page,@Param("limit") int limit);

    //4-4:“查询”按钮功能：(通过name)(总数量)
    @Select("select count(*) " +
            "from dangpai_personal_info p, " +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_department d, " +
            "organization_identity o, " +
            "dangpai_political po " +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.politicalPosition_id=po.politicalPosition_id and s.organization_id=o.o_id and po.category=#{category} and name like concat('%',#{name},'%')  ")
    Integer queryPoliticalByNameCount(@Param("category") String category,@Param("name") String name);


    // 5、修改功能
    // 5-1、（"基层统战"和“民主党派”模块）：
    @Update("update dangpai_personal_info " +
            "set name=#{name}, " +
            "phone=#{phone}, " +
            "nativePlace=#{nativePlace} " +
            "where id=#{id}")
    void updatePersonal(Person_personal person_personal);

    @Update("update dangpai_staff_info " +
            "set party_id=#{partyId}, " +
            "department_id=#{departmentId}, " +
            "joinPartyDate=#{joinPartyDate}," +
            "organization_id=#{organizationId} " +
            "where s_id=#{sId}")
    void updateStaff(Person_staff person_staff);

    //5-2、("知联会")
    @Update("update dangpai_staff_info " +
            "set party_others_id=#{partyId}, " +
            "department_id=#{departmentId}, " +
            "joinPartyDate=#{joinPartyDate}," +
            "organization_id=#{organizationId} " +
            "where s_id=#{sId}")
    void updateStaffZhiLianHui(Person_staff person_staff);

    //6、删除功能：
    @Delete("delete from dangpai_personal_info " +
            "where id=#{id}")
    void deletePersonal(String id);

    @Delete("delete from dangpai_staff_info " +
            "where s_id=#{id}")
    void deleteStaff(String id);


    //7-1、导航栏:“基层统战”
    @Select("select department_id id,department title " +
            "from dangpai_department")
    List<Map<String,String>>  queryChildrenByDepartment();

    //7-2、导航栏:“民主党派”
    @Select("select party_id id,party title " +
            "from dangpai_party")
    List<Map<String,String>>  queryChildrenByParty();

    //7-3、导航栏:“群团组织”
    @Select("select p_id id,other_party title " +
            "from dangpai_party_others " +
            "where other_party!='无党派' and other_party!='党外人员'")
    List<Map<String,String>>  queryChildrenByPartyOther();

    //7-4、导航栏:“参政议政”
    @Select("select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where category!='人大代表' and category!='政协委员' " +
            "union " +
            "select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where politicalPosition_id='6952297128416907190' or politicalPosition_id='6952297128416907194' ")
    List<Map<String,String>>  queryChildrenByPolitical();

    //8-1、增加导航栏:“基层统战”
    @Insert("insert into dangpai_department " +
            "values (#{id},#{department})")
    void insertChildrenByDepartment(Department department);

    //8-2、增加导航栏:“民主党派”
    @Insert("insert into dangpai_party  " +
            "values (#{id},#{party})")
    void insertChildrenByParty(Party party);

    //8-3、增加导航栏:“群团组织”
    @Insert("insert into dangpai_party_others " +
            "values (#{id},#{otherParty})")
    void insertChildrenByPartyOther(PartyOthers partyothers);

    //8-4、增加导航栏:“参政议政”
    @Insert("insert into dangpai_political(politicalPosition_id,category) " +
            "values (#{id},#{category})")
    void insertChildrenByPolitical(Political political);

    //9-1、修改“基层统战”导航栏
    @Update("update dangpai_department " +
            "set department=#{department} " +
            "where department_id=#{id}")
    void updateChildrenByDepartment(Department department);

    //9-2、修改“民主党派”导航栏
    @Update("update dangpai_party " +
            "set party=#{party} " +
            "where party_id=#{id}")
    void updateChildrenByParty(Party party);

    //9-3、修改“群团组织”导航栏
    @Update("update dangpai_party_others " +
            "set other_party=#{otherParty} " +
            "where p_id=#{id}")
    void updateChildrenByPartyOther(PartyOthers partyothers);

    //9-4、修改“参政议政”导航栏
    @Update("update dangpai_political " +
            "set category=#{category} " +
            "where politicalPosition_id=#{id}")
    void updateChildrenByPolitical(Political political);


    //10-1、删除“基层统战”导航栏
    @Delete("delete from dangpai_department " +
            "where department_id=#{id}")
    void deleteChildrenByDepartment(Department department);

    //10-2、删除“民主党派”导航栏
    @Delete("delete from dangpai_party " +
            "where party_id=#{id}")
    void deleteChildrenByParty(Party party);

    //10-3、删除“群团组织”导航栏
    @Delete("delete from dangpai_party_others " +
            "where p_id=#{id}")
    void deleteChildrenByPartyOther(PartyOthers partyothers);

    //10-4、删除“参政议政”导航栏
    @Delete("delete from dangpai_political " +
            "where politicalPosition_id=#{id}")
    void deleteChildrenByPolitical(Political political);

    //11-1、查询全部导航栏
    @Select("select distinct id,d.department department,count(*) sum\n" +
            "from dangpai_personal_info p,\n" +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s,\n" +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa,\n" +
            "dangpai_department d,\n" +
            "organization_identity o\n" +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id\n" +
            "group by department\n" +
            "union\n" +
            "select distinct id,party department,count(*) sum\n" +
            "from dangpai_personal_info p,\n" +
            "(select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,organization_id from dangpai_staff_info) as s,\n" +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa,\n" +
            "dangpai_department d,\n" +
            "organization_identity o\n" +
            "where p.id=s.s_id and s.party_id=pa.party_id and s.department_id=d.department_id and s.organization_id=o.o_id\n" +
            "group by party\n" +
            "union\n" +
            "select A.politicalPosition_id id, B.category department,B.a sum  from\n" +
            "( select a.*, @rownum:=@rownum+1 as rn from (select politicalPosition_id\n" +
            " from dangpai_political p\n" +
            " where p.politicalPosition_id!='6952297128416907190' and p.politicalPosition_id!='6952297128416907191' and p.politicalPosition_id!='6952297128416907192' and p.politicalPosition_id!='6952297128416907194' and p.politicalPosition_id!='6952297128416907195' and p.politicalPosition_id!='6952297128416907196' and p.category!='其他代表人士') a,(select @rownum :=0 ) t) A \n" +
            "LEFT JOIN \n" +
            "( select b.*, @rownum1:=@rownum1+1 as rn from (select distinct category,count(*) a\n" +
            " from dangpai_political p left join dangpai_staff_info s\n" +
            " on p.politicalPosition_id=s.politicalPosition_id \n" +
            " where p.category!='其他代表人士'\n" +
            " group by category) b,(select @rownum1 :=0 ) t) B\n" +
            "on A.rn = B.rn " +
            "limit  #{page} , #{limit}")
    List<Map<String,Integer>> queryAllZuZhi(@Param("page") int page,@Param("limit") int limit);



    //11-2、查询全部导航栏数量
    @Select("select department title " +
            "from dangpai_department " +
            "union " +
            "select party title " +
            "from dangpai_party " +
            "union " +
            "select other_party title " +
            "from dangpai_party_others " +
            "where other_party!='无党派' and other_party!='党外人员' " +
            "union " +
            "select distinct category title " +
            "from dangpai_political " +
            "where category!='党代表' ")
    List<Map<String,Integer>> queryAllZuZhiCount();

    //11-3、模糊查询组织
    @Select("select * from (select department_id id,department title " +
            "from dangpai_department " +
            "union " +
            "select party_id id,party title " +
            "from dangpai_party " +
            "union " +
            "select p_id id,other_party title " +
            "from dangpai_party_others " +
            "where other_party!='无党派' and other_party!='党外人员' " +
            "union " +
            "select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where category!='党代表' and category!='人大代表' and category!='政协委员' " +
            "union " +
            "select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where politicalPosition_id='6952297128416907190' or politicalPosition_id='6952297128416907194') total " +
            "where total.title LIKE CONCAT('%', #{title} ,'%') " +
            "limit  #{page} , #{limit}")
    List<Map<String, Integer>> queryZuZhiMoHu(@Param("title") String title, @Param("page") int page,@Param("limit") int limit);


    //11-4、模糊查询组织数量
    @Select("select * from (select department_id id,department title " +
            "from dangpai_department " +
            "union " +
            "select party_id id,party title " +
            "from dangpai_party " +
            "union " +
            "select p_id id,other_party title " +
            "from dangpai_party_others " +
            "where other_party!='无党派' and other_party!='党外人员' " +
            "union " +
            "select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where category!='党代表' and category!='人大代表' and category!='政协委员' " +
            "union " +
            "select politicalPosition_id id,category title " +
            "from dangpai_political " +
            "where politicalPosition_id='6952297128416907190' or politicalPosition_id='6952297128416907194') total " +
            "where total.title LIKE CONCAT('%', #{title} ,'%') ")
    List<Map<String, Integer>> queryZuZhiCountMoHu(@Param("title") String title);
}
