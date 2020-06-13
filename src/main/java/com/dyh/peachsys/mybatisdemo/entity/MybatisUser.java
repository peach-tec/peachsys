package com.dyh.peachsys.mybatisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/12-20:36
 * @address 成都
 *
 * 1、导入jar包
 * 2、在.properties中配置.xml的路径
 * 3、创建实体类
 * 4、创建mapper
 * 5、创建mapper对应的xml文件，建议放在resources目录下，如果放在java源码目录下，需要在pom文件中配置
 * 6、在启动类中配置mapper扫描的路径，也可以使用@Mapper注解
 * 7、测试
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MybatisUser")//实体类的别名，在xml中配置resultType参数时可直接使用这个别名，无需在写包名
public class MybatisUser implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
