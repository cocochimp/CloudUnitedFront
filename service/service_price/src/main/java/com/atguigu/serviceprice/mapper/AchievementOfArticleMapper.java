package com.atguigu.serviceprice.mapper;

import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.entity.AchievementArticleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AchievementOfArticleMapper {
    @Insert("INSERT INTO ziliaoku_achievementofarticle " +
            "( id, author,title, content, type, releaseTime, updateTime ) VALUES(#{id},#{author},#{title},#{content},#{type},#{releaseTime},#{updateTime})")
    void insert(AchievementArticle article);

    @Delete("delete from  ziliaoku_achievementofarticle where id=#{id}")
    void deleteById(String id);

    @Update("UPDATE ziliaoku_achievementofarticle SET " +
            "author=#{author},title = #{title},content=#{content}, type=#{type}, releaseTime=#{releaseTime}, " +
            "updateTime=#{updateTime} WHERE id = #{id}")
    void updateById(AchievementArticle article);

    @Select("select * from ziliaoku_achievementofarticle where id=#{id}")
    AchievementArticle selectById(String id);

    @Select("select z.id,z.author,z.title,z.type typeId,t.type,z.releaseTime,z.updateTime   " +
            " from ziliaoku_achievementofarticle z left join ziliaoku_articletype t on z.type=t.id limit #{page},#{size}")
    List<AchievementArticleVo> selectList(int page, int size);

    @Select("select * from ziliaoku_articletype group by type")
    List<Map<String, String>> queryArticleType();

    @Select("select count(id) total from ziliaoku_achievementofarticle")
    Integer selectTotalArticles();

    @Select("select z.id,z.author,z.title,z.type typeId,a.type,z.releaseTime,z.updateTime  " +
            "from ziliaoku_achievementofarticle z left join   ziliaoku_articletype a on z.type=a.id where a.id=#{typeId} limit #{page},#{size}")
    List<AchievementArticleVo> queryArticleByType(String typeId, int page, int size);

    @Select("select count(id) from ziliaoku_achievementofarticle where type=#{typeId}")
    Integer selectTotalArticlesByType(String typeId);
}
