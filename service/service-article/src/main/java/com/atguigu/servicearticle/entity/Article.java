package com.atguigu.servicearticle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Article对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;       //id


    private String title;    //文章标题

    @TableField("releaseTime")
    private String releaseTime;   //发布时间

    @TableField("content")
    private String content;     //文章内容

    @TableLogic
    private int isDel = 0;      //是否被修改

    @TableField("type")
    private String type;        //文章类型

    @TableField("totalPv")
    private int totalPv;          //浏览量

    @TableField("position")
    private String position;   //位置 首页 民主党派 无党派人士


    @TableField("author")
    private String author;      //文章作者

    @TableField("monPv")
    private int monPv;          //月访问量

    @TableField("imgpath")
    private String imgpath;

}
