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

//校区：主校区海滨校区阳江校区霞山校区
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("renwuku_campus")
public class Campus {
    @ApiModelProperty(value = "校区id")
    @TableId(value = "campus_id", type = IdType.INPUT)
    private String campusId;
    @ApiModelProperty(value = "校区：主校区海滨校区阳江校区霞山校区")
    @TableField(value = "campus")
    private String campus;
}
