package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.AgeResult;
import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.ShaoShuMinZuService;
import com.atguigu.servicedecisioncenter.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/service/servicedecisioncenter/ShaoShuMinZu")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "4、少数民族接口")
public class ShaoShuMinZuController {

    @Autowired
    ShaoShuMinZuService service;

    @Resource
    private StudentService studentService;

    ResultVo resultVo = new ResultVo();

    //1-1、学历分布(不带参)
    @ApiOperation(value = "1-1、教师学历分布(主页)")
    @PostMapping("/queryDegree")
    public ResultVo queryDegree() {
        try {
            List<Map<String, Integer>> integerList = service.queryDegreeDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-2、学历分布(带参)
    @ApiOperation(value = "1-2、教师学历分布(点击学院分)")
    @PostMapping("/queryDegree/{department}")
    public ResultVo queryDegreeByDepartment(@PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.queryDegreeDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-3 教师总数 --民族分布 性别分布 学历分布 职称分布 学院分布(无参)
    @ApiOperation(value = "1-3 教师总数 --民族分布 性别分布 学历分布 职称分布 学院分布(无参)")
    @PostMapping("/queryCountOfTeacher")
    public ResultVo queryCountOfTeacher() {
        try {
            Integer count = service.queryCountOfTeacher();

            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //1-4 教师总数 --民族分布 性别分布 学历分布 职称分布 学院分布(有参)
    @ApiOperation(value = "1-4 教师总数 --民族分布 性别分布 学历分布 职称分布 学院分布(有参)")
    @PostMapping("/queryCountOfTeacherByDepartment/{department}")
    public ResultVo queryCountOfTeacherByDepartment(@PathVariable("department") String department) {
        try {
            Integer count = service.queryCountOfTeacherByDepartment(department);

            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


    //2-1、性别分布(不带参)
    @ApiOperation(value = "2-1、教师性别分布(主页)")
    @PostMapping("/querySex")
    public ResultVo querySex() {
        try {
            List<Map<String, Integer>> integerList = service.querySexDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-2、性别分布(带参)
    @ApiOperation(value = "2-2、教师性别分布(点击学院分)")
    @PostMapping("/querySex/{department}")
    public ResultVo querySexByDepartment(@PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.querySexDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


    //3、二级党组织分布(不带参)
    @ApiOperation(value = "3、教师二级党组织分布(主页和点击学院分相同)")
    @PostMapping("/queryDepartment")
    public ResultVo queryDepartment() {
        try {
            List<Map<String, Integer>> integerList = service.queryDepartmentDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-1、民族分布(不带参)
    @ApiOperation(value = "4-1、教师民族分布(主页)")
    @PostMapping("/queryNational")
    public ResultVo queryNational() {
        try {
            List<Map<String, Integer>> integerList = service.queryNationalDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //4-2、民族分布(带参)
    @ApiOperation(value = "4-2、教师民族分布(点击学院分)")
    @PostMapping("/queryNational/{department}")
    public ResultVo queryNationalByDepartment(@PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.queryNationalDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }



    //5-1、职称分布(无参)
    @ApiOperation(value = "5-1、教师职称分布(无参)")
    @PostMapping("/queryTitle")
    public ResultVo queryTitle() {
        try {
            List<Map<String, Integer>> integerList = service.queryTitleDistribution();

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //5-2、职称分布(有参)
    @ApiOperation(value = "5-2、教师职称分布(有参)")
    @PostMapping("/queryTitle/{department}")
    public ResultVo queryTitleByDepartment(@PathVariable("department") String department) {
        try {
            List<Map<String, Integer>> integerList = service.queryTitleDistributionByDepartment(department);

            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "6-1、民族分布(无参)（学生）")
    @PostMapping("/queryNationalOfStudent")
    public ResultVo queryNationalOfStudent() {
        return studentService.queryNationalOfStudent();
    }

    @ApiOperation(value = "6-2、民族分布(点击学院分)(学生)")
    @PostMapping("/queryNationalOfStudent/{department}")
    public ResultVo queryNationalByDepartmentOfStudent(@PathVariable("department") String department) {
        return studentService.queryNationalByDepartmentOfStudent(department);
    }

    @ApiOperation(value = "7-1、性别分布(点击学院分)(学生)")
    @PostMapping("/querySexOfStudent")
    public ResultVo querySexOfStudent() {
        return studentService.querySexOfStudent();
    }

    @ApiOperation(value = "7-2、性别分布(点击学院分)（学生）")
    @PostMapping("/querySexOfStudent/{department}")
    public ResultVo querySexByDepartmentOfStudent(@PathVariable("department") String department) {
        return studentService.querySexByDepartmentOfStudent(department);
    }

    @ApiOperation(value = "8-2 学生总数 --民族分布 性别分布  学院分布(无参)")
    @PostMapping("/queryCountOfStudentByDepartment")
    public ResultVo queryCountOfStudent() {
        return studentService.queryCountOfStudent();
    }

    @ApiOperation(value = "8-2 学生总数 --民族分布 性别分布  学院分布(有参)")
    @PostMapping("/queryCountOfStudentByDepartment/{department}")
    public ResultVo queryCountOfStudentByDepartment(@PathVariable("department") String department) {
        return studentService.queryCountOfStudentByDepartment(department);
    }

    @ApiOperation(value = "9 学院分布(学生)")
    @PostMapping("/queryByDepartmentOfStudent")
    public ResultVo queryByDepartmentOfStudent() {
        return studentService.queryByDepartment();
    }


}
