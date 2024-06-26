package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FrontPageService extends IService<Person> {

    Integer queryNationalDistributionOfTeacher();
    Integer queryNationalDistributionOfTeacherByDepartment(String department);

//    List<Map<String,Integer>> queryGangAoTaiDistribution();
//    List<Map<String,Integer>> queryGangAoTaiDistributionByDepartment(String department);

    List<Integer> queryGangAoTaiDistribution();

    List<Integer> queryGangAoTaiDistributionByDepartment(@Param("department") String department);

    List<Integer> queryAwardCountryLevel();

    List<Integer> queryAwardProvincialLevel();

    //查询统战工作对象
    List<Integer> queryWorkObject();

    //通过部门查询统战工作对象
    List<Integer> queryWorkObjectByDepartment(String department);

    //首页查询无党派，知联会，留学归国人员
    List<Map<String,Integer>> queryWuDangPai();
    //通过部门首页查询无党派，知联会，留学归国人员
    List<Map<String,Integer>> queryWuDangPaiByDepartment(String department);

    //首页查询两代表一委员
    List<Integer> queryLiangDaiBiao();

    //首页通过部门查询两代表一委员
    List<Integer> queryLiangDaiBiaoByDepartment(String department);

    List<Map<String,Integer>> totalCount();

    //参政议政情况
    List<Integer> politics();

    List<Map<String, Integer>> queryNonPartyCadres();

    List<Map<String, Integer>> queryNonPartyCadresByDepartment(String department);

    List<String> queryQuanGuoRenDa();

    List<String> queryShiJiZhengXie();

    List<String> queryShenJiZhengXie();

    List<String> queryQuanGuoRenDaByDepartment(String department);

    List<String> queryShiJiZhengXieByDepartment(String department);

    List<String> queryShenJiZhengXieByDepartment(String department);



    List<String> queryCountListOfLiangDaiBiao();

    List<String> queryCountListOfLiangDaiBiaoByDepartment(String department);

    Integer queryNationalDistributionOfStudent();

    Integer queryNationalDistributionOfStudentByDepartment(String department);

    List<String> queryShiRenDa();

    List<String> queryShiRenDaByDepartment(String department);

}
