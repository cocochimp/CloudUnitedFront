package com.atguigu.servicearticle.service.impl;

import com.atguigu.servicearticle.entity.*;
import com.atguigu.servicearticle.mapper.ArticleMapper;
import com.atguigu.servicearticle.service.ArticleService;
import com.atguigu.servicearticle.util.UUIDUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.lang.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    /*分页查询*/
    @Override
    public Map selectArticleByPage(int current, int number) {
        IPage page=new Page(current,number);
        baseMapper.selectPage(page,null);
        long pages = page.getPages(); //总页数
        List<Article> articles=page.getRecords();
        for (Article article : articles) {
            article.setContent("");
        }
        long total = page.getTotal(); //文章总条数
        Map map=new HashMap();
        map.put("pages",pages);
        map.put("totalNum",total);
        map.put("Article",articles);

        return map;
    }

    /*按文章类型分页查询*/
    @Override
    public Map queryByType(String type, long current, long number) {
        IPage page=new Page(current,number);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("type",type);
        queryWrapper.orderByDesc("releaseTime");
        baseMapper.selectPage(page,queryWrapper);
        long pages = page.getPages(); //总页数
        List<Article> articles=page.getRecords();
        for (Article article : articles) {
            article.setContent("");
        }
        long total = page.getTotal(); //文章总条数
        Map map=new HashMap();
        map.put("pages",pages);
        map.put("totalNum",total);
        map.put("Article",articles);
        return map;
    }

    @Override
    public List<Article> queryAllArticles() {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("releaseTime");
        List<Article> articles=baseMapper.selectList(queryWrapper);
        for (Article article : articles) {
            article.setContent("");
        }
        return articles;
    }

    @Override
    public void addArticle(Article article) {
        Article article1 = UpdateContent(article);
        baseMapper.insert(article1);
    }

    /**
     * 将base编码转成图片，然后存储到本地文件中
     * @param article
     * @return
     */
    public Article UpdateContent(Article article) {
        StringBuilder builder = new StringBuilder(article.getContent());
        //key:图片的编号 value：图片的本地路径
        Map<String, String> map = new HashMap<>();
        int count = 1;

        //将content中的图片base64编码替换成photo
        while (builder.toString().contains("base64,")) {
            String builderStr = builder.toString();

            //找出图片base64编码
            String baseStr = StringUtils.substring(builderStr, builder.indexOf("base64,") + 7, builder.indexOf("\">", builder.indexOf("base64,") + 7));

            //进行替换
            builderStr = StringUtils.replaceOnce(builderStr, baseStr, "photo" + count);
            builderStr = StringUtils.replaceOnce(builderStr, "base64,", "");

            //如果有相同的照片
            while (builderStr.contains(baseStr)) {
                builderStr = StringUtils.replaceOnce(builderStr, baseStr, "photo" + count);
                builderStr = StringUtils.replaceOnce(builderStr, "base64,", "");
            }


            builder = new StringBuilder(builderStr);

            //将图片放入到本地中
            String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
            String path = "E:\\demo\\" + uuid + ".jpg";
            boolean b = base64StrToImage(baseStr, path);

            //map中存入信息
            map.put("photo" + count, path);
            count++;
        }

        article.setContent(builder.toString());
        article.setImgpath(map.toString());
        return article;
    }

    /**
     *将base64字符串转成图片
     * @param imgStr
     * @param path
     * @return
     */
    public static boolean base64StrToImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // 解密
            byte[] b = decoder.decode(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 文件夹不存在则自动创建
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteArticleById(String id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        Article article1 = UpdateContent(article);
        baseMapper.updateById(article1);
    }

    @Override
    public Article queryArticleById(String id) {
        Article article = getById(id);
        if (Strings.hasText(article.getImgpath())) {
            article.setContent(getCompleteContent(article));
        }
        return article;
    }

    /**
     * 得到完整的content内容
     * @param article
     * @return
     */
    public String getCompleteContent(Article article) {
        String content = article.getContent();
        String imgPath = article.getImgpath();
        imgPath = imgPath.substring(1, imgPath.length() - 1);
        String[] strs = imgPath.split(",");
        Map<String, String> map = new HashMap<String, String>();

        //得到map集合
        for (String string : strs) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];
            // 去掉头部空格
            String key1 = key.trim();
            String value1 = value.trim();
            map.put(key1, value1);
        }

        //将content中的占位符转换为base64编码
        for (int i = 1; i < map.size() + 1; i++) {
            String key = "photo" + i;
            String path = map.get(key);
            String baseStr = imageToBase64Str(path);

            String replaceStr = "";
            replaceStr += "base64,";
            replaceStr += baseStr;

            content = StringUtils.replace(content, key, replaceStr);
        }
        return content;
    }

    /**
     * 图片转base64字符串
     *
     * @param imgFile 图片路径
     * @return
     */
    public static String imageToBase64Str(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Base64.Encoder encoder = Base64.getEncoder();
        // BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeToString(data);
    }

    @Override
    public List<Article> queryArticleByType(QueryWrapper queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }


    //按照文章的模块查询，有首页，参政议政，无党派人士，参政议政
    @Override
    public List<Article> queryArticleByPosition(String position) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("position",position);
        queryWrapper.orderByDesc("releaseTime");
        List<Article> list=baseMapper.selectList(queryWrapper);
        return list;
    }


    //查询之前五个月份首页模块文章访问量情况
    @Override
    public Map<String, List<ArticleCount>> queryIndexPv() {
        String position="首页";
        List<ArticleCount> list=baseMapper.maxPv(position);
        List<ArticleCount> list1=baseMapper.minPv(position);
        List<ArticleCount> list2=baseMapper.avgPv(position);
        Map<String,List<ArticleCount>> map=new HashMap<>();
        map.put("maxPv",list);
        map.put("minPv",list1);
        map.put("avgPv",list2);
        return map;
    }


    //查询之前五个月份民主党派模块文章访问量情况
    @Override
    public Map<String, List<ArticleCount>> queryMinZhuDangPaiPv() {
        String position="民主党派";
        List<ArticleCount> list=baseMapper.maxPv(position);
        List<ArticleCount> list1=baseMapper.minPv(position);
        List<ArticleCount> list2=baseMapper.avgPv(position);
        List<String>   list3=baseMapper.datePv(position);
        Map<String,List<ArticleCount>> map=new HashMap<>();
        map.put("maxPv",list);
        map.put("minPv",list1);
        map.put("avgPv",list2);
        return map;
    }


    //查询之前五个月份参政议政模块文章访问量情况
    @Override
    public Map<String, List<ArticleCount>> queryCanZhengYiZhenPv() {
        String position="参政议政";
        List<ArticleCount> list=baseMapper.maxPv(position);
        List<ArticleCount> list1=baseMapper.minPv(position);
        List<ArticleCount> list2=baseMapper.avgPv(position);
        Map<String,List<ArticleCount>> map=new HashMap<>();
        map.put("maxPv",list);
        map.put("minPv",list1);
        map.put("avgPv",list2);
        return map;
    }


    //大数据展示平台文章访问量模块统计年月的
    @Override
    public List<String> queryDateList() {
        List<String> list=baseMapper.queryDateList();
        return list;
    }



    //查询当月首页文章访问量情况
    @Override
    public ArticleMonPv indexArticleCount(String position) {
        ArticleMonPv articleMonPv=baseMapper.articleCount(position);
        return articleMonPv ;
    }



    //查询当月民主党派模块文章访问量情况
    @Override
    public ArticleMonPv minZhuDangPaiArticleCount(String position) {
        ArticleMonPv articleMonPv=baseMapper.articleCount(position);
        return articleMonPv ;
    }


    //查询当月参政议政模块文章访问量情况
    @Override
    public ArticleMonPv canZhengYiZhenArticleCount(String position) {
        ArticleMonPv articleMonPv=baseMapper.articleCount(position);
        return articleMonPv ;
    }

    @Override
    public List<Article> indexQueryArticle(String title) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("title",title);
        return baseMapper.selectList(queryWrapper);
    }


    //定时更新每个月的文章访问量统计：最大访问量，最少访问量，平均访问量 定时（cron="秒 分 时 日 月 周几"）
    @Scheduled(cron = "0 50 23 28-31 * *")
    public void uploadMonPv() {
        final Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            ArticleMonPv articleMonPv = baseMapper.uploadIndexMonPv();   //首页
            ArticleMonPv articleMonPv1 = baseMapper.uploadMinZhuDangPaiMonPv();   //民主党派
            ArticleMonPv articleMonPv2= baseMapper.uploadCanZhengMonPv();   //参政议政

            articleMonPv.setPosition("首页");
            articleMonPv1.setPosition("民主党派");
            articleMonPv2.setPosition("参政议政");


            Calendar now = Calendar.getInstance();
            String year=String.valueOf(now.get(Calendar.YEAR));  //获取当前年份
            String month=String.valueOf(now.get(Calendar.MONTH)+1+""); //获取当前月份
            String date=year+"年"+month+"月";

            ArticlePv articlePv = new ArticlePv(UUIDUtil.getUUID(), date, articleMonPv.getMaxPv(), articleMonPv.getMinPv(), articleMonPv.getAvgPv(),articleMonPv.getPosition());
            ArticlePv articlePv1 = new ArticlePv(UUIDUtil.getUUID(), date, articleMonPv1.getMaxPv(), articleMonPv1.getMinPv(), articleMonPv1.getAvgPv(),articleMonPv1.getPosition());
            ArticlePv articlePv2 = new ArticlePv(UUIDUtil.getUUID(), date, articleMonPv2.getMaxPv(), articleMonPv2.getMinPv(), articleMonPv2.getAvgPv(),articleMonPv2.getPosition());

            baseMapper.addMonPv(articlePv);
            baseMapper.addMonPv(articlePv1);
            baseMapper.addMonPv(articlePv2);
            baseMapper.updateMonPv();


            String oldDate=null;

            /*判断当前月份
             * 如果是1-5月份删除年份需要删除最后的一条是去年的
             * 6-12月份就删除是本年的五月前的
             * 比如说当前为6月，就删除1月份的
             */
            switch (now.get(Calendar.MONTH)+1){
                case 1:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"8月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 2:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"9月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 3:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"10月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 4:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"11月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 5:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"12月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 6:
                    oldDate=String.valueOf(now.get(Calendar.YEAR))+"年"+"1月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 7:
                    oldDate=String.valueOf(now.get(Calendar.YEAR))+"年"+"2月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 8:
                    oldDate=String.valueOf(now.get(Calendar.YEAR))+"年"+"3月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 9:
                    oldDate=String.valueOf(now.get(Calendar.YEAR))+"年"+"4月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 10:
                    oldDate=String.valueOf(now.get(Calendar.YEAR))+"年"+"5月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 11:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"6月";
                    baseMapper.deleteByDate(oldDate);
                    break;
                case 12:
                    oldDate=String.valueOf(now.get(Calendar.YEAR)-1)+"年"+"7月";
                    baseMapper.deleteByDate(oldDate);
                    break;
            }


        }
    }
}
