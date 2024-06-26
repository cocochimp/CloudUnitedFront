package com.atguigu.servicearticle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//统计每个月的文章访问量统计：最大访问量，最少访问量，平均访问量
public class ArticleMonPv {
    private int maxPv;
    private int minPv;
    private int avgPv;
    private String position;
}
