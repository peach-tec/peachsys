package com.dyh.peachsys.spring_generator_demo.service.impl;

import com.dyh.peachsys.spring_generator_demo.entity.MyComment;
import com.dyh.peachsys.spring_generator_demo.mapper.MyCommentMapper;
import com.dyh.peachsys.spring_generator_demo.service.IMyCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人评论 服务实现类
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Service
public class MyCommentServiceImpl extends ServiceImpl<MyCommentMapper, MyComment> implements IMyCommentService {

}
