package com.atguigu.serviceprice.service;

import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.entity.AchievementArticleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface AchievementOfArticleService  {
    void addArticle(AchievementArticle article);

    void deleteArticleById(String id);

    void updateArticle(AchievementArticle article);

    AchievementArticle selectArticleById(String id);


    List<AchievementArticleVo> queryAllArticles(int page, int size);

    List<Map<String, String>> queryArticleType();

    Integer selectTotalArticles();

    List<AchievementArticleVo> queryArticleByType(String typeId,int page,int size);

    Integer selectTotalArticlesByType(String typeId);
}
