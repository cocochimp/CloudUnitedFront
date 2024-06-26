package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Political;
import com.atguigu.servicerenwuku.mapper.PoliticalMapper;
import com.atguigu.servicerenwuku.service.PoliticalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoliticalServiceImpl extends ServiceImpl<PoliticalMapper, Political> implements PoliticalService {
    @Override
    public List<Political> queryAllPolitical() {
        return baseMapper.selectList(null);
    }
}
