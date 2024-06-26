package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class PersonVo {

    private String id;

    private String name;

    private String sex;

    private String nation;

    private String nationId;

    private String birth;

    private String politics;

    private String politicsId;

    private String nativePlace;

    private String bachelor;

    private String bachelorId;

    private String fulltimedegree;

    private String fulltimedegreeId;

    private String phone;

    private String area;

    private String areaId;

    private String campus;

    private String campusId;

    private String photoId;

    private String imgUrl;

    private String department;

    private String departmentId;


    private String currentPosition;

    private String currentPositionId;

    private String title;

    private String titleId;

    private String  job;

    private String party;

    private String partyId;

    private String otherParty;

    private String pId;

    private String joinPartyDate;

    private String position;

    private String politicalPositionId;

    private String jobLevel;

    private String jobLevelId;

    private String identity;

    private String organizationId;

    private String growthTrackId;

    private String positionAxis;

    private String activeAxis;

    private String awardAxis;
}
