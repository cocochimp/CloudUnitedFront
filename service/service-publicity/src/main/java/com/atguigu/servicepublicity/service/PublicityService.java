package com.atguigu.servicepublicity.service;

import com.atguigu.servicepublicity.entity.Publicity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PublicityService {

    /*新增*/
    int insert(Publicity publicity);

    /*删除*/
    int delete(String xid);

    /*修改*/
    int update(Publicity publicity);

    /*查询*/
    List<Publicity> queryAll();

    /*根据类型查询*/
    Map queryByType(String type, long current, long number);

    /*根据文章名称查询*/
    List<Publicity> queryByTitle(String title);

    /*根据xid查询*/
    Publicity queryById(String xid);

    /*分页查询*/
    Map queryByPage(long current,long number);
}
