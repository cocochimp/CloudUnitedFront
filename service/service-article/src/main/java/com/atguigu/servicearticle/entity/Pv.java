package com.atguigu.servicearticle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//访问量
public class Pv {
       private String position;             //文章的位置，首页，民主党派，参政议政
       private List<ArticleCount> maxList;    //最大访问量
       private List<ArticleCount> minList;    //最少访问量
       private List<ArticleCount> avgList;      //平均访问量
       private List<String>  dateList;       /*往期年月只展示五个，如现在是2022年5月，
                                             展示2022年4月 2022年3月 2022年2月
                                             2022年1月 2021年12月
                                              */
}
