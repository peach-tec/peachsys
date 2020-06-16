package com.dyh.peachsys.mybatisdemo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/13-16:29
 * @address 成都
 */
@Data
@Alias("MybatisStudent")
public class MybatisStudent {
    private Integer id;
    private String name;
    //一个学生对应一个老师
    private MybatisTeacher teacher;
}
