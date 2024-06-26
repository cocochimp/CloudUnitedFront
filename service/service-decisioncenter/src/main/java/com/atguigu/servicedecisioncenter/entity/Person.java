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
public class Person {
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

    @TableField(value = "s_id")
    private String sId;

    @TableField(value = "department_id")
    private String departmentId;

    @TableField(value = "currentPosition_id")
    private String currentPositionId;

    @TableField(value = "title_id")
    private String titleId;

    @TableField(value = "startWorkingDate")
    private String startWorkingDate;

    @TableField(value = "party_id")
    private String partyId;

    @TableField(value = "joinPartyDate")
    private String joinPartyDate;

}
