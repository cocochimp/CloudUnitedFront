package com.atguigu.serviceorganization.dao;

import com.atguigu.serviceorganization.entity.DepartmentEntity;
import com.atguigu.serviceorganization.vo.DepartmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@Mapper
public interface DepartmentDao extends BaseMapper<DepartmentEntity> {
    List<DepartmentVo> queryPageBySearch(@Param("name") String name,@Param("department") String department);
}