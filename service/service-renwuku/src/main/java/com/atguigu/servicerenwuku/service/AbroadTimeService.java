package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.AbroadTime;
import com.atguigu.servicerenwuku.entity.Bachelor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface AbroadTimeService extends IService<AbroadTime> {
    List<AbroadTime> queryAbroadTime();
}
