package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Committee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommitteeService extends IService<Committee> {
    List<Committee> queryCommittee();
}
