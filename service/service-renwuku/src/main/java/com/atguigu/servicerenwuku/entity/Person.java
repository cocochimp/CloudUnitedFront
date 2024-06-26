package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Person {
    @ApiModelProperty(value = "photo照片")
    private MultipartFile photo;

    //人物库id
    @ApiModelProperty(value = "id")
    private String id;

    //人物姓名
    @ApiModelProperty(value = "姓名")
    private String name;

    //性别
    @ApiModelProperty(value = "性别")
    private String sex;

    //民族id
    @ApiModelProperty(value = "民族id")
    private String nationId;

    //出生年月
    @ApiModelProperty(value = "出生年月")
    private String birth;

    //政治面貌
    @ApiModelProperty(value = "政治面貌id 下拉框选择")
    private String politicsId;

    //出生地
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    //全日制学位
    @ApiModelProperty(value = "学位id 下拉框选择")
    private String bachelorId;

    //全日制学历
    @ApiModelProperty(value = "学历id 下拉框选择")
    private String fulltimedegreeId;


    //电话
    @ApiModelProperty(value = "电话")
    private String phone;


    //区域id
    @ApiModelProperty(value = "区域id大陆,台湾区域，澳门区域，香港区域，台属")
    private String areaId;


    //校区
    @ApiModelProperty(value = "校区：主校区海滨校区阳江校区霞山校区id 下拉框选择")
    private String campusId;

    //人物库照片id
    @ApiModelProperty(value = "人物库照片id")
    private String photoId;

    //部门id
    @ApiModelProperty(value = "学院部门id 下拉框选择")
    private String departmentId;

    //现任职务id
    @ApiModelProperty(value = "教职工类别id 下拉框选择")
    private String currentPositionId;

    //职称id
    @ApiModelProperty(value = "职称id 下拉框选择")
    private String titleId;

    //职务
    @ApiModelProperty(value = "职务")
    private String job;

    //职位级别id
    @ApiModelProperty(value = "职位级别id 下拉框选择")
    private String jobLevelId;

    //民主党派id
    @ApiModelProperty(value = "民主党派id 下拉框选择")
    private String partyId;

    //其他类别的id如无党派，党外知识分子，知联会
    @ApiModelProperty(value = "其他类别的id如无党派人士，，知联会id 下拉框选择")
    private String otherPartyId;

    //加入党派时间
    @ApiModelProperty(value = "加入时间")
    private String joinPartyDate;

    //政治安排id
    @ApiModelProperty(value = "政治安排id")
    private String politicalPositionId;

    //组织身份
    @ApiModelProperty(value = "组织身份 管理员还是普通成员")
    private String organizationId;

    //成长轨迹id
    @ApiModelProperty(value = "成长轨迹id")
    private String growthTrackId;

    //任职轴
    @ApiModelProperty(value = "任职轴")
    private String positionAxis;

    //活动轴
    @ApiModelProperty(value = "活动轴")
    private String activeAxis;

    //获奖轴
    @ApiModelProperty(value = "获奖轴")
    private String awardAxis;


}
