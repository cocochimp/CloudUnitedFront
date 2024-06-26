package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Fulltimedegree;
import com.atguigu.servicerenwuku.mapper.FullTimeDegreeMapper;
import com.atguigu.servicerenwuku.service.FullTimeDegreeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullTimeDegreeServiceImpl extends ServiceImpl<FullTimeDegreeMapper, Fulltimedegree> implements FullTimeDegreeService {
    @Override
    public List<Fulltimedegree> queryAllFullTimeDegree() {
        return baseMapper.selectList(null);
    }

    @Override
    public void addFullTimeDegree(Fulltimedegree fulltimedegree) {
        baseMapper.insert(fulltimedegree);
    }

    @Override
    public void deleteFullTimeDegree(String fulltimedegree_id) {
        baseMapper.deleteById(fulltimedegree_id);
    }

    @Override
    public void updateFullTimeDegree(Fulltimedegree fulltimedegree) {
        baseMapper.updateById(fulltimedegree);
    }
}
