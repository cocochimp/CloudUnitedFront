package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.PartyOthers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PartyOthersService extends IService<PartyOthers> {
    List<PartyOthers> queryAllPartyOthers();
}
