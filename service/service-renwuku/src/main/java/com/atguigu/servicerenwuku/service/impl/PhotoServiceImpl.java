package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Photo;
import com.atguigu.servicerenwuku.mapper.PhotoMapper;
import com.atguigu.servicerenwuku.service.PhotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl  extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {
}