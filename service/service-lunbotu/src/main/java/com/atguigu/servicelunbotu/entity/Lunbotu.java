package com.atguigu.servicelunbotu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Lunbotu对象", description="")
public class Lunbotu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "上传时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "图片地址")
    @TableField("imgUrl")
    private String imgUrl;

    @ApiModelProperty(value = "图片名称")
    private String name;

    @ApiModelProperty(value = "图片名字不带格式")
    private String info;

    @ApiModelProperty(value = "图片名字带格式")
    @TableField("imgName")
    private String imgName;


}
