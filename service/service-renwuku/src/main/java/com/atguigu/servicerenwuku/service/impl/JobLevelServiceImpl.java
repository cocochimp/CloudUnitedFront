package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.JobLevel;
import com.atguigu.servicerenwuku.mapper.JobLevelMapper;
import com.atguigu.servicerenwuku.service.JobLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelServiceImpl extends ServiceImpl<JobLevelMapper, JobLevel> implements JobLevelService {
    @Override
    public List<JobLevel> queryAllJobLevel() {
        return baseMapper.selectList(null);
    }
}
