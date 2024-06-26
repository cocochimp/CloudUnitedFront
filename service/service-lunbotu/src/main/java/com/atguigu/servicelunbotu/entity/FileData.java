package com.atguigu.servicelunbotu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//轮播图信息类
public class FileData {
    //图片在数据库的uuid
    private String id;
    private String name;
    private String info;
    private String imgUrl;
    private String imgName;
}
