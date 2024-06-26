package com.atguigu.servicepublicity.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("publicity")
public class Publicity {

    //宣传id
    @TableId(type= IdType.ASSIGN_ID)
    private String xid;

    //标题
    private String title;

    //内容
    private String content;

    //作者
    private String author;

    //类型
    private String type;

    //发布时间
    @TableField(value = "create_time")
    private Date createTime;

    //修改时间
    @TableField(value = "modified_time")
    private Date modifiedTime;

    //逻辑删除
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_delete")
    private int isDelete;
}
