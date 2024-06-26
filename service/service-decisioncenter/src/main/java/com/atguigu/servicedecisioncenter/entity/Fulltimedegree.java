package com.atguigu.servicedecisioncenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//全日制学历
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Fulltimedegree {
    @TableId(value = "fulltimedegree_id", type = IdType.ID_WORKER_STR)
    private String fulltimedegreeId;

    //改
    @TableField(value = "fulltimedegree")
    private String fulltimedegree;
}
