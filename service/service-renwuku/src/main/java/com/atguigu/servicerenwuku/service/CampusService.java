package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Area;
import com.atguigu.servicerenwuku.entity.Campus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CampusService extends IService<Campus> {
    List<Campus> queryAllCampuses();
}
