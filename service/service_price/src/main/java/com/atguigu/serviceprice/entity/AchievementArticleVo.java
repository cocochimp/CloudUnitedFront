package com.atguigu.serviceprice.entity;

import lombok.Data;

@Data
public class AchievementArticleVo {
    private String id;
    private String author;
    private String title;
    private String content;
    private String typeId;
    private String type;
    private String releaseTime;
    private String updateTime;
}