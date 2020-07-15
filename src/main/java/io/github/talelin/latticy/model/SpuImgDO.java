package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("spu_img")
public class SpuImgDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String img;
    private Integer spuId;
    private Date deleteTime;
    private Date updateTime;
    private Date createTime;
}
