package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ZongJiaoMapper extends BaseMapper<Person> {

    //1-1、查询年龄分布(无参)
    @Select("select \n" +
            "count(if(year(now())-convert(left(birth,4),unsigned)>60,true,null)) as 'age>60',\n" +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=51 and year(now())-convert(left(birth,4),unsigned)<=60,true,null)) as '51<=age<=60',\n" +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=41 and year(now())-convert(left(birth,4),unsigned)<=50,true,null)) as  '41<=age<=50',\n" +
            "count(if(year(now())-convert(left(birth,4),unsigned)>=31 and year(now())-convert(left(birth,4),unsigned)<=40,true,null)) as  '31<=age<=40',\n" +
            "count(if(year(now())-convert(left(birth,4),unsigned)<=30,true,null)) as  'age<=30' \n" +
            "from dangpai_personal_info p,dangpai_religion r\n" +
            "where p.religion_id=r.religion_id")
    Map<String, AgeResult> queryAgeDistribution();

    //1-2、查询年龄分布(一参)
    @Select("select \n" +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>60,true,null)) as 'age>60',\n" +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=51 and year(now())-convert(left(birth,4),unsigned)<=60,true,null)) as '51<=age<=60',\n" +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=41 and year(now())-convert(left(birth,4),unsigned)<=50,true,null)) as  '41<=age<=50',\n" +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)>=31 and year(now())-convert(left(birth,4),unsigned)<=40,true,null)) as  '31<=age<=40',\n" +
            "count(if(year(now())-convert(left(p.birth,4),unsigned)<=30,true,null)) as  'age<=30' \n" +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_religion r\n" +
            "where p.id=s.s_id and s.department_id=d.department_id and p.religion_id=r.religion_id and d.department= #{department} ")
    Map<String,AgeResult> queryAgeDistributionByDepartment(@Param("department") String department);

    //2-1、查询性别分布(无参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total\n" +
            "from dangpai_personal_info a\n" +
            "left join(\n" +
            "select sex,count(sex) count\n" +
            "from dangpai_personal_info p,dangpai_religion r\n" +
            "where p.religion_id=r.religion_id\n" +
            "group by p.sex) as b\n" +
            "on a.sex=b.sex")
    List<Map<String,Integer>> querySexDistribution();

    //2-2、查询性别分布(一参)
    @Select("select distinct a.sex,if(b.count!=0,b.count,0) total\n" +
            "from dangpai_personal_info a\n" +
            "left join(\n" +
            "select p.sex,count(p.sex) count\n" +
            "from dangpai_personal_info p,dangpai_staff_info s,dangpai_department d,dangpai_religion r\n" +
            "where p.id=s.s_id and s.department_id=d.department_id and p.religion_id=r.religion_id and d.department= #{department} \n" +
            "group by p.sex) as b\n" +
            "on a.sex=b.sex ")
    List<Map<String,Integer>> querySexDistributionByDepartment(@Param("department") String department);

    //3-1、查询宗教分布(无参)
    @Select("select distinct a.religion,if(b.count!=0,b.count,0) total\n" +
            "from dangpai_religion a\n" +
            "left join(\n" +
            "select p.religion_id,count(p.religion_id) count\n" +
            "from dangpai_personal_info p,dangpai_religion r\n" +
            "where p.religion_id=r.religion_id \n" +
            "group by p.religion_id) as b\n" +
            "on a.religion_id=b.religion_id")
    List<Map<String,Integer>> queryReligionDistribution();

    //3-2、查询宗教分布(一参)
    @Select("select distinct a.religion,if(b.count!=0,b.count,0) total\n" +
            "from dangpai_religion a\n" +
            "left join(\n" +
            "select p.religion_id,count(p.religion_id) count\n" +
            "from dangpai_personal_info p,dangpai_religion r,dangpai_department d,dangpai_staff_info s\n" +
            "where p.religion_id=r.religion_id and p.id=s.s_id and s.department_id=d.department_id and d.department= #{department} \n" +
            "group by p.religion_id) as b\n" +
            "on a.religion_id=b.religion_id")
    List<Map<String,Integer>> queryReligionDistributionByDepartment(@Param("department") String department);


    //4-1、二级党组织分布(无参)
    @Select("select a.department department\n" +
            "from dangpai_department as a\n" +
            "left join(\n" +
            "select d.department,count(s.department_id) count\n" +
            "from dangpai_staff_info s,dangpai_department d,dangpai_personal_info p,dangpai_religion r\n" +
            "where s.department_id=d.department_id and s.s_id=p.id and p.religion_id=r.religion_id\n" +
            "group by s.department_id\n" +
            "order by count desc ) as b\n" +
            "on a.department=b.department")
    List<String> queryDepartment();


    //4-2、二级党组织分布(无参)
    @Select("select if(b.count!=0,b.count,0) total\n" +
            "from dangpai_department as a\n" +
            "left join(\n" +
            "select d.department,count(s.department_id) count\n" +
            "from dangpai_staff_info s,dangpai_department d,dangpai_personal_info p,dangpai_religion r\n" +
            "where s.department_id=d.department_id and s.s_id=p.id and p.religion_id=r.religion_id\n" +
            "group by s.department_id) as b\n" +
            "on a.department=b.department\n" +
            "order by total desc")
    List<Integer> queryDepartmentTotal();

}
