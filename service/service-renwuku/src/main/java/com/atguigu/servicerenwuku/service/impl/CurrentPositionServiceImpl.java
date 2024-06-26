package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.CurrentPosition;
import com.atguigu.servicerenwuku.mapper.CurrentPositionMapper;
import com.atguigu.servicerenwuku.service.CurrentPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentPositionServiceImpl extends ServiceImpl<CurrentPositionMapper, CurrentPosition> implements CurrentPositionService {
    //查询所有现任职位
    @Override
    public List<CurrentPosition> queryAllCurrentPosition() {
        return baseMapper.selectList(null);
    }

    //增加现任职位
    @Override
    public void addCurrentPosition(CurrentPosition currentPosition) {
        baseMapper.insert(currentPosition);
    }

    //删除现任职务
    @Override
    public void deleteCurrentPosition(String currentPosition_id) {
        baseMapper.deleteById(currentPosition_id);
    }

    //修改现任职务
    @Override
    public void updateCurrentPosition(CurrentPosition currentPosition) {
        baseMapper.updateById(currentPosition);
    }
}
