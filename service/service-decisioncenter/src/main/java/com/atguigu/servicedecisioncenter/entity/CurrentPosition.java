package com.atguigu.servicedecisioncenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//现任职位表
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_currentPosition")
public class CurrentPosition {

    @ApiModelProperty(value = "现任职务id")
    @TableId(value = "currentPosition_id", type = IdType.ID_WORKER_STR)
    private String currentPositionId;

    @ApiModelProperty(value = "现任职位")
    @TableField(value = "currentPosition")
    private String currentPosition;
}
