package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 04:00:34
 */
@Data
@TableName("dangpai_nation")
@EqualsAndHashCode
public class NationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 民族id
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	private String nationId;
	/**
	 * 民族
	 */
	private String nation;

}
