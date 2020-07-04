package com.dyh.peachsys.xizudemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyh.peachsys.xizudemo.mapper.XZTopicMapper;
import com.dyh.peachsys.xizudemo.entity.XZTopic;
import com.dyh.peachsys.xizudemo.service.IXZTopicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:24
 * @address 成都
 */
@Service
public class XZTopicService extends ServiceImpl<XZTopicMapper, XZTopic> implements IXZTopicService {
    @Override
    public List<XZTopic> topicByPage(Integer start, Integer limit) {
        return baseMapper.topicByPage(start, limit);
    }

    @Override
    public XZTopic getById(Integer id) {
        return baseMapper.getById(id);
    }
}
