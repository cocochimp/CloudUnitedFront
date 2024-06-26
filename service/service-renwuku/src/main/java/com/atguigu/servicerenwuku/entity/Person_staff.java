package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person_staff {
    @TableId(value = "s_id")
    private String sId;

    //部门id
    @ApiModelProperty(value = "学院部门id")
    @TableField(value = "department_id")
    private String departmentId;

    //现任职务id
    @ApiModelProperty(value = "教职工类别id")
    @TableField(value = "currentPosition_id")
    private String currentPositionId;

    //职称id
    @ApiModelProperty(value = "职称id")
    @TableField(value = "title_id")
    private String titleId;

    //职务
    @ApiModelProperty(value = "职务")
    @TableField(value = "job")
    private String job;

    //职位级别id
    @ApiModelProperty(value = "职位级别id")
    @TableField(value = "joblevel_id")
    private String jobLevelId;

    //民主党派id
    @ApiModelProperty(value = "民主党派id")
    @TableField(value = "party_id")
    private String partyId;

    //其他类别的id如无党派，党外知识分子，知联会
    @ApiModelProperty(value = "其他类别的id如无党派人士，，知联会")
    @TableField(value = "party_others_id")
    private String otherPartyId;

    //加入党派时间
    @ApiModelProperty(value = "加入时间")
    @TableField(value = "joinPartyDate")
    private String joinPartyDate;

    //政治安排id
    @ApiModelProperty(value = "政治安排id")
    @TableField(value = "politicalPosition_id")
    private String politicalPositionId;

    //组织身份
    @ApiModelProperty(value = "组织身份 管理员还是普通成员")
    @TableField(value = "organization_id")
    private String organizationId;

    //成长轨迹id
    @ApiModelProperty(value = "成长轨迹id")
    @TableField(value = "growthTrack_id")
    private String growthTrackId;

}
