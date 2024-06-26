package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//成长轨迹
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("renwuku_growthtrack")
public class GrowthTrack {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    @TableField(value = "positionAxis")
    private String positionAxis;
    @TableField(value = "activeAxis")
    private String activeAxis;
    @TableField(value = "awardAxis")
    private String awardAxis;
}