package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.QueryResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.serviceorganization.entity.NationEntity;

import java.util.List;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
public interface NationService extends IService<NationEntity> {
    NationEntity getHanNation();

    QueryResult queryPageBySearch(String name, int page, int limit);

//    NationEntity getLessNation(String nationId);
}

