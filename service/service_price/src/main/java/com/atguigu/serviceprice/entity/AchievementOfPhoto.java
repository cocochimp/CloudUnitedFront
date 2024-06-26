package com.atguigu.serviceprice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("ziliaoku_achievementofphoto")
public class AchievementOfPhoto {
    @ApiModelProperty(value = "id，不用填写后台生成，修改时需要传回来")
    @TableId(value = "id")
    private String id;

    @ApiModelProperty(value = "图片地址，不用填写后台生成，修改时需要传回来")
    @TableField(value = "imgUrl")
    private String imgUrl;

    @ApiModelProperty(value = "图片带格式的名称如a.jpg，不用填写后台生成，修改时需要传回来")
    @TableField(value = "imgName")
    private String imgName;

    @ApiModelProperty(value = "图片标题，修改时需要传回来")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "类别是科技成果还是统战成果，下拉框选择，修改时需要传回来")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "发布时间，后台生成,修改时需要传回来")
    @TableField(value = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间，后台生成")
    @TableField(value = "updateTime")
    private String updateTime;
}