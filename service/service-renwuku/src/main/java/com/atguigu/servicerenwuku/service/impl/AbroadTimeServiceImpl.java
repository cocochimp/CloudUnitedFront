package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.AbroadTime;
import com.atguigu.servicerenwuku.entity.Bachelor;
import com.atguigu.servicerenwuku.mapper.AbroadTimeMapper;
import com.atguigu.servicerenwuku.service.AbroadTimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbroadTimeServiceImpl extends ServiceImpl<AbroadTimeMapper, AbroadTime> implements AbroadTimeService {
    @Override
    public List<AbroadTime> queryAbroadTime() {
        return baseMapper.selectList(null);
    }
}