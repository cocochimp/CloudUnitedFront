package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Party;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PartyService extends IService<Party> {
    List<Party> queryAllParty();

    void addParty(Party party);

    void deleteParty(String party_id);

    void updateParty(Party party);
}
