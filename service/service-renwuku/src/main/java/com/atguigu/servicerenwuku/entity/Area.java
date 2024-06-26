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

//区域
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_area")
public class Area {
    @ApiModelProperty(value = "区域id")
    @TableId(value = "area_id", type = IdType.INPUT)
    private String areaId;
    @ApiModelProperty(value = "区域")
    @TableField(value = "area")
    private String area;
}
