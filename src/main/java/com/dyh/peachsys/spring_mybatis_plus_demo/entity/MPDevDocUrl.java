package com.dyh.peachsys.spring_mybatis_plus_demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/16-21:25
 * @address 成都
 */
@Data
@TableName("dev_doc_url")
public class MPDevDocUrl {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String description;
    private String url;
    @TableField(fill = FieldFill.INSERT)//插入时填充
    private Date createdTime;
    @TableField(fill = FieldFill.UPDATE)//更新时填充
    private Date updatedTime;
    @TableLogic(value = "0",delval = "1")
    private Integer status;
    private String remark;
    @Version
    private Integer version;
}
