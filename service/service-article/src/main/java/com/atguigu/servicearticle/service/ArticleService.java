package com.atguigu.servicearticle.service;

import com.atguigu.servicearticle.entity.Article;
import com.atguigu.servicearticle.entity.ArticleCount;
import com.atguigu.servicearticle.entity.ArticleMonPv;
import com.atguigu.servicearticle.entity.Pv;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
public interface ArticleService extends IService<Article> {
    /*分页查询*/
    Map selectArticleByPage(int current,int number);

    /*按文章类型分页查询*/
    Map queryByType(String type,long current,long number);

    List<Article> queryAllArticles();

    void addArticle(Article article);

    void deleteArticleById(String id);

    void updateArticle(Article article);

    Article queryArticleById(String id);

    List<Article> queryArticleByType(QueryWrapper queryWrapper);


    List<Article> queryArticleByPosition(String position);


    Map<String, List<ArticleCount>> queryIndexPv();

    Map<String, List<ArticleCount>> queryMinZhuDangPaiPv();

    Map<String, List<ArticleCount>> queryCanZhengYiZhenPv();

    List<String> queryDateList();

    ArticleMonPv indexArticleCount(String position);

    ArticleMonPv minZhuDangPaiArticleCount(String position);

    ArticleMonPv canZhengYiZhenArticleCount(String position);

    List<Article> indexQueryArticle(String title);
}
