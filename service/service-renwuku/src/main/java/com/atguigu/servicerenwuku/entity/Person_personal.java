package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Person_personal {
    //人物库id
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    //人物姓名
    @ApiModelProperty(value = "姓名")
    @TableField(value = "name")
    private String name;

    //性别
    @ApiModelProperty(value = "性别")
    @TableField(value = "sex")
    private String sex;

    //民族id
    @ApiModelProperty(value = "民族id")
    @TableField(value = "nation_id")
    private String nationId;

    //出生年月
    @ApiModelProperty(value = "出生年月")
    @TableField(value = "birth")
    private String birth;

    //政治面貌
    @ApiModelProperty(value = "政治面貌")
    @TableField(value = "politics_id")
    private String politicsId;

    //出生地
    @ApiModelProperty(value = "籍贯")
    @TableField(value = "nativePlace")
    private String nativePlace;

    //全日制学位
    @ApiModelProperty(value = "学位")
    @TableField(value = "bachelor_id")
    private String bachelorId;

    //全日制学历
    @ApiModelProperty(value = "学历")
    @TableField(value = "fulltimedegree_id")
    private String fulltimedegreeId;



    //电话
    @ApiModelProperty(value = "电话")
    @TableField(value = "phone")
    private String phone;



    //区域id
    @ApiModelProperty(value = "区域id大陆,台湾区域，澳门区域，香港区域，台属")
    @TableField(value = "area_id")
    private String areaId;


    //校区
    @ApiModelProperty(value = "校区：主校区海滨校区阳江校区霞山校区")
    @TableField(value = "campus_id")
    private String campusId;

    //人物库照片id
    @ApiModelProperty(value = "人物库照片id")
    @TableField(value = "photo_id")
    private String photoId;

}
