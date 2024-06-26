package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//政治安排
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("renwuku_photo")
//人物库人物头像
public class Photo {
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    @TableField(value = "imgUrl")
    private String imgUrl;
    @TableField(value = "imgName")
    private String imgName;

}