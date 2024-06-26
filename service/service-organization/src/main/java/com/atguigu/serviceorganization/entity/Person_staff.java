package com.atguigu.serviceorganization.entity;

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
public class Person_staff {
    @TableId(value = "s_id")
    private String sId;

    @TableField(value = "party_id")
    private String partyId;

    @TableField(value = "department_id")
    private String departmentId;

    @TableField(value = "joinPartyDate")
    private String joinPartyDate;

    @TableField(value = "organization_id")
    private String organizationId;

}
