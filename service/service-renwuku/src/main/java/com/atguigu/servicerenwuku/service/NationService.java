package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface NationService extends IService<Nation> {
    List<Nation> queryAllNations();
}
