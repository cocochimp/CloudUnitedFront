package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface GangAoTaiMapper extends BaseMapper<Person>{

    //1-1、查询年龄分布(不带参)
    @Select("select count(if(year(now())-convert(left(birth,4),unsigned)>60,true,null)) as 'age>60'," +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=51 and year(now())-convert(left(birth,4),unsigned)<=60,true,null)) as '51<=age<=60'," +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=41 and year(now())-convert(left(birth,4),unsigned)<=50,true,null)) as  '41<=age<=50'," +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=31 and year(now())-convert(left(birth,4),unsigned)<=40,true,null)) as  '31<=age<=40'," +
            "count(if(year(now())-convert(left(birth,4),unsigned)<=30,true,null)) as  'age<=30'" +
            "from dangpai_personal_info")
    Map<String,AgeResult> queryAgeDistribution();

    //1-2、查询年龄分布(带参)
    @Select("select " +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>60,true,null)) as 'age>60'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=51 and year(now())-convert(left(birth,4),unsigned)<=60,true,null)) as '51<=age<=60'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=41 and year(now())-convert(left(birth,4),unsigned)<=50,true,null)) as  '41<=age<=50'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=31 and year(now())-convert(left(birth,4),unsigned)<=40,true,null)) as  '31<=age<=40'," +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<=30,true,null)) as 'age<=30' " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d " +
            "where p.id=s.s_id and s.department_id=d.department_id and d.department= #{department} ")
    Map<String,AgeResult> queryAgeDistributionByDepartment(@Param("department") String department);

    //2-1、查询性别分布(不带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) count " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select sex,count(sex) count " +
            "from dangpai_personal_info p " +
            "group by p.sex) as b " +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistribution();

    //2-2、查询性别分布(带参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) count " +
            "from dangpai_personal_info a " +
            "left join( " +
            "select p.sex,count(p.sex) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d " +
            "where p.id=s.s_id and s.department_id=d.department_id and d.department= #{department} " +
            "group by p.sex) as b " +
            "on a.sex=b.sex ")
    List<Map<String,Integer>> querySexDistributionByDepartment(@Param("department") String department);

    //3-1、查询学历分布(不带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) count " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_fulltimedegree f " +
            "where p.fulltimedegree_id=f.fulltimedegree_id " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistribution();

    //3-2、查询学历分布(带参)
    @Select("select a.fulltimedegree degree,if(b.count!=0,b.count,0) count " +
            "from dangpai_fulltimedegree as a " +
            "left join( " +
            "select f.fulltimedegree,count(p.fulltimedegree_id) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_fulltimedegree f " +
            "where p.id=s.s_id and s.department_id=d.department_id and  p.fulltimedegree_id=f.fulltimedegree_id and d.department='食品科技学院党委' " +
            "group by p.fulltimedegree_id) as b " +
            "on a.fulltimedegree=b.fulltimedegree")
    List<Map<String,Integer>> queryDegreeDistributionByDepartment(@Param("department") String department);

    //4-1、查询二级党组织分布(不带参)
    @Select("select a.department department,if(b.count!=0,b.count,0) count " +
            "from dangpai_department as a " +
            "left join( " +
            "select d.department,count(s.department_id) count " +
            "from dangpai_staff_info s,dangpai_department d " +
            "where s.department_id=d.department_id and d.department != '（未说明）' " +
            "group by s.department_id) as b " +
            "on a.department=b.department " +
            "order by count desc")
    List<Map<String,Integer>> queryDepartmentDistribution();

    //4-2、查询二级党组织分布(带参)
    @Select("select d.department,count(s.department_id) count " +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d " +
            "where p.id=s.s_id and s.department_id=d.department_id and d.department != '（未说明）' and d.department= #{department} " +
            "group by s.department_id " +
            "order by count(s.department_id) desc")
    List<Map<String,Integer>> queryDepartmentDistributionByDepartment(@Param("department") String department);


}
