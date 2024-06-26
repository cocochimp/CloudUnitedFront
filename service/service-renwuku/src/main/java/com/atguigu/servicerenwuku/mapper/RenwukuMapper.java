package com.atguigu.servicerenwuku.mapper;


import com.atguigu.servicerenwuku.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RenwukuMapper {
    //查询所有人物库成员
    List<PersonVo> queryallpeople();

    //添加人物库dangpai_personal_info信息
    @Insert("insert into dangpai_personal_info" +
            "(id,name,sex,nation_id,birth,politics_id,nativePlace,bachelor_id,fulltimedegree_id,phone,area_id,campus_id,photo_id)" +
            " values(#{id},#{name},#{sex},#{nationId},#{birth},#{politicsId},#{nativePlace},#{bachelorId},#{fulltimedegreeId},#{phone}," +
            "#{areaId},#{campusId},#{photoId})")
    void addPeopletoPersonal(Person_personal person_personal);

    //添加人物库dangpai_staff_info信息
    @Insert("insert into dangpai_staff_info" +
            "(s_id,department_id,currentPosition_id,title_id,job,joblevel_id,party_id,party_others_id," +
            "joinPartyDate,politicalPosition_id,organization_id,growthTrack_id) values(#{sId}," +
            "#{departmentId},#{currentPositionId},#{titleId},#{job},#{jobLevelId},#{partyId},#{otherPartyId}," +
            "#{joinPartyDate},#{politicalPositionId},#{organizationId},#{growthTrackId})")
    void addPeopletoStaff(Person_staff person_staff);


    //删除人物库信息
    @Delete("delete s,p from dangpai_staff_info s,dangpai_personal_info p where s.s_id=p.id and p.id=#{id}")
    void deletePeople(String id);

    //修改人物库dangpai_personal_info信息
    @Update("update dangpai_personal_info set name=#{name},sex=#{sex},nation_id=#{nationId},birth=#{birth}," +
            "politics_id=#{politicsId},nativePlace=#{nativePlace},bachelor_id=#{bachelorId},fulltimedegree_id=#{fulltimedegreeId},phone=#{phone}," +
            "area_id=#{areaId}," +
            "campus_id=#{campusId},photo_id=#{photoId} where id=#{id}")
    void updatePeopletoPersonal(Person_personal person_personal);

    //修改人物库dangpai_staff_info信息
    @Update("update dangpai_staff_info set department_id=#{departmentId},currentPosition_id=#{currentPositionId}," +
            "title_id=#{titleId},job=#{job},joblevel_id=#{jobLevelId},party_id=#{partyId}," +
            "party_others_id=#{otherPartyId},joinPartyDate=#{joinPartyDate},politicalPosition_id=#{politicalPositionId}," +
            "joblevel_id=#{jobLevelId},organization_id=#{organizationId},growthTrack_id=#{growthTrackId} where s_id=#{sId}")
    void updatePeopletoStaff(Person_staff person_staff);

    //模糊多条件查询人物库信息
    List<PersonVo> queryPeopleByCondition(String name, String partyId, String departmentId,String otherPartyId);



}
