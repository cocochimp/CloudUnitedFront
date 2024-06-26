package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.entity.Student;
import com.atguigu.servicedecisioncenter.mapper.StudentMapper;
import com.atguigu.servicedecisioncenter.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @description 针对表【student】的数据库操作Service实现
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    ResultVo resultVo = new ResultVo();

    @Override
    public ResultVo queryNationalOfStudent() {
        try{

            List<Map<String,Object>> list= studentMapper.queryNationalOfStudent();

            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo queryNationalByDepartmentOfStudent(String department) {
        try{

            List<Map<String,Object>> list= studentMapper.queryNationalByDepartmentOfStudent(department);

            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo querySexOfStudent() {
        try{
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("sex, count(*) as total")
                    .groupBy("sex")
                    .orderByDesc("total");

            List<Map<String,Object>> list= listMaps(queryWrapper);

            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo querySexByDepartmentOfStudent(String department) {
        try{

            List<Map<String,Object>> list= studentMapper.querySexByDepartmentOfStudent(department);

            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo queryCountOfStudent() {
        try{
            int count = count(null);

            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo queryCountOfStudentByDepartment(String department) {
        try{
            int count = studentMapper.queryCountOfStudentByDepartment(department);

            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @Override
    public ResultVo queryByDepartment() {
        try{
            List<Map<String,Object>> list= studentMapper.queryByDepartment();

            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }
}




