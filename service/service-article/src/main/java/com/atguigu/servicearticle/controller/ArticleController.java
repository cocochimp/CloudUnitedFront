package com.atguigu.servicearticle.controller;


import com.atguigu.commonutils.R;
import com.atguigu.servicearticle.entity.*;
import com.atguigu.servicearticle.exception.AllException;
import com.atguigu.servicearticle.service.ArticleService;
import com.atguigu.servicearticle.util.DateTimeUtil;
import com.atguigu.servicearticle.util.UUIDUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@RefreshScope
@RestController
@RequestMapping("/servicearticle/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController {
    @Autowired
    ArticleService articleService;

    String age;
    /*分页查询*/
    @RequestMapping("/article/selectByPage")
    public ResultVo selectByPage(int current,int number){
        Map map = articleService.selectArticleByPage(current, number);
        ResultVo resultVo=new ResultVo();
        resultVo.setT(map);
        resultVo.setMess("分页查询文章成功");
        resultVo.setOk(true);
        return resultVo;
    }

    //查询所有文章
    @GetMapping("/article/queryAllArticles")
/*
    @Cacheable
*/
    public ResultVo queryAllArticles() {
        ResultVo resultVo = new ResultVo();
        List<Article> articles = articleService.queryAllArticles();
        resultVo.setT(articles);
        resultVo.setMess("查询所有文章成功");
        System.out.println("ok");
        resultVo.setOk(true);
        System.out.println();
        return resultVo;
    }

    //添加文章
    @PostMapping("/article/addArticle")
    public ResultVo addArticle(Article article) {
        ResultVo resultVo = new ResultVo();
        article.setId(UUIDUtil.getUUID());
        article.setReleaseTime(DateTimeUtil.getDate());
        try {
            articleService.addArticle(article);
            resultVo.setMess("添加文章成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //删除指定id的文章
    @PostMapping("/article/deleteArticleById")
    public ResultVo deleteArticleById(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            articleService.deleteArticleById(id);
            resultVo.setMess("删除文章成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }

        return resultVo;
    }

    //修改文章
    @PostMapping("/article/updateArticle")
    public ResultVo updateArticle(Article article) {
        ResultVo resultVo = new ResultVo();
        article.setReleaseTime(DateTimeUtil.getDate());
        try {
            articleService.updateArticle(article);
            resultVo.setMess("修改文章成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //查询指定id的文章
    @PostMapping("/article/queryArticleById")
    public ResultVo queryArticleById(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            Article article = articleService.queryArticleById(id);
            int totalPv = article.getTotalPv();
            totalPv += 1;
            int monPv=article.getMonPv();
            monPv+=1;
            article.setTotalPv(totalPv);
            article.setMonPv(monPv);
            articleService.updateArticle(article);
            resultVo.setT(article);
            resultVo.setMess("查询指定id的文章成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    //按照文章类型查找
    @GetMapping("/article/queryArticleByType")
    public ResultVo queryArticleByType(String type,long current,long number) {
        ResultVo resultVo = new ResultVo();
        try {
            Map map = articleService.queryByType(type, current, number);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }
        return resultVo;
    }

/*    public ResultVo queryArticleByType(String type) {
        ResultVo resultVo = new ResultVo();
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("type", type);
            queryWrapper.orderByDesc("releaseTime");
            List<Article> articles = articleService.queryArticleByType(queryWrapper);
            resultVo.setT(articles);
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }*/


    //按照文章位置 首页，民主党派和无党派人士 返回所有文章
    @GetMapping("/article/queryArticleByPosition")
    public ResultVo queryArticleByPosition(String position) {
        ResultVo resultVo = new ResultVo();
        List<Article> list=articleService.queryArticleByPosition(position);
        resultVo.setT(list);
        return resultVo;
    }




    //返回首页访问量
    @GetMapping("/article/queryIndexPv")
    public Pv queryIndexPv(){
        Pv pv=new Pv();
        pv.setPosition("首页");
        Map<String,List<ArticleCount>> map=articleService.queryIndexPv();
        List<String> yearList=articleService.queryDateList();
        pv.setMaxList(map.get("maxPv"));      //最大访问量
        pv.setMinList(map.get("minPv"));      //最少访问量
        pv.setAvgList(map.get("avgPv"));         //平均访问量
        pv.setDateList(yearList);
        return pv;
    }



    //返回民主党派文章访问量
    @GetMapping("/article/queryMinZhuDangPaiPv")
    public Pv queryMinZhuDangPaiPv(){
        Pv pv=new Pv();
        pv.setPosition("民主党派");
        Map<String,List<ArticleCount>> map=articleService.queryMinZhuDangPaiPv();
        List<String> yearList=articleService.queryDateList();
        pv.setMaxList(map.get("maxPv"));      //最大访问量
        pv.setMinList(map.get("minPv"));      //最少访问量
        pv.setAvgList(map.get("avgPv"));         //平均访问量
        pv.setDateList(yearList);
        return pv;
    }



    //返回参政议政访问量
    @GetMapping("/article/queryCanZhengYiZhenPv")
    public Pv queryCanZhengYiZhenPv(){
        Pv pv=new Pv();
        pv.setPosition("参政议政");
        Map<String,List<ArticleCount>> map=articleService.queryCanZhengYiZhenPv();
        List<String> yearList=articleService.queryDateList();
        pv.setMaxList(map.get("maxPv"));      //最大访问量
        pv.setMinList(map.get("minPv"));      //最少访问量
        pv.setAvgList(map.get("avgPv"));         //平均访问量
        pv.setDateList(yearList);
        return pv;
    }




    //查询当月首页文章访问量情况
    @GetMapping("/article/indexArticleCount")
    public ArticleMonPv indexArticleCount(){
        String position="首页";
        ArticleMonPv articleMonPv=articleService.indexArticleCount(position);
        return articleMonPv;
    }

    //查询当月民主党派模块文章访问量情况
    @GetMapping("/article/minZhuDangPaiArticleCount")
    public ArticleMonPv minZhuDangPaiArticleCount(){
        String position="民主党派";
        ArticleMonPv articleMonPv=articleService.minZhuDangPaiArticleCount(position);
        return articleMonPv;
    }



    //查询当月参政议政模块文章访问量情况
    @GetMapping("/article/canZhengYiZhenArticleCount")
    public ArticleMonPv canZhengYiZhenArticleCount(){
        String position="参政议政";
        ArticleMonPv articleMonPv=articleService.canZhengYiZhenArticleCount(position);
        return articleMonPv;
    }

    //首页搜索框查询
    @GetMapping("/article/indexQueryArticle")
    public ResultVo indexQueryArticle(String title){
        ResultVo resultVo = new ResultVo();
        List<Article> articleList=articleService.indexQueryArticle(title);
        resultVo.setT(articleList);
        return resultVo;
    }
}
