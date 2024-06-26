package com.atguigu.serviceprice.mapper;

import com.atguigu.serviceprice.entity.AchievementOfPhoto;
import com.atguigu.serviceprice.entity.AchievementOfPhotoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AchievementOfPhotoMapper {
    @Insert("INSERT INTO ziliaoku_achievementofphoto ( id, imgUrl, imgName, title, type, createTime, updateTime ) " +
            "VALUES(#{id},#{imgUrl},#{imgName},#{title},#{type},#{createTime},#{updateTime})")
    void insert(AchievementOfPhoto achievementOfPhoto);

    @Delete("delete from  ziliaoku_achievementofphoto where id=#{id}")
    void deleteById(String id);

    @Update("UPDATE ziliaoku_achievementofphoto SET " +
            "imgUrl = #{imgUrl}, imgName=#{imgName}, title=#{title}, type=#{type}, createTime=#{createTime}, updateTime=#{updateTime} WHERE id = #{id}")
    void updateById(AchievementOfPhoto achievementOfPhoto);

    @Select("select a.id,a.imgUrl,a.imgName,a.title,a.type typeId,t.type,a.createTime,a.updateTime " +
            "from ziliaoku_achievementofphoto a left join ziliaoku_phototype t on a.type=t.id limit #{start},#{size}")
    List<AchievementOfPhotoVo> selectList(int start, int size);

    @Select("select * from ziliaoku_phototype group by type")
    List<Map<String, String>> queryPhotoType();

    @Select("select count(id) total from  ziliaoku_achievementofphoto")
    Integer queryTotalOfPhoto();

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.imgUrl,\n" +
            "\ta.imgName,\n" +
            "\ta.title,\n" +
            "\ta.type typeId,\n" +
            "\tt.type,\n" +
            "\ta.createTime,\n" +
            "\ta.updateTime \n" +
            "FROM\n" +
            "\tziliaoku_achievementofphoto a\n" +
            "\tLEFT JOIN  ziliaoku_phototype  t ON a.type = t.id  WHERE t.id = #{typeId}\n" +
            "\tLIMIT #{start},#{size}")
    List<AchievementOfPhotoVo> queryPhotoByType(String typeId, int start, int size);

    @Select("select count(id) count from ziliaoku_achievementofphoto where type=#{typeId}")
    Integer queryPhotoTotalByType(String typeId);
}
