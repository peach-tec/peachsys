package com.dyh.peachsys.xizudemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyh.peachsys.xizudemo.entity.XZTopic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:20
 * @address 成都
 */
public interface XZTopicMapper extends BaseMapper<XZTopic> {

    @Select("select * from xz_topic limit #{start}, #{limit}")
    List<XZTopic> topicByPage(@Param("start") Integer start, @Param("limit") Integer limit);

    @Select("select * from xz_topic where id = #{id}")
    XZTopic getById(@Param("id")Integer id);
}
