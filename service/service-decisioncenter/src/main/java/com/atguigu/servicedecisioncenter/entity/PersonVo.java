package com.atguigu.servicedecisioncenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class PersonVo {
    private String id;

    private String name;

    private String sex;

    private String nation;

    private String birth;

    private String nativePlace;

    private String fulltimedegree;

    private String phone;

    private String email;

    private String idCard;

    private String department;

    private String currentPosition;

    private String title;

    private String startWorkingDate;

    private String party;

    private String joinPartyDate;

}
