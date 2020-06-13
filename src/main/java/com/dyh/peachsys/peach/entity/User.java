package com.dyh.peachsys.peach.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/12-21:18
 * @address 成都
 */
@Data
@ApiModel(value = "用户表")
@TableName(value = "user")//表格注解，指定数据库表格
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)//主键注解，指定主键
    private Integer id;
    @ApiModelProperty(value = "姓名")
    @TableField(value = "name")//字段注解，指定字段
    private String name;
    @ApiModelProperty(value = "年龄")
    @TableField(value = "age")
    private Integer age;
    @ApiModelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;
}
