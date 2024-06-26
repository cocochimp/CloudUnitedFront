package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.CurrentPosition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CurrentPositionService extends IService<CurrentPosition> {
    //查询所有现任职位
    List<CurrentPosition> queryAllCurrentPosition();
    //增加现任职位
    void addCurrentPosition(CurrentPosition currentPosition);
    //删除现任职务
    void deleteCurrentPosition(String currentPosition_id);
    //修改现任职务
    void updateCurrentPosition(CurrentPosition currentPosition);
}
