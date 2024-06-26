package com.atguigu.servicedecisioncenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person_personal {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "sex")
    private String sex;

    @TableField(value = "nation_id")
    private String nationId;

    @TableField(value = "birth")
    private String birth;

    @TableField(value = "nativePlace")
    private String nativePlace;

    @TableField(value = "fulltimedegree_id")
    private String fulltimedegreeId;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "idCard")
    private String idCard;

    //改
    @TableField(value = "area_id")
    private String areaId;

    @TableField(value = "religion_id")
    private String religionId;

    @TableField(value = "is_delete")
    private String isDelete;
}
