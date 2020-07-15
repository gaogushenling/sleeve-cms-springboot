package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@TableName("sku")
public class SkuDO {
    private int id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private byte online;
    private String img;
    private String title;
    private int spuId;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Object specs;
    private String code;
    private int stock;
    private Integer categoryId;
    private Integer rootCategoryId;
}
