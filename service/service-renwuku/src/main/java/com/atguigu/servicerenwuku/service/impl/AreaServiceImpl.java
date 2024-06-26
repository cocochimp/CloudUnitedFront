package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Area;
import com.atguigu.servicerenwuku.mapper.AreaMapper;
import com.atguigu.servicerenwuku.service.AreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {
    @Override
    public List<Area> queryAllAreas() {
        return baseMapper.selectList(null);
    }
}
