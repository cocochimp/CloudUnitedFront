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
@TableName("dangpai_political")
@EqualsAndHashCode
public class PoliticalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 政治职务id
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	private String politicalpositionId;
	/**
	 * 政治职务
	 */
	private String politicalposition;
	/**
	 * 政治职务类别人大代表或者政协委员
	 */
	private String category;
	/**
	 * 全称职位比如全国人大
	 */
	private String position;

}
