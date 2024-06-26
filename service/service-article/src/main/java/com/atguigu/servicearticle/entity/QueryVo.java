package com.atguigu.servicearticle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryVo<T> {
    private String mess;
    private boolean isOk;
    private T t;
    private Long count;
}
