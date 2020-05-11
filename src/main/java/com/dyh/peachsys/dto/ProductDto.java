package com.dyh.peachsys.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/11-21:34
 * @address 成都
 */
@Data
@NoArgsConstructor
@ApiModel(value = "商品")
public class ProductDto {
    private Integer id;
    private String name;
    private String logo;
    private Discount discount;
    private BigDecimal price;
    private BigDecimal mallPrice;
    private BigDecimal discountPrice;
    private BigDecimal salesVolume;
}

@Data
class Discount {
    private Integer type;
    private BigDecimal value;
}
