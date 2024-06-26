package com.atguigu.servicedecisioncenter.mapper;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PortraitMapper extends BaseMapper<Person> {

    /*姓名*/
    @Select("select name from dangpai_personal_info where id=#{id}")
    String queryName(String id);

    /*生日*/
    @Select("select birth from dangpai_personal_info where id=#{id}")
    String queryBirth(String id);

    /*性别*/
    @Select("select sex from dangpai_personal_info where id=#{id}")
    String querySex(String id);

    /*民族*/
    @Select("select nation from dangpai_personal_info, dangpai_nation where dangpai_personal_info.nation_id=dangpai_nation.nation_id and dangpai_personal_info.id=#{id}")
    String queryNation(String id);

    /*政治面貌*/
    @Select("SELECT party FROM dangpai_personal_info,dangpai_staff_info,dangpai_party WHERE dangpai_personal_info.id=dangpai_staff_info.s_id AND dangpai_staff_info.party_id=dangpai_party.party_id AND dangpai_personal_info.id=#{id}")
    String queryParty(String id);

    /*岗位职务*/
    @Select("SELECT title FROM dangpai_title,dangpai_personal_info,dangpai_staff_info WHERE dangpai_personal_info.id=dangpai_staff_info.s_id AND dangpai_staff_info.title_id=dangpai_title.title_id AND dangpai_personal_info.id=#{id}")
    String queryTitle(String id);

    /*籍贯*/
    @Select("SELECT nativePlace FROM dangpai_personal_info WHERE id=#{id}")
    String queryNaticePlace(String id);

    /*获奖次数*/
    @Select("SELECT COUNT(*) FROM huojiang_price WHERE id=#{id} AND id_delete=0")
    Integer countPriceNumber(String id);

    /*民主党派*/
    @Select("SELECT dangpai_personal_info.id,dangpai_personal_info.name FROM dangpai_personal_info \n" +
            "WHERE dangpai_personal_info.id IN(\n" +
            "\tSELECT dangpai_staff_info.`s_id` \n" +
            "\tFROM dangpai_staff_info\n" +
            "\tWHERE dangpai_staff_info.party_id IN(\n" +
            "\t\tSELECT dangpai_party.`party_id`\n" +
            "\t\tFROM dangpai_party\n" +
            "\t)\n" +
            ")")
    List<Person> queryDemocraticParties();

    /*非党派*/
    @Select("SELECT dangpai_personal_info.id,dangpai_personal_info.name FROM dangpai_personal_info \n" +
            "WHERE dangpai_personal_info.id IN(\n" +
            "\tSELECT dangpai_staff_info.`s_id` \n" +
            "\tFROM dangpai_staff_info\n" +
            "\tWHERE dangpai_staff_info.party_id  NOT IN(\n" +
            "\t\tSELECT dangpai_party.`party_id`\n" +
            "\t\tFROM dangpai_party\n" +
            "\t)\n" +
            ")")
    List<Person> queryNonPartisan();

    /*根据姓名查询*/
    @Select("SELECT dangpai_personal_info.id,dangpai_personal_info.name FROM dangpai_personal_info WHERE dangpai_personal_info.name=#{name}")
    List<Person> queryByName(String name);

    @Select("SELECT dangpai_personal_info.id,dangpai_personal_info.name " +
            "FROM dangpai_personal_info WHERE dangpai_personal_info.name " +
            "like concat('%',#{name},'%') ")
    List<Person> fuzzyQueryByName(@Param("name") String name);


    //查询人物头像地址
    @Select("SELECT imgUrl FROM `renwuku_photo` where id=#{id}")
    String queryImgUrl(String id);

    //任职轴
    @Select("select positionAxis from renwuku_growthtrack where id=#{id}")
    String queryPositionAxis(String id);

    //活动轴
    @Select("select activeAxis from renwuku_growthtrack where id=#{id}")
    String queryActiveAxis(String id);

    //获奖轴
    @Select("select awardAxis from renwuku_growthtrack where id=#{id}")
    String queryAwardAxis(String id);
}
