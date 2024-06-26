package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Politics;
import com.atguigu.servicerenwuku.mapper.PoliticsMapper;
import com.atguigu.servicerenwuku.service.PoliticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsServiceImpl extends ServiceImpl<PoliticsMapper, Politics> implements PoliticsService {
    @Override
    public List<Politics> queryPolitics() {
        return baseMapper.selectList(null);
    }
}