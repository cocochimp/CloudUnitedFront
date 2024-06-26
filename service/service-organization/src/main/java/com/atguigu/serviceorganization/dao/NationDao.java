package com.atguigu.serviceorganization.dao;

import com.atguigu.serviceorganization.entity.NationEntity;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.atguigu.serviceorganization.vo.PersonVo;
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
public interface NationDao extends BaseMapper<NationEntity> {
    List<PersonVo> queryPageBySearch(@Param("name") String name);

//    NationEntity getLessNation(@Param("nationId") String nationId);
}
