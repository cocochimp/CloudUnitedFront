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

//组织身份管理员和普通成员
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("organization_identity")
public class OrganizationIdentity {
    @ApiModelProperty(value = "组织身份管理员和普通成员id")
    @TableId(value = "o_id", type = IdType.ID_WORKER_STR)
    private String OId;

    @ApiModelProperty(value = "组织身份管理员和普通成员")
    @TableField(value = "o_identity")
    private String oIdentity;
}
