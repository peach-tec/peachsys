package com.dyh.peachsys.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peach-華
 * @version V1.0
 * @desc swagger测试api
 * @copyright &copy; DYH
 * @date 2020/5/7-21:53
 * @address 成都
 */
@Api(tags = "swagger测试api")
@RestController
public class SwaggerTestApi {
    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public String swaggerTest() {
        return "swagger 测试接口";
    }
}
