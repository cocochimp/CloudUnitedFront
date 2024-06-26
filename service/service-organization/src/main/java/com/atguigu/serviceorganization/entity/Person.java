package com.atguigu.serviceorganization.entity;

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

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "nativePlace")
    private String nativePlace;

    @TableField(value = "party_id")
    private String partyId;

    @TableField(value = "department_id")
    private String departmentId;

    @TableField(value = "joinPartyDate")
    private String joinPartyDate;

    @TableField(value = "organization_id")
    private String organizationId;

}
