package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Religion;
import com.atguigu.servicerenwuku.mapper.ReligionMapper;
import com.atguigu.servicerenwuku.service.ReligionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReligionServiceImpl extends ServiceImpl<ReligionMapper, Religion> implements ReligionService {
    @Override
    public List<Religion> queryAllReligions() {
        return baseMapper.selectList(null);
    }
}
