package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
// @EqualsAndHashCode()
// @Accessors(chain = true)
@TableName("spu")
public class SpuDO {
    private int id;
    private String title;
    private String subtitle;
    private int categoryId;
    private Integer rootCategoryId;
    private byte online;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String price;
    private Integer sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Byte isTest;
    private Object spuThemeImg;
    private String forThemeImg;
}
