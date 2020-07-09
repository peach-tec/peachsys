package com.dyh.peachsys.spring_shiro_demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 系统用户
 * @copyright &copy; DYH
 * @date 2020/7/9-21:18
 * @address 成都
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String headPath;
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField(value = "updated_time", fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;
    @TableLogic(value = "0", delval = "1")
    private Integer status;
    private String remark;
}
