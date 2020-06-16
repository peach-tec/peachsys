package com.dyh.peachsys.mybatisdemo.mapper;

import com.dyh.peachsys.mybatisdemo.entity.MybatisStudent;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/13-16:30
 * @address 成都
 */
public interface MybatisStudentMapper {

    List<MybatisStudent> getStudentList();
    List<MybatisStudent> getStudentList2();
}
