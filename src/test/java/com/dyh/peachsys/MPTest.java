package com.dyh.peachsys;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.dyh.peachsys.spring_mybatis_plus_demo.entity.MPDevDocUrl;
import com.dyh.peachsys.spring_mybatis_plus_demo.service.IMPDevDocUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/16-21:29
 * @address 成都
 */
@SpringBootTest
public class MPTest {
    @Autowired
    private IMPDevDocUrlService urlService;

    @Test
    public void test01() {//查询
        List<MPDevDocUrl> list = urlService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {//新增
        MPDevDocUrl url = new MPDevDocUrl();
        url.setDescription("测试URL");
        url.setUrl("www.baidu.com");
        urlService.save(url);
    }

    @Test
    public void test03() {//测试乐观锁
        MPDevDocUrl url = urlService.getById(1);
        url.setDescription("mybatis-spring-boot中文文档");
        urlService.updateById(url);
    }

    @Test
    public void test04() {//分页插件测试
        //分页对象，第一个参数是当前页数，第二个参数是每页的数量
        Page<MPDevDocUrl> page = new Page<>(1, 5);
        //服务层分页查询
        Page<MPDevDocUrl> page1 = urlService.page(page);
        List<MPDevDocUrl> records = page1.getRecords();
        records.forEach(System.out::println);
        //数据操作层分页查询
        Page<MPDevDocUrl> mpDevDocUrlPage = urlService.getBaseMapper().selectPage(page, null);
        List<MPDevDocUrl> records1 = mpDevDocUrlPage.getRecords();
        records1.forEach(System.out::println);
    }

    @Test
    public void test05() {//逻辑删除测试
        urlService.removeById(1);
    }

    @Test
    public void test06(){//代码自动生成器
        //代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String path = System.getProperty("user.dir");//当前系统目录
        gc.setOutputDir(path + "/src/main/java");//代码生成的路径
        gc.setAuthor("peach-D");//作者名字
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//是否覆盖原来生成的
        gc.setIdType(IdType.AUTO);//主键策略
        gc.setDateType(DateType.ONLY_DATE);//日期类型
        gc.setSwagger2(true);//配置swagger

        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);//数据库类型
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");//驱动
        dsc.setUrl("");//数据库地址
        dsc.setUsername("");//用户名
        dsc.setPassword("");//密码
        mpg.setDataSource(dsc);

        //3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("spring_generator_demo");//模块名
        pc.setParent("com.dyh.peachsys");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //策略
        StrategyConfig str = new StrategyConfig();
        str.setNaming(NamingStrategy.underline_to_camel);//包的命名规则，下划线转驼峰命名
        str.setColumnNaming(NamingStrategy.underline_to_camel);//列的命名规则，下划线转驼峰命名
        str.setEntityLombokModel(true);//开启lombok
        str.setLogicDeleteFieldName("status");//逻辑删除的字段名
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);//自动填充
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);//自动填充
        str.setTableFillList(Arrays.asList(createTime,updateTime));
        str.setVersionFieldName("version");//乐观锁
        str.setRestControllerStyle(true);//rest风格
        str.setControllerMappingHyphenStyle(true);//url开启下划线命名
        mpg.setStrategy(str);

        //执行
        mpg.execute();
    }
}
