package status.web;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dangpai_personal_info")
public class Persion {
    private String id;

    private String name;

    @TableField(select = false)
    private String sex;

    @TableField(value = "nation_id")
    private String nationId;

    @TableField(select = false)
    private String birth;

    @TableField(select = false)
    private String nativePlace;

    @TableField(value = "fulltimedegree_id")
    private String fulltimedegreeId;

    @TableField(select = false)
    private String phone;

    @TableField(select = false)
    private String email;

    private String idCard;

}
