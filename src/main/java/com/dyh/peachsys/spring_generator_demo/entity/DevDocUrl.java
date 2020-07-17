package com.dyh.peachsys.spring_generator_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 开发文档路径
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DevDocUrl对象", description="开发文档路径")
public class DevDocUrl implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "路径介绍")
    private String description;

    @ApiModelProperty(value = "路径连接")
    private String url;

    private Date createdTime;

    private Date updatedTime;

    @Version
    private Integer version;

    @TableLogic
    private Integer status;

    private String remark;


}
