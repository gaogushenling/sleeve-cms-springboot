package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@TableName("spu_detail_img")
@Accessors(chain = true)
public class SpuDetailImgDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String img;
    private Integer spuId;

    @TableField(value = "`index`")
    private Integer index;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
