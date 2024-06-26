package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.PartyOthers;
import com.atguigu.servicerenwuku.mapper.PartyOtherMapper;
import com.atguigu.servicerenwuku.service.PartyOthersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyOthersServiceImpl extends ServiceImpl<PartyOtherMapper, PartyOthers> implements PartyOthersService {
    @Override
    public List<PartyOthers> queryAllPartyOthers() {
        return baseMapper.selectList(null);
    }
}
