package com.dyh.peachsys.spring_boot_jdbc.controller;

import com.dyh.peachsys.peach.common.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/6-21:26
 * @address 成都
 */
@RestController
@RequestMapping("/jdbc")
public class JDBCApi {
    @Autowired
    private JdbcTemplate template;

    @GetMapping("/get/list")
    public Res getTest(){
        String sql = "SELECT * FROM other_info";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return Res.success(maps);
    }
}
