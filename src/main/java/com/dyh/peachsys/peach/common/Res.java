package com.dyh.peachsys.peach.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 返回数据
 * @copyright &copy; DYH
 * @date 2020/5/12-20:11
 * @address 成都
 */
@ApiModel(value = "返回数据")
@Getter
@Setter
public class Res<T> {
    @ApiModelProperty(value = "返回信息")
    private String info;
    @ApiModelProperty(value = "返回状态")
    private Integer status;
    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiOperation(value = "请求成功的方法")
    public static <T> Res<T> success(@ApiParam(value = "返回的数据") T data) {
        Res<T> res = new Res<>();
        res.setData(data);
        res.setInfo("OK");
        res.setStatus(200);
        return res;
    }

    public static Res success() {
        return success(null);
    }

    @ApiOperation(value = "请求失败的方法")
    public static Res fail(@ApiParam(value = "信息") String info,
                           @ApiParam(value = "状态") Integer status) {
        Res res = new Res();
        res.setStatus(status);
        res.setInfo(info);
        return res;
    }

    public static Res fail(String info) {
        return fail(info, 500);
    }

    public static Res fail() {
        return fail("系统错误");
    }

    public static Res notFound(String info) {
        return fail(info, 404);
    }
}
