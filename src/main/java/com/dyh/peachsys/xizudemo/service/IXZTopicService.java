package com.dyh.peachsys.xizudemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyh.peachsys.xizudemo.entity.XZTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:22
 * @address 成都
 */
public interface IXZTopicService extends IService<XZTopic> {
    List<XZTopic> topicByPage(Integer start, Integer limit);

    XZTopic getById(Integer id);
}
