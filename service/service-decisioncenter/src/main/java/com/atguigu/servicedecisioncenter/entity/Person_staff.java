package com.atguigu.servicedecisioncenter.entity;

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

    //改
    @TableField(value = "politicalPosition_id")
    private String politicalPositionId;

    @TableField(value = "joblevel_id")
    private String joblevelId;

    @TableField(value = "is_delete")
    private String isDelete;

}
