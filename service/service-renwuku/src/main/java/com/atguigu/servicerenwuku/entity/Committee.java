package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//委员表
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("renwuku_committee")
public class Committee {
    @TableId(value = "committee_id", type = IdType.ID_WORKER_STR)
    private String committeeId;


    @TableField(value = "committee")
    private String committee;
}
