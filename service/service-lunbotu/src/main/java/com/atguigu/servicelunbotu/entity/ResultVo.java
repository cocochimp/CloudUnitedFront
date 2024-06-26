package com.atguigu.servicelunbotu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {
    private String mess;
    private boolean isOk;
    private T t;
}
