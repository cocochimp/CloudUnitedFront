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

//身份教师或者学生
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("renwuku_identity")
public class Identity {
    @ApiModelProperty(value = "身份id")
    @TableId(value = "identity_id", type = IdType.INPUT)
    private String identityId;
    @ApiModelProperty(value = "身份教师或者学生")
    @TableField(value = "identity")
    private String identity;
}
