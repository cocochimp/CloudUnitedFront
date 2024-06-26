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

//其余如无党派，党外知识分子，知联会
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_party_others")
public class PartyOthers {

    @ApiModelProperty(value = "id")
    @TableId(value = "p_id", type = IdType.INPUT)
    private String pId;

    @ApiModelProperty(value = "其余如无党派，党外知识分子，知联会")
    @TableField(value = "other_party")
    private String otherParty;
}
