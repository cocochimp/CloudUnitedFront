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

//民族
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_nation")
public class Nation {
    @ApiModelProperty(value = "民族id")
    @TableId(value = "nation_id", type = IdType.INPUT)
    private String nationId;
    @ApiModelProperty(value = "民族")
    @TableField(value = "nation")
    private String nation;
}
