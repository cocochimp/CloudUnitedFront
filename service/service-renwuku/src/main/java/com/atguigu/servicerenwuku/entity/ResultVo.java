package com.atguigu.servicerenwuku.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResultVo<T> {
    @ApiModelProperty(value = "返回信息")
    private String mess;
    @ApiModelProperty(value = "返回状态true或者false")
    private boolean isOk;
    @ApiModelProperty(value = "返回的实体类")
    private T t;
}
