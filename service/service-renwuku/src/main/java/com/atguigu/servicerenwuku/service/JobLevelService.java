package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.JobLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface JobLevelService extends IService<JobLevel> {
    List<JobLevel> queryAllJobLevel();
}
