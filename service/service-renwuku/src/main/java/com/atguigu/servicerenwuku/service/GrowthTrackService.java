package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.GrowthTrack;
import com.baomidou.mybatisplus.extension.service.IService;

public interface GrowthTrackService extends IService<GrowthTrack> {
    void updateByEntity(GrowthTrack growthTrack);
}
