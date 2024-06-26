package com.atguigu.serviceprice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class priceAndFile {
    /**
     * 获奖id
     */
    private String pid;

    /**
     * 获奖人名字
     */
    private String name;

    /**
     * 奖励名称
     */
    private String pPriceName;

    /**
     * 奖励等级
     */
    private String pLevel;

    /**
     * 获奖文件
     */
    private List<PriceFile> priceFile;

}
