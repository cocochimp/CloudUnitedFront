package com.atguigu.servicedecisioncenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AgeResult {
    private Integer result60_;
    private Integer result51_60;
    private Integer result41_50;
    private Integer result31_40;
    private Integer result_30;
}
