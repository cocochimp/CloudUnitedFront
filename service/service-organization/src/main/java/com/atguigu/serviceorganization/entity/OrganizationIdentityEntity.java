package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2022-12-14 17:27:02
 */
@Data
@TableName("organization_identity")
public class OrganizationIdentityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 个人id
	 */
	@TableId
	private String oId;
	/**
	 * 组织身份
	 */
	private String oIdentity;

}
