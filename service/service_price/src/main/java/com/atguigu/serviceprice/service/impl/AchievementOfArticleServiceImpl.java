package com.atguigu.serviceprice.service.impl;


import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.entity.AchievementArticleVo;
import com.atguigu.serviceprice.entity.AchievementOfPhoto;
import com.atguigu.serviceprice.mapper.AchievementOfArticleMapper;
import com.atguigu.serviceprice.service.AchievementOfArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class AchievementOfArticleServiceImpl implements AchievementOfArticleService {
    @Autowired
    AchievementOfArticleMapper mapper;

    @Override
    public void addArticle(AchievementArticle article) {
        mapper.insert(article);
    }

    @Override
    public void deleteArticleById(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateArticle(AchievementArticle article) {
        mapper.updateById(article);
    }

    @Override
    public AchievementArticle selectArticleById(String id) {
        return mapper.selectById(id);
    }


    @Override
    public List<AchievementArticleVo> queryAllArticles(int page,int size) {
        List<AchievementArticleVo> list=mapper.selectList((page-1)*size,size);
        return list;
    }

    @Override
    public List<Map<String, String>> queryArticleType() {
        return mapper.queryArticleType();
    }

    @Override
    public Integer selectTotalArticles() {
        return mapper.selectTotalArticles();
    }

    @Override
    public List<AchievementArticleVo> queryArticleByType(String typeId, int page, int size) {
        List<AchievementArticleVo> list=mapper.queryArticleByType(typeId,(page-1)*size,size);
        return list;
    }

    @Override
    public Integer selectTotalArticlesByType(String typeId) {
        return mapper.selectTotalArticlesByType(typeId);
    }
}