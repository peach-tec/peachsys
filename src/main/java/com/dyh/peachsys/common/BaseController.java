package com.dyh.peachsys.common;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 控制层共有方法
 * @copyright &copy; DYH
 * @date 2020/5/12-20:30
 * @address 成都
 */
public class BaseController {
    protected Res success() {
        return Res.success();
    }

    protected <T> Res<T> success(T data) {
        return Res.success(data);
    }

    protected Res fail(String info) {
        return Res.fail(info);
    }

    protected Res fail(String info, Integer status) {
        return Res.fail(info, status);
    }

}
