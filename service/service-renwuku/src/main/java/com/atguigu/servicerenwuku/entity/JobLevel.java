package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//现任职位表
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_joblevel")
public class JobLevel {
    @ApiModelProperty(value = "职位级别id")
    @TableId(value = "jobLevel_id", type = IdType.INPUT)
    private String jobLevelId;
    @ApiModelProperty(value = "职位级别")
    @TableField(value = "joblevel")
    private String jobLevel;
}
