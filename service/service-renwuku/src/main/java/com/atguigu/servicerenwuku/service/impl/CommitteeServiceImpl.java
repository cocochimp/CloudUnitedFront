package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Committee;
import com.atguigu.servicerenwuku.mapper.CommitteeMapper;
import com.atguigu.servicerenwuku.service.CommitteeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeServiceImpl extends ServiceImpl<CommitteeMapper, Committee> implements CommitteeService {
    @Override
    public List<Committee> queryCommittee() {
        return baseMapper.selectList(null);
    }
}
