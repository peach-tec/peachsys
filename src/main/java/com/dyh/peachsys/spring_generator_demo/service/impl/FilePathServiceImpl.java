package com.dyh.peachsys.spring_generator_demo.service.impl;

import com.dyh.peachsys.spring_generator_demo.entity.FilePath;
import com.dyh.peachsys.spring_generator_demo.mapper.FilePathMapper;
import com.dyh.peachsys.spring_generator_demo.service.IFilePathService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件路径 服务实现类
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Service
public class FilePathServiceImpl extends ServiceImpl<FilePathMapper, FilePath> implements IFilePathService {

}
