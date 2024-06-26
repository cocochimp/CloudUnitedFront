package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.entity.AchievementArticleVo;
import com.atguigu.serviceprice.entity.ResultVo;
import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.service.AchievementOfArticleService;
import com.atguigu.serviceprice.util.DateTimeUtil;
import com.atguigu.serviceprice.util.IdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/servicefile/scientificAchievementOfArticle")
@Api(tags = "文章上传")
public class AchievementOfArticleController {
    @Autowired
    AchievementOfArticleService articleService;


    //查询所有文章
    @GetMapping("/queryAllArticles")
    @ApiOperation("文章展示")
    public ResultVo queryAllArticles(int page,int size) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> map=new HashMap<>();
        List<AchievementArticleVo> articles = articleService.queryAllArticles(page,size);
        Integer total=articleService.selectTotalArticles();
        map.put("list",articles);
        map.put("total",total);
        resultVo.setT(map);
        resultVo.setMess("查询所有文章成功");
        System.out.println("ok");
        resultVo.setOk(true);
        System.out.println();
        return resultVo;
    }

    //添加文章
    @ApiOperation("文章添加")
    @PostMapping("/addArticle")
    public ResultVo addArticle(AchievementArticle article) {
        ResultVo resultVo = new ResultVo();
        IdWorker idWorker = new IdWorker(1, 1);
        String id = String.valueOf(idWorker.nextId());
        article.setId(id);
        article.setReleaseTime(DateTimeUtil.getDate());
        article.setUpdateTime(DateTimeUtil.getDate());
        try {
            articleService.addArticle(article);
            resultVo.setMess("添加文章成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //删除指定id的文章
    @ApiOperation("文章删除传值文章id")
    @PostMapping("/deleteArticleById")
    public ResultVo deleteArticleById(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            articleService.deleteArticleById(id);
            resultVo.setMess("删除文章成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }

        return resultVo;
    }

    //修改文章
    @ApiOperation("文章修改")
    @PostMapping("/updateArticle")
    public ResultVo updateArticle(AchievementArticle article) {
        ResultVo resultVo = new ResultVo();
        article.setUpdateTime(DateTimeUtil.getDate());
        try {
            articleService.updateArticle(article);
            article.setUpdateTime(DateTimeUtil.getDate());
            resultVo.setMess("修改文章成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }

    //查询指定id的文章
    @ApiOperation("文章查询传值id查询鼠标点击的文章")
    @PostMapping("/queryArticleById")
    public ResultVo queryArticleById(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            AchievementArticle article=articleService.selectArticleById(id);
            resultVo.setT(article);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation("查询文章类别")
    @PostMapping("/queryArticleType")
    public ResultVo queryArticleType() {
        ResultVo resultVo = new ResultVo();
        List<Map<String, String>> list;
        try {
            list=articleService.queryArticleType();
            resultVo.setT(list);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation("文章分类查询")
    @PostMapping("/queryArticleByType")
    public ResultVo queryArticleByType(String typeId,int page,int size) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> map=new HashMap<>();
        List<AchievementArticleVo> articles = articleService.queryArticleByType(typeId,page,size);
        Integer total=articleService.selectTotalArticlesByType(typeId);
        map.put("list",articles);
        map.put("total",total);
        resultVo.setT(map);
        resultVo.setMess("查询所有文章成功");
        System.out.println("ok");
        resultVo.setOk(true);
        System.out.println();
        return resultVo;
    }
}