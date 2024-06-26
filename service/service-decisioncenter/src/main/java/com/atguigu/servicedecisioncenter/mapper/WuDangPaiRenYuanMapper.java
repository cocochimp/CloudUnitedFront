package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WuDangPaiRenYuanMapper extends BaseMapper<Person> {

    //无党派人士、知联会
    //1-1、查询学历分布(一参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_fulltimedegree f,dangpai_staff_info s,dangpai_party_others o " +
            "where p.fulltimedegree_id=f.fulltimedegree_id and s.s_id=p.id and s.party_others_id=o.p_id and o.other_party= #{other_party} " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistribution(@Param("other_party") String other_party);

    //1-2、查询学历分布(两参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_fulltimedegree f,dangpai_party_others o " +
            "where p.id=s.s_id and s.department_id=d.department_id and  p.fulltimedegree_id=f.fulltimedegree_id and s.party_others_id=o.p_id and o.other_party= #{other_party} and d.department= #{department} " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(@Param("other_party") String other_party,@Param("department") String department);

    //2-1、查询性别分布(一参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_party_others o " +
            "where p.id=s.s_id and s.party_others_id=o.p_id and o.other_party= #{other_party} " +
            "group by p.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistribution(@Param("other_party") String other_party);

    //2-2、查询性别分布(两参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select p.sex,count(p.sex) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_party_others o " +
            "where p.id=s.s_id and s.department_id=d.department_id and s.party_others_id=o.p_id and o.other_party= #{other_party} and d.department= #{department} " +
            "group by p.sex) as b " +
            "on a.sex=b.sex ")
    List<Map<String,Integer>> querySexDistributionByDepartment(@Param("other_party") String other_party,@Param("department") String department);

    //3-1、查询年龄分布(一参)
    @Select("select  " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>55,true,null)) as 'age>55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=46 and year(now())-convert(left(p.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=35 and year(now())-convert(left(p.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<35,true,null)) as  'age<35'  " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_party_others o " +
            "where p.id=s.s_id and s.party_others_id=o.p_id and o.other_party= #{other_party} ")
    Map<String, AgeResult> queryAgeDistribution(@Param("other_party") String other_party);

    //3-2、查询年龄分布(两参)
    @Select("select  " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>55,true,null)) as 'age>55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=46 and year(now())-convert(left(p.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=35 and year(now())-convert(left(p.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<35,true,null)) as  'age<35'  " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_party_others o " +
            "where p.id=s.s_id and s.department_id=d.department_id and s.party_others_id=o.p_id and o.other_party= #{other_party} and d.department= #{department} ")
    Map<String,AgeResult> queryAgeDistributionByDepartment(@Param("other_party") String other_party,@Param("department") String department);

    //4-1、查询职称分布(一参)
    List<Map<String,Integer>> queryTitleDistribution(@Param("other_party") String other_party);

    //4-2、查询职称分布(两参)
    List<Map<String,Integer>> queryTitleDistributionByDepartment(@Param("other_party") String other_party,@Param("department") String department);

    //5-1无党派人员级别分布
    List<Map<String, Integer>> queryWuDangPaiLevel();

    //5-2无党派人员级别分布(带参)
    List<Map<String, Integer>> queryWuDangPaiLevelByDepartment(String department);

    //6-1知联会总数(无参)
    Map<String, Integer> queryZhiLianHuiCount();

    //6-2 知联会总数(带参)
    Map<String, Integer> queryZhiLianHuiCountByDepartment(String department);

    //6-3 无党派总数(无参)
    Map<String, Integer> queryWuDangPaiCount();

    //6-4 无党派总数(带参)
    Map<String, Integer> queryWuDangPaiCountByDepartment(String department);

    //留学归国人员
    //1-1、查询学历分布(无参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from renwuku_returnedpeople p,dangpai_fulltimedegree f " +
            "where p.fulltimedegree_id=f.fulltimedegree_id " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionOfAbroad();

    //1-2、查询学历分布(有参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) total " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(s.fulltimedegree_id) count " +
            "from renwuku_returnedpeople s,dangpai_department d,dangpai_fulltimedegree f " +
            "where s.department_id=d.department_id and  s.fulltimedegree_id=f.fulltimedegree_id and d.department= #{department} " +
            "group by s.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionByDepartmentOfAbroad(@Param("department") String department);

    //2-1、查询性别分布(无参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from renwuku_returnedpeople a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from renwuku_returnedpeople p " +
            "group by p.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistributionOfAbroad();

    //2-2、查询性别分布(有参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total " +
            "from renwuku_returnedpeople a " +
            "left join( " +
            "select p.sex,count(p.sex) count " +
            "from renwuku_returnedpeople p,dangpai_department d " +
            "where p.department_id=d.department_id  and d.department= #{department} " +
            "group by p.sex) as b " +
            "on a.sex=b.sex ")
    List<Map<String,Integer>> querySexDistributionByDepartmentOfAbroad(@Param("department") String department);

    //3-1、查询年龄分布(无参)
    @Select("select  " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>55,true,null)) as 'age>55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=46 and year(now())-convert(left(p.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=35 and year(now())-convert(left(p.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45', " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<35,true,null)) as  'age<35'  " +
            "from renwuku_returnedpeople p " )
    Map<String, AgeResult> queryAgeDistributionOfAbroad();

    //3-2、查询年龄分布(有参)
    @Select("select " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>55,true,null)) as 'age>55',  " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=46 and year(now())-convert(left(p.birth,4),unsigned)<=55,true,null)) as  '46<=age<=55'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=35 and year(now())-convert(left(p.birth,4),unsigned)<=45,true,null)) as  '35<=age<=45'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<35,true,null)) as  'age<35'   " +
            "from renwuku_returnedpeople p,dangpai_department d " +
            "where p.department_id=d.department_id  and d.department=#{department}")
    Map<String,AgeResult> queryAgeDistributionByDepartmentOfAbroad(@Param("department") String department);

    //4-1、查询职称分布(无参)
    List<Map<String,Integer>> queryTitleDistributionOfAbroad();

    //4-2、查询职称分布(有参)
    List<Map<String,Integer>> queryTitleDistributionByDepartmentOfAbroad(@Param("department") String department);


    //5-1查询留学时长分布(无参)
    @Select("select " +
            "count(if(duration > 12,true,null)) as '一年以上', " +
            "count(if(duration <= 12,true,null)) as '一年以内' " +
            "from renwuku_returnedpeople")
    List<Map<String, Integer>> queryTimeOfAboard();

    //5-2查询留学时长分布(有参)
    @Select("select " +
            "count(if(duration > 12,true,null)) as '一年以上', " +
            "count(if(duration <= 12,true,null)) as '一年以内' " +
            "from renwuku_returnedpeople p,dangpai_department d " +
            "where p.department_id=d.department_id and d.department= #{department} ")
    List<Map<String, Integer>> queryTimeOfAboardByDepartment(@Param("department") String department);

    //6-1 留学归国总数(无参)
    Map<String, Integer> queryCountOfAbroad();

    //6-2 留学归国总数(带参)
    Map<String, Integer> queryCountOfAbroadByDepartment(String department);
}
