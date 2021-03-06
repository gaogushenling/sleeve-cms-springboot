package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("banner")
public class BannerDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String title;
    private String description;
    private String img;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic // 逻辑删除 / 物理删除，此处注释表示软删除，标记删除时间
    private Date deleteTime;
}
