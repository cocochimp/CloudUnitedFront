package com.atguigu.serviceorganization.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVo {
    private String id;
    private String party;
    private String phone;
    private String name;
    private String nativePlace;
    private String o_identity;
    private String joinPartyDate;
}
