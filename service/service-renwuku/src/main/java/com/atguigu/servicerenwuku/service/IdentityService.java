package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Identity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IdentityService extends IService<Identity> {
    List<Identity> queryAllIdentities();
}
