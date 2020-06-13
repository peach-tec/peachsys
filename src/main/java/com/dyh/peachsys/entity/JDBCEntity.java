package com.dyh.peachsys.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/10-22:29
 * @address 成都
 */
@Component
@Data
@ConfigurationProperties(prefix = "app")
public class JDBCEntity {
    public String dbDriver = "";
    public String dbUsername = "";
    public String dbPassword = "";
    public String dbUrl = "";
}
