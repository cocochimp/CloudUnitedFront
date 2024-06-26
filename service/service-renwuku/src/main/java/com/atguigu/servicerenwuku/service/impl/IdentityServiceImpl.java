package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Identity;
import com.atguigu.servicerenwuku.mapper.IdentityMapper;
import com.atguigu.servicerenwuku.service.IdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityServiceImpl extends ServiceImpl<IdentityMapper, Identity> implements IdentityService {
    @Override
    public List<Identity> queryAllIdentities() {
        return baseMapper.selectList(null);
    }
}
