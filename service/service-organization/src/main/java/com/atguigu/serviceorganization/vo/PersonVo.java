package com.atguigu.serviceorganization.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVo {
    private String id;
    private String department;
    private String party;
    private String phone;
    private String name;
    private String nativePlace;
    private String o_identity;
    private String joinPartyDate;
}