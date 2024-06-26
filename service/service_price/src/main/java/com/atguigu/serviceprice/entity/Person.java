package com.atguigu.serviceprice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@TableName("dangpai_personal_info")
public class Person {
    @TableId(value = "id")
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "sex",exist = false)
    private String sex;

    @TableField(value = "nation_id",exist = false)
    private String nationId;

    @TableField(value = "birth",exist = false)
    private String birth;

    @TableField(value = "nativePlace",exist = false)
    private String nativePlace;

    @TableField(value = "fulltimedegree_id",exist = false)
    private String fulltimedegreeId;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email",exist = false)
    private String email;

    @TableField(value = "idCard",exist = false)
    private String idCard;

    @TableField(value = "area_id",exist = false)
    private char areaId;

    @TableField(value = "religion_id",exist = false)
    private String religionId;



}
