package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

public interface FrontPageMapper extends BaseMapper<Person> {

    //1-1、少数民族老师数量(不带参)
    @Select("select count(nation_id) total from dangpai_personal_info p " +
            "where p.nation_id!='6948231731531091977'")
    Integer queryNationalDistributionOfTeacher();

    //1-2、老师民族数量(带参)
    @Select("select count(nation_id) total from dangpai_personal_info p " +
            "left join dangpai_staff_info s on p.id=s.s_id  " +
            "left join dangpai_department d on s.department_id=d.department_id where p.nation_id!='6948231731531091977' and d.department=#{department}")
    Integer queryNationalDistributionOfTeacherByDepartment(@Param("department") String department);

    //1-3、少数民族学生数量(不带参)
    @Select("select count(id) from `renwuku_minoritystudent` ")
    Integer queryNationalDistributionOfStudent();

    //1-4、少数民族学生数量(带参)
    @Select("select count(id) from `renwuku_minoritystudent` r " +
            "left join dangpai_department d on r.department_id=d.department_id where d.department=#{department} ")
    Integer queryNationalDistributionOfStudentByDepartment(String department);




    //2-1、港澳台分布(不带参)
    @Select("select if(b.count!=0,b.count,0) total " +
            "from dangpai_area as a " +
            "left join( " +
            "select a.area,count(p.area_id) count " +
            "from dangpai_personal_info p,dangpai_area a " +
            "where p.area_id=a.area_id " +
            "group by area) as b " +
            "on a.area=b.area " +
            "order by total desc")
    List<Integer> queryGangAoTaiDistribution();

    //2-2、港澳台分布(带参)
    @Select("select if(b.count!=0,b.count,0) total " +
            "from dangpai_area as a " +
            "left join( " +
            "select a.area,count(p.area_id) count " +
            "from dangpai_personal_info p,dangpai_area a,dangpai_staff_info s,dangpai_department d " +
            "where p.area_id=a.area_id and p.id=s.s_id and s.department_id=d.department_id and d.department= #{department} " +
            "group by area) as b " +
            "on a.area=b.area " +
            "order by total desc")
//    List<Map<String,Integer>> queryGangAoTaiDistributionByDepartment(@Param("department") String department);
    List<Integer> queryGangAoTaiDistributionByDepartment(@Param("department") String department);

    //3-1、国家级获奖情况
    @Select("SELECT COUNT(*) FROM huojiang_price WHERE p_level='国家级'")
    List<Integer> queryAwardCountryLevel();

    //3-2、省级获奖情况
    @Select("SELECT COUNT(*) FROM huojiang_price WHERE p_level='省级'")
    List<Integer> queryAwardProvincialLevel();

    //4-1、统战工作对象
    List<Integer> queryWorkObject();

    //4-2、统战工作对象(带参)
    List<Integer> queryWorkObjectByDepartment(@Param("department") String department);



    List<Map<String,Integer>> queryWuDangPai();



    List<Map<String,Integer>>   queryWuDangPaiByDepartment(@Param("department") String department);

    //6-1、两代表一委员(无参)
    @Select("SELECT\n" +
            "\tifnull( a.count, 0 ) count \n" +
            "FROM\n" +
            "\t( SELECT * FROM dangpai_political p WHERE p.politicalPosition_id != \"6952297128416907199\" GROUP BY p.category ) p\n" +
            "\tLEFT JOIN (\n" +
            "SELECT\n" +
            "\tp.category,\n" +
            "\tcount( * ) count \n" +
            "FROM\n" +
            "\tdangpai_staff_info s,\n" +
            "\tdangpai_political p \n" +
            "WHERE\n" +
            "\ts.politicalPosition_id = p.politicalPosition_id \n" +
            "GROUP BY\n" +
            "\tp.category \n" +
            "\t) AS a ON p.category = a.category")
    List<Integer> queryLiangDaiBiao();


    //6-2、两代表一委员(带参)
    @Select("SELECT\n" +
            "\tifnull( a.count, 0 ) count \n" +
            "FROM\n" +
            "\t( SELECT * FROM dangpai_political p WHERE p.politicalPosition_id != \"6952297128416907199\" GROUP BY p.category ) p\n" +
            "\tLEFT JOIN (\n" +
            "SELECT\n" +
            "\tp.category,\n" +
            "\tcount( * ) count \n" +
            "FROM\n" +
            "\tdangpai_staff_info s,\n" +
            "\tdangpai_political p,\n" +
            "\tdangpai_department d \n" +
            "WHERE\n" +
            "\ts.politicalPosition_id = p.politicalPosition_id \n" +
            "\tAND s.department_id = d.department_id \n" +
            "\tAND d.department =#{department} \n" +
            "GROUP BY\n" +
            "\tp.category \n" +
            "\t) AS a ON p.category = a.category")
    List<Integer> queryLiangDaiBiaoByDepartment(String department);


    //9 统战人数
    List<Map<String,Integer>> totalCount();




    //10 参政议政情况
    @Select("select sum(number) from politics_eachyear group by year order by year")
    List<Integer> politics();


    //党外干部（无参）
    List<Map<String, Integer>> queryNonPartyCadres();


    //党外干部（带参）
    List<Map<String, Integer>> queryNonPartyCadresByDepartment(@Param("department") String department);


    List<String> queryQuanGuoRenDa();


    List<String> queryShiJiZhengXie();


    List<String> queryShenJiZhengXie();


    List<String> queryQuanGuoRenDaByDepartment(@Param("department") String department);

    List<String> queryShiJiZhengXieByDepartment(@Param("department") String department);

    List<String> queryShenJiZhengXieByDepartment(@Param("department") String department);




    @Select("select ifnull(count(politicalPosition_id),0) count from dangpai_staff_info ")
    List<Integer> queryCountListOfLiangDaiBiao();


    List<Integer> queryCountListOfLiangDaiBiaoByDepartment(String department);


    List<String> queryShiRenDa();

    List<String> queryShiRenDaByDepartment(String department);


}
