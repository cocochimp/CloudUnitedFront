package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Nation;
import com.atguigu.servicerenwuku.mapper.NationMapper;
import com.atguigu.servicerenwuku.service.NationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements NationService {
    @Override
    public List<Nation> queryAllNations() {
        return baseMapper.selectList(null);
    }
}
