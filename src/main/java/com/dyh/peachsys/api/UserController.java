package com.dyh.peachsys.api;

import com.dyh.peachsys.common.BaseController;
import com.dyh.peachsys.common.Res;
import com.dyh.peachsys.entity.User;
import com.dyh.peachsys.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/12-21:44
 * @address 成都
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/get")
    public Res getUser() {
        List<User> list = userService.list();//服务层内置方法
        return success(list);
    }
}
