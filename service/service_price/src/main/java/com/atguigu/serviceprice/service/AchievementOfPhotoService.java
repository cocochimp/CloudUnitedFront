package com.atguigu.serviceprice.service;

import com.atguigu.serviceprice.entity.AchievementOfPhoto;
import com.atguigu.serviceprice.entity.AchievementOfPhotoVo;

import java.util.List;
import java.util.Map;

public interface AchievementOfPhotoService {
    void savePhoto(AchievementOfPhoto achievementOfPhoto);

    void deleteById(String id);

    void updatePhoto(AchievementOfPhoto achievementOfPhoto);

    List<AchievementOfPhotoVo> listAll(int page,int size);


    List<Map<String, String>> queryPhotoType();

    Integer queryTotalOfPhoto();

    List<AchievementOfPhotoVo> queryPhotoByType(String typeId, int page, int size);

    Integer queryPhotoTotalByType(String typeId);
}
