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

//信教
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_religion")
public class Religion {
    @ApiModelProperty(value = "信教类别id")
    @TableId(value = "religion_id", type = IdType.INPUT)
    private String religionId;
    @ApiModelProperty(value = "信教类别")
    @TableField(value = "religion")
    private String religion;
}
