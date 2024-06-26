package com.atguigu.servicearticle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//存放每个月的最大，最小，平均访问量
public class ArticlePv {
    private String id;
    private String date;
    private int maxpv;
    private int minpv;
    private double avgpv;
    private String position;
}
