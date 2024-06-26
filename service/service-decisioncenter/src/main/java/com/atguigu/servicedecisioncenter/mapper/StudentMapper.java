package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @description 针对表【student】的数据库操作Mapper
* @Entity generator.domain.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询少数民族学生民族分布 无参
     * @return
     */
    List<Map<String, Object>> queryNationalOfStudent();

    /**
     * 查询少数民族学生民族分布 有参
     * @param department
     * @return
     */
    List<Map<String, Object>> queryNationalByDepartmentOfStudent(@Param("department")String department);

    /**
     *查询少数民族学生性别分布 有参
     * @param department
     * @return
     */
    List<Map<String, Object>> querySexByDepartmentOfStudent(@Param("department")String department);

    /**
     * 查询少数民族学生人数 有参
     * @param department
     * @return
     */
    int queryCountOfStudentByDepartment(@Param("department")String department);

    /**
     * 查询少数民族学生学院分布
     * @return
     */
    List<Map<String, Object>> queryByDepartment();

}




