package com.atguigu.servicedecisioncenter.service;

import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @description 针对表【student】的数据库操作Service
*/
public interface StudentService extends IService<Student> {

    /**
     * 查询少数民族学生民族分布
     * @return
     */
    ResultVo queryNationalOfStudent();
    ResultVo queryNationalByDepartmentOfStudent(String department);

    /**
     * 查询少数民族学生性别分布
     * @return
     */
    ResultVo querySexOfStudent();
    ResultVo querySexByDepartmentOfStudent(String department);

    /**
     * 查询少数民族学生数量
     * @return
     */
    ResultVo queryCountOfStudent();
    ResultVo queryCountOfStudentByDepartment(String department);

    /**
     * 查询少数民族学生学院分布
     * @return
     */
    ResultVo queryByDepartment();

}
