package com.dyh.peachsys.mybatisdemo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/13-16:28
 * @address 成都
 */
@Data
@Alias("MybatisTeacher")
public class MybatisTeacher {
    private Integer id;
    private String name;
}
