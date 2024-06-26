package com.atguigu.servicearticle.mapper;

import com.atguigu.servicearticle.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>

 * @author zhu
 * @since 2022-04-17
 */
public interface ArticleMapper extends BaseMapper<Article> {



    @Insert("insert into articlepv(id,date,maxpv,minpv,avgpv,position) values(#{id},#{date},#{maxpv},#{minpv},#{avgpv},#{position})")
    void addMonPv(ArticlePv articlePv);

    @Update("update article set monPv=0")
    void updateMonPv();

    @Select("select max(monPv) maxPv,min(monPv) minPv,avg(monPv) avgPv from article where position='首页' ")
    ArticleMonPv uploadIndexMonPv();

    @Select("select max(monPv) maxPv,min(monPv) minPv,avg(monPv) avgPv from article where position='民主党派' ")
    ArticleMonPv uploadMinZhuDangPaiMonPv();
    @Select("select max(monPv) maxPv,min(monPv) minPv,avg(monPv) avgPv from article where position='参政议政' ")
    ArticleMonPv uploadCanZhengMonPv();



    @Delete("delete from articlepv where date=#{oldDate}")
    void deleteByDate(String oldDate);

    @Select("select date from articlepv where position=#{position}")
    List<String> datePv(String position);

    @Select("select date from articlepv  group by date order by date")
    List<String> queryDateList();


    @Select("select max(monPv) maxPv,min(monPv) minPv,avg(monPv) avgPv,position from article where position=#{position}")
    ArticleMonPv articleCount(String position);

    @Select("select maxpv count from articlepv  where position=#{position} order by date")
    List<ArticleCount> maxPv(String position);
    @Select("select minpv count from articlepv  where position=#{position} order by date")
    List<ArticleCount> minPv(String position);
    @Select("select avgpv count from articlepv where position=#{position} order by date")
    List<ArticleCount> avgPv(String position);


}
