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
@TableName("dangpai_personal_info")
@EqualsAndHashCode
public class PersonalInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教职人员id
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	private String id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 民族id
	 */
	private String nationId;
	/**
	 * 出生年月
	 */
	private String birth;
	/**
	 * 政治面貌
	 */
	private String politicsId;
	/**
	 * 籍贯
	 */
	private String nativeplace;
	/**
	 * 学士id分为三类学士学位硕士学位博士学位
	 */
	private String bachelorId;
	/**
	 * 全日制学历id
	 */
	private String fulltimedegreeId;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 区域
	 */
	private String areaId;
	/**
	 * 校区：主校区海滨校区阳江校区霞山校区
	 */
	private String campusId;

	private String photoId;

}
