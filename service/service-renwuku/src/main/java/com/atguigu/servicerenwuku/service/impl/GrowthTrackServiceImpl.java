package com.atguigu.servicerenwuku.service.impl;


import com.atguigu.servicerenwuku.entity.GrowthTrack;
import com.atguigu.servicerenwuku.mapper.GrowthTrackMapper;
import com.atguigu.servicerenwuku.service.GrowthTrackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GrowthTrackServiceImpl extends ServiceImpl<GrowthTrackMapper, GrowthTrack> implements GrowthTrackService {
    @Override
    public void updateByEntity(GrowthTrack growthTrack) {
        baseMapper.updateByEntity(growthTrack);
    }
}