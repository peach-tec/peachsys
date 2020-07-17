package com.dyh.peachsys.spring_generator_demo.service.impl;

import com.dyh.peachsys.spring_generator_demo.entity.MyPerson;
import com.dyh.peachsys.spring_generator_demo.mapper.MyPersonMapper;
import com.dyh.peachsys.spring_generator_demo.service.IMyPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Service
public class MyPersonServiceImpl extends ServiceImpl<MyPersonMapper, MyPerson> implements IMyPersonService {

}
