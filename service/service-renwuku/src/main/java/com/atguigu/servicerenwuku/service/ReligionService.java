package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Religion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ReligionService extends IService<Religion> {
    List<Religion> queryAllReligions();
}
