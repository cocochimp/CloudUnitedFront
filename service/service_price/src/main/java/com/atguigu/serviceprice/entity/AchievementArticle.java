package com.atguigu.serviceprice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("ziliaoku_achievementofarticle")
public class AchievementArticle {

    @TableId(value = "id")
    @ApiModelProperty(value = "id，不用填写后台生成，修改时需要传回来")
    private String id;

    @ApiModelProperty(value = "作者需要填写，修改时需要传回来")
    @TableField(value = "author")
    private String author;

    @ApiModelProperty(value = "文章标题需要填写，修改时需要传回来")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "文章内容需要填写，修改时需要传回来")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "文章类别是科技成果还是统战成果，下拉框选择，修改时需要传回来")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "发布时间，后台生成,修改时需要传回来")
    @TableField(value = "releaseTime")
    private String releaseTime;

    @ApiModelProperty(value = "修改时间，后台生成")
    @TableField(value = "updateTime")
    private String updateTime;
}