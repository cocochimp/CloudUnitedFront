package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShaoShuMinZuMapper extends BaseMapper<Person> {

    //1-1、学历分布(不带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_fulltimedegree f,dangpai_nation n " +
            "where p.fulltimedegree_id=f.fulltimedegree_id and p.nation_id=n.nation_id and n.nation!='汉族' " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistribution();

    //1-2、学历分布(带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_fulltimedegree f,dangpai_nation n " +
            "where p.id=s.s_id and s.department_id=d.department_id and  p.fulltimedegree_id=f.fulltimedegree_id  and p.nation_id=n.nation_id and n.nation!='汉族' and d.department= #{department} " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(@Param("department") String department);

    //1-3 学历分布总数(无参)
    @Select("select ifnull(count(p.nation_id),0) count from dangpai_personal_info p left join" +
            " dangpai_nation n on p.nation_id=n.nation_id where n.nation_id!='6948231731531091977' ")
    Integer queryCountOfTeacher();
    
    //2-1、性别分布(不带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from dangpai_personal_info p,dangpai_nation n " +
            "where p.nation_id=n.nation_id and n.nation!='汉族' " +
            "group by p.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistribution();

    //2-2、性别分布(带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select p.sex,count(p.sex) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_nation n " +
            "where p.id=s.s_id and s.department_id=d.department_id and p.nation_id=n.nation_id and n.nation!='汉族' and d.department= #{department} " +
            "group by p.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistributionByDepartment(@Param("department") String department);


    //3、二级党组织分布(不带参)
    @Select("select a.department department,if(b.count!=0,b.count,0) total " +
            "from dangpai_department as a " +
            "left join( " +
            "select d.department,count(s.department_id) count " +
            "from dangpai_staff_info s,dangpai_department d,dangpai_personal_info p,dangpai_nation n " +
            "where s.department_id=d.department_id and p.nation_id=n.nation_id and s.s_id=p.id and n.nation!='汉族' " +
            "group by s.department_id) as b " +
            "on a.department=b.department " +
            "order by total desc")
    List<Map<String,Integer>> queryDepartmentDistribution();

    //4-1、民族分布(不带参)
    @Select("select a.nation,if(b.count!=0,b.count,0) total " +
            "from dangpai_nation as a " +
            "left join( " +
            "select nation,count(nation) count " +
            "from dangpai_personal_info p,dangpai_nation n " +
            "where p.nation_id=n.nation_id and n.nation!='汉族' " +
            "group by nation) as b " +
            "on a.nation=b.nation " +
            "order by total desc")
    List<Map<String,Integer>> queryNationalDistribution();

    //4-2、民族分布(带参)
    @Select("select a.nation,if(b.count!=0,b.count,0) total " +
            "from dangpai_nation as a " +
            "left join( " +
            "select nation,count(nation) count " +
            "from dangpai_personal_info p,dangpai_nation n,dangpai_staff_info s,dangpai_department d " +
            "where p.nation_id=n.nation_id and p.id=s.s_id and s.department_id=d.department_id and n.nation!='汉族' and d.department= #{department} " +
            "group by nation) as b " +
            "on a.nation=b.nation " +
            "order by total desc")
    List<Map<String,Integer>> queryNationalDistributionByDepartment(@Param("department") String department);


    //5-1、职称分布_职称(无参)
    @Select("select a.title " +
            "from dangpai_title as a " +
            "left join( " +
            "select title,count(title) count " +
            "from (select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,title_id from dangpai_staff_info) as s, " +
            "dangpai_title t, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_personal_info pe," +
            "dangpai_nation n " +
            "where s.title_id=t.title_id and s.party_id=pa.party_id and pe.id=s.s_id and pe.nation_id=n.nation_id and n.nation!='汉族' " +
            "group by t.title " +
            "order by count desc) as b " +
            "on a.title=b.title")
    List<String> queryTotalTitle();

    //5-2、职称分布_职称(带参)
    @Select("select a.title " +
            "from dangpai_title as a " +
            "left join( " +
            "select title,count(title) count " +
            "from (select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,title_id from dangpai_staff_info) as s, " +
            "dangpai_title t, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_personal_info pe, " +
            "dangpai_department d ," +
            "dangpai_nation n " +
            "where s.title_id=t.title_id and s.party_id=pa.party_id and pe.id=s.s_id and s.department_id=d.department_id and pe.nation_id=n.nation_id and n.nation!='汉族' and d.department= #{department}  " +
            "group by t.title " +
            "order by count desc) as b " +
            "on a.title=b.title")
    List<String> queryTotalByDepartmentTitle(@Param("department") String department);

    //5-3、职称分布_数量(无参)
    @Select("select if(b.count!=0,b.count,0) total " +
            "from dangpai_title as a " +
            "left join( " +
            "select title,count(title) count " +
            "from (select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,title_id from dangpai_staff_info) as s, " +
            "dangpai_title t, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_personal_info pe ," +
            "dangpai_nation n " +
            "where s.title_id=t.title_id and s.party_id=pa.party_id and pe.id=s.s_id and pe.nation_id=n.nation_id and n.nation!='汉族' " +
            "group by t.title) as b " +
            "on a.title=b.title " +
            "order by total desc")
    List<Integer> queryTotalTotal();

    //5-4、职称分布_数量(带参)
    @Select("select if(b.count!=0,b.count,0) total " +
            "from dangpai_title as a " +
            "left join( " +
            "select title,count(title) count " +
            "from (select s_id,concat(party_id,party_others_id) party_id,department_id,joinPartyDate,politicalPosition_id,title_id from dangpai_staff_info) as s, " +
            "dangpai_title t, " +
            "(select party_id,party from dangpai_party union select p_id party_id,other_party from dangpai_party_others) as pa, " +
            "dangpai_personal_info pe, " +
            "dangpai_department d," +
            "dangpai_nation n " +
            "where s.title_id=t.title_id and s.party_id=pa.party_id and pe.id=s.s_id and s.department_id=d.department_id and pe.nation_id=n.nation_id and n.nation!='汉族' and d.department= #{department}  " +
            "group by t.title) as b " +
            "on a.title=b.title " +
            "order by total desc")
    List<Integer> queryTotalByDepartmentTotal(@Param("department") String department);


    Integer queryCountOfTeacherByDepartment(@Param("department") String department);




    List<Map<String, Integer>> queryTitleDistribution();

    List<Map<String, Integer>> queryTitleDistributionByDepartment(@Param("department") String department);


}