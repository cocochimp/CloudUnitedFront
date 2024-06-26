package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Area;
import com.atguigu.servicerenwuku.entity.Campus;
import com.atguigu.servicerenwuku.mapper.CampusMapper;
import com.atguigu.servicerenwuku.service.CampusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServiceImpl extends ServiceImpl<CampusMapper, Campus>implements CampusService {
    @Override
    public List<Campus> queryAllCampuses() {
        return baseMapper.selectList(null);
    }
}
