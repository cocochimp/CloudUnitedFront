package com.atguigu.serviceprice.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("huojiang_file")
public class PriceFile {
    @TableId(type= IdType.ASSIGN_ID)
    private String fid;

    @TableField(value = "f_name")
    private String fName;

    @TableField(value = "f_path")
    private String fPath;

    private String pid;

    @TableField(value = "is_delete")
    @TableLogic(value = "0",delval = "1")
    private int isDelete;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "modified_time")
    private Date modifiedTime;
}
