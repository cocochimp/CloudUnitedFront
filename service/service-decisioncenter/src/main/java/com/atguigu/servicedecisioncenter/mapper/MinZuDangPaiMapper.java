package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MinZuDangPaiMapper extends BaseMapper<Person>{

    //1-1、查询年龄分布(不带参)
    @Select("select  " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>55,true,null)) as 'age>55', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>=46 and year(now())-convert(left(a.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>=35 and year(now())-convert(left(a.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)<35,true,null)) as  'age<35'  " +
            "from (select birth " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe " +
            "where s.party_id=p.party_id and pe.id=s.s_id) as a")
    Map<String, AgeResult> queryAgeDistribution();

    //1-2、查询年龄分布(带参)
    @Select("select  " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>55,true,null)) as 'age>55', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>=46 and year(now())-convert(left(a.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)>=35 and year(now())-convert(left(a.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45', " +
            "count(if(year(now())-convert(left(a.birth,4),unsigned)<35,true,null)) as  'age<35'  " +
            "from (select birth " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe,dangpai_department d " +
            "where s.party_id=p.party_id and pe.id=s.s_id and s.department_id=d.department_id and d.department= #{department} ) as a")
    Map<String,AgeResult> queryAgeDistributionByDepartment(@Param("department") String department);

    //2-1、查询性别分布(不带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe " +
            "where s.party_id=p.party_id and pe.id=s.s_id " +
            "group by pe.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistribution();

    //2-2、查询性别分布(带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe,dangpai_department d " +
            "where s.party_id=p.party_id and pe.id=s.s_id and s.department_id=d.department_id and d.department= #{department} " +
            "group by pe.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistributionByDepartment(@Param("department") String department);

    //3-1、查询学历分布(不带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(pe.fulltimedegree_id) count " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe,dangpai_fulltimedegree f " +
            "where s.party_id=p.party_id and pe.id=s.s_id and pe.fulltimedegree_id=f.fulltimedegree_id " +
            "group by pe.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistribution();

    //3-2、查询学历分布(带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(pe.fulltimedegree_id) count " +
            "from dangpai_staff_info s,dangpai_party p,dangpai_personal_info pe,dangpai_fulltimedegree f,dangpai_department d " +
            "where s.party_id=p.party_id and pe.id=s.s_id and pe.fulltimedegree_id=f.fulltimedegree_id and s.department_id=d.department_id and d.department= #{department} " +
            "group by pe.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(@Param("department") String department);

    //4-1、查询职称分布(无参)
    List<Map<String,Integer>> queryTitleDistribution();

    //4-2、查询职称分布(有参)
    List<Map<String,Integer>> queryTitleDistributionByDepartment(@Param("department") String department);

    //5-1 查询成员数量(无参)
    @Select("SELECT " +
            "ifnull( a.count, 0 )  count " +
            "FROM " +
            "dangpai_party p " +
            "LEFT JOIN ( " +
            "SELECT " +
            "p.party_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_party p  " +
            "WHERE " +
            "s.party_id = p.party_id  " +
            "GROUP BY " +
            "p.party_id  " +
            "ORDER BY " +
            "p.party_id  " +
            ") AS a ON p.party_id = a.party_id")
    List<Integer> queryMemberShip();


    //5-2 查询成员数量(有参)
    @Select("SELECT " +
            "ifnull( a.count, 0 )  count " +
            "FROM " +
            "dangpai_party p " +
            "LEFT JOIN ( " +
            "SELECT " +
            "p.party_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_party p, " +
            "dangpai_department d  " +
            "WHERE " +
            "s.party_id = p.party_id  " +
            "AND s.department_id = d.department_id  " +
            "AND d.department =#{department}  " +
            "GROUP BY " +
            "p.party_id  " +
            "ORDER BY " +
            "p.party_id  " +
            ") AS a ON p.party_id = a.party_id")
    List<Integer> queryMemberShipByDepartment(String department);


    //6-1 查询新发展成员数量(无参)
    @Select("SELECT " +
            "ifnull( a.count, 0 )  count " +
            "FROM " +
            "dangpai_party p " +
            "LEFT JOIN ( " +
            "SELECT " +
            "p.party_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_party p  " +
            "WHERE " +
            "s.party_id = p.party_id  " +
            "AND LEFT ( s.joinPartyDate, 4 ) = YEAR ( curdate( ) )  " +
            "GROUP BY " +
            "p.party_id  " +
            "ORDER BY " +
            "p.party_id  " +
            ") AS a ON p.party_id = a.party_id")
    List<Integer> queryIncreaseCount();


    //6-2 查询新发展成员数量(有参)
    @Select("SELECT " +
            "ifnull( a.count, 0 )  count " +
            "FROM " +
            "dangpai_party p " +
            "LEFT JOIN ( " +
            "SELECT " +
            "p.party_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_party p, " +
            "dangpai_department d  " +
            "WHERE " +
            "s.party_id = p.party_id  " +
            "AND s.department_id = d.department_id  " +
            "AND d.department = #{department} " +
            "AND LEFT ( s.joinPartyDate, 4 ) = YEAR ( curdate( ) )  " +
            "GROUP BY " +
            "p.party_id  " +
            "ORDER BY " +
            "p.party_id  " +
            ") AS a ON p.party_id = a.party_id")
    List<Integer> queryIncreaseCountByDepartment(String department);





    //党外干部(带参)
    @Select("SELECT " +
            "j.joblevel,"+
            "ifnull( a.count, 0 ) count " +
            "FROM " +
            "dangpai_joblevel j " +
            "LEFT JOIN ( " +
            "SELECT " +
            "j.joblevel, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_joblevel j, " +
            "dangpai_department d  " +
            "WHERE " +
            "s.joblevel_id = j.joblevel_id  " +
            "AND s.department_id = d.department_id  " +
            "AND d.department = #{department} " +
            "GROUP BY " +
            "j.joblevel_id  " +
            ") AS a ON j.joblevel = a.joblevel")
    List<Map<String, Integer>> queryNonPartyCadresByDepartment(String department);


    //成员数量
    @Select("select party from dangpai_party")
    List<String> queryParties();

    //查询不同级别党外干部政治安排全国，省，市，县
    @Select("SELECT " +
            "politicalPosition p  " +
            "FROM " +
            "dangpai_political p  " +
            "WHERE " +
            "p.politicalPosition_id != \"6952297128416907198\"  " +
            "and p.politicalPosition_id != \"6952297128416907199\" "+
            "GROUP BY " +
            "p")
    List<String> queryLevels();

    //查询党外干部不同职位人大代表，政协委员
    @Select("SELECT " +
            "category c  " +
            "FROM " +
            "dangpai_political p  " +
            "WHERE " +
            "p.politicalPosition_id != \"6952297128416907198\"  " +
            "and p.politicalPosition_id != \"6952297128416907199\" "+
            "GROUP BY "+
            "c")
    List<String> queryCategories();

    //查询党外干部政治安排数量
    @Select("SELECT " +
            "ifnull( a.count, 0 ) count " +
            "FROM " +
            "(select * from dangpai_political where politicalPosition_id!=\"6952297128416907198\") p " +
            "LEFT JOIN ( " +
            "SELECT   " +
            "  p.politicalPosition_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_political p  " +
            "WHERE " +
            "s.politicalPosition_id = p.politicalPosition_id  " +
            "GROUP BY " +
            "p.politicalPosition_id  " +
            ") a ON p.politicalPosition_id = a.politicalPosition_id")
    List<Integer> queryPoliticalArrangementCount();

    //按照查询部门党外干部政治安排数量
    @Select("SELECT " +
            "ifnull( a.count, 0 )  count " +
            "FROM " +
            "( SELECT * FROM dangpai_political WHERE politicalPosition_id != \"6952297128416907198\" ) p " +
            "LEFT JOIN ( " +
            "SELECT " +
            "p.politicalPosition_id, " +
            "count( * ) count  " +
            "FROM " +
            "dangpai_staff_info s, " +
            "dangpai_political p, " +
            "dangpai_department d  " +
            "WHERE " +
            "s.politicalPosition_id = p.politicalPosition_id  " +
            "AND s.department_id = d.department_id  " +
            "AND d.department = #{department} " +
            "GROUP BY " +
            "p.politicalPosition_id  " +
            ") a ON p.politicalPosition_id = a.politicalPosition_id")
    List<Integer> queryPoliticalArrangementCountByDepartment(String department);



    @Select("select ifnull(count(s.party_id),0) count from dangpai_party p left join dangpai_staff_info s on p.party_id=s.party_id")
    Integer queryCount();

    Integer queryCountByDepartment(String department);



    List<Map<String, Integer>> DepartmentCount();


    @Select("select distinct year from politics_eachyear GROUP BY year order by year ")
    List<Integer> queryYearOfPolitics();

    @Select("select  p.number from politics_eachyear p order by p.id")
    List<Integer> queryPolitics();
}
