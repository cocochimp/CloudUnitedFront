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
@TableName("dangpai_political")
public class Political {
    @ApiModelProperty(value = "政治安排id")
    @TableId(value = "politicalPosition_id", type = IdType.INPUT)
    private String politicalPositionId;
    @ApiModelProperty(value = "不同级别国家省市县")
    @TableField(value = "politicalPosition")
    private String politicalPosition;
    @ApiModelProperty(value = "分类人大和政协委员")
    @TableField(value = "category")
    private String category;
    @ApiModelProperty(value = "全称")
    @TableField(value = "position")
    private String position;
}
