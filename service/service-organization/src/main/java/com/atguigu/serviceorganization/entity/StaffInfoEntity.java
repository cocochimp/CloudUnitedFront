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
@TableName("dangpai_staff_info")
@EqualsAndHashCode
public class StaffInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教职人员id
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	private String sId;
	/**
	 * 学院id
	 */
	private String departmentId;
	/**
	 * 教职工类别id
	 */
	private String currentpositionId;
	/**
	 * 职称id
	 */
	private String titleId;
	/**
	 * 职务
	 */
	private String job;
	/**
	 * 党外干部级别id
	 */
	private String joblevelId;
	/**
	 * 党派类型id
	 */
	private String partyId;
	/**
	 * 其余统战对象无党派人士，知联会
	 */
	private String partyOthersId;
	/**
	 * 参加时间
	 */
	private String joinpartydate;
	/**
	 * 政治职务id
	 */
	private String politicalpositionId;
	/**
	 * 组织身份
	 */
	private String organizationId;

}
