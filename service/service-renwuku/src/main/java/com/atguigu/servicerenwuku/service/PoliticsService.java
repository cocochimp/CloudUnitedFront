package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Politics;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PoliticsService  extends IService<Politics> {
    List<Politics> queryPolitics();
}
