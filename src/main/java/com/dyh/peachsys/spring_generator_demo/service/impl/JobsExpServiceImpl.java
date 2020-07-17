package com.dyh.peachsys.spring_generator_demo.service.impl;

import com.dyh.peachsys.spring_generator_demo.entity.JobsExp;
import com.dyh.peachsys.spring_generator_demo.mapper.JobsExpMapper;
import com.dyh.peachsys.spring_generator_demo.service.IJobsExpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作经历 服务实现类
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Service
public class JobsExpServiceImpl extends ServiceImpl<JobsExpMapper, JobsExp> implements IJobsExpService {

}
