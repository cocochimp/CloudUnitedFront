package com.atguigu.servicerenwuku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
//全日制学历
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("dangpai_fulltimedegree")
public class Fulltimedegree {
    @TableId(value = "fulltimedegree_id", type = IdType.ID_WORKER_STR)
    private String fulltimedegreeId;
    @TableField(value = "fulltimedegree")
    private String fulltimedegree;
}
