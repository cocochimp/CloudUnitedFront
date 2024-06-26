package com.atguigu.serviceprice.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("huojiang_price")
public class Price {
    //获奖pid
    @TableId(type= IdType.ASSIGN_ID)
    private String pid;

    //获奖人姓名
    private String name;

    // 获奖人id
    private String id;

    // 获奖级别
    @TableField(value = "p_level")
    private String pLevel;

    //获奖名称
    @TableField(value = "p_priceName")
    private String pPriceName;

    //文件路径
    @TableField(value = "p_fid")
    private String pFid;

    //上传时间
    @TableField(value = "p_uploadTime")
    private Date pUploadTime;

    //修改时间
    @TableField(value = "p_modifiedTime")
    private Date pModifiedTime;

    //逻辑删除（1-删除）
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "id_delete")
    private Integer idDelete;



}
