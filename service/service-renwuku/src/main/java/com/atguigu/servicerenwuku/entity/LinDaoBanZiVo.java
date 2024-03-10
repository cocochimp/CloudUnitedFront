package com.atguigu.servicerenwuku.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//领导班子vo
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LinDaoBanZiVo {
    String name;
    String party;
    String committee;
}
