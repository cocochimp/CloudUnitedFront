package com.atguigu.serviceprice.service.impl;

import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.entity.AchievementOfPhoto;
import com.atguigu.serviceprice.entity.AchievementOfPhotoVo;
import com.atguigu.serviceprice.mapper.AchievementOfPhotoMapper;
import com.atguigu.serviceprice.service.AchievementOfPhotoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AchievementOfPhotoImpl  implements AchievementOfPhotoService {
    @Autowired
    AchievementOfPhotoMapper mapper;

    @Override
    public void savePhoto(AchievementOfPhoto achievementOfPhoto) {
        mapper.insert(achievementOfPhoto);
    }

    @Override
    public void deleteById(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updatePhoto(AchievementOfPhoto achievementOfPhoto) {
        mapper.updateById(achievementOfPhoto);
    }

    @Override
    public List<AchievementOfPhotoVo> listAll(int page,int size) {
        List<AchievementOfPhotoVo> list=mapper.selectList((page-1)*size,size);

        return list;
    }

    @Override
    public List<Map<String, String>> queryPhotoType() {
        return mapper.queryPhotoType();
    }

    @Override
    public Integer queryTotalOfPhoto() {
        return mapper.queryTotalOfPhoto();
    }

    @Override
    public List<AchievementOfPhotoVo> queryPhotoByType(String typeId, int page, int size) {
        List<AchievementOfPhotoVo> list=mapper.queryPhotoByType(typeId,(page-1)*size,size);
        return list;
    }

    @Override
    public Integer queryPhotoTotalByType(String type) {
        return mapper.queryPhotoTotalByType(type);
    }


}