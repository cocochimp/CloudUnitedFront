package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Political;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PoliticalService extends IService<Political> {
    List<Political> queryAllPolitical();
}
