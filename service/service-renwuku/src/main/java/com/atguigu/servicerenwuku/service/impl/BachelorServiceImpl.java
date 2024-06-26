package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Bachelor;
import com.atguigu.servicerenwuku.mapper.BachelorMapper;
import com.atguigu.servicerenwuku.service.BachelorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BachelorServiceImpl extends ServiceImpl<BachelorMapper, Bachelor> implements BachelorService {
    @Override
    public List<Bachelor> queryBachelor() {
        return baseMapper.selectList(null);
    }
}