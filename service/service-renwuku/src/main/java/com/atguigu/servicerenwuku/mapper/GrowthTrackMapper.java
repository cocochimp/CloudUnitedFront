package com.atguigu.servicerenwuku.mapper;

import com.atguigu.servicerenwuku.entity.GrowthTrack;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

public interface GrowthTrackMapper extends BaseMapper<GrowthTrack> {
    @Update("update renwuku_growthtrack set id=#{id},positionAxis=#{positionAxis},activeAxis=#{activeAxis},awardAxis=#{awardAxis} where id=#{id}")
    void updateByEntity(GrowthTrack growthTrack);
}
