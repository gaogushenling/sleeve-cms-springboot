package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true) // 可以使用链式语法
@TableName("spu")
public class SpuDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String subtitle;
    private Integer categoryId;
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
