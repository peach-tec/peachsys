package com.dyh.peachsys.mybatisdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/13-20:54
 * @address 成都
 */
@Data
public class MybatisTeacher2 {
    private Integer id;
    private String name;
    //一个教师对应多个学生
    private List<MybatisStudent2> students;
}
