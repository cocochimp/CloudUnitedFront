package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface AreaService extends IService<Area> {
    List<Area> queryAllAreas();
}
