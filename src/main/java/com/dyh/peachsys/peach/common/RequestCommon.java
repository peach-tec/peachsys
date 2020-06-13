package com.dyh.peachsys.peach.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 常用数据实体类
 * @copyright &copy; DYH
 * @date 2020/5/11-20:38
 * @address 成都
 */
@ApiModel(value = "常用数据实体类")
public class RequestCommon {
    @ApiModelProperty(value = "请求地址")
    public static String url = "http://localhost:8088/product/new";
}
