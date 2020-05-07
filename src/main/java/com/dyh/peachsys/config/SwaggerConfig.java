package com.dyh.peachsys.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Peach-華
 * @version V1.0
 * @desc swagger配置
 * @copyright &copy; DYH
 * @date 2020/5/7-22:00
 * @address 成都
 */
@Configuration  //让Spring来加载该类配置
@EnableSwagger2 //开启swagger，这个注解也可以在启动类中配置
public class SwaggerConfig {
    @Bean   //配置swagger的Docket的bean实例
    public Docket createRestApi(Environment environment) {
        /**
         * 在开发时启用swagger
         * 在发布时不启用
         */
        //设置环境
        Profiles profiles = Profiles.of("dev");
        //判断是否处于环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//文档信息
                .enable(flag)//是否启用swagger，true启动，false不启用，在发布时选择false
                .select()
//                .apis(RequestHandlerSelectors.basePackage(""))//指定要扫描的包
//                .apis(RequestHandlerSelectors.any())//扫描全部
//                .apis(RequestHandlerSelectors.none())//都不扫描
//                .apis(RequestHandlerSelectors.withClassAnnotation())//扫描类上的注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描方法上的注解
                .paths(PathSelectors.any())//过滤
                .build();
    }

    /**
     * swagger信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("華", "https://blog.csdn.net/weixin_45481406", "");
        /**
         * 这种写法不能省略参数
         */
//        return new ApiInfo(
//                "SwaggerApi文档",//标题
//                "这是一个很牛逼的作者",//描述
//                "1.0",  //版本
//                "https://blog.csdn.net/weixin_45481406",//组织
//                contact,//作者信息
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
        /**
         * 这种写法可以省略不必要的参数
         */
        return new ApiInfoBuilder()
                .title("SwaggerApi文档")
                .description("这是一个很牛逼的作者")
                .version("1.0.0")
                .build();
    }
}
