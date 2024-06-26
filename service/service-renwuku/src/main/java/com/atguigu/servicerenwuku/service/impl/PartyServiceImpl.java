package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Party;
import com.atguigu.servicerenwuku.mapper.PartyMapper;
import com.atguigu.servicerenwuku.service.PartyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {
    @Override
    public List<Party> queryAllParty() {
        return baseMapper.selectList(null);
    }

    @Override
    public void addParty(Party party) {
        baseMapper.insert(party);
    }

    @Override
    public void deleteParty(String party_id) {
        baseMapper.deleteById(party_id);
    }

    @Override
    public void updateParty(Party party) {
        baseMapper.updateById(party);
    }
}
