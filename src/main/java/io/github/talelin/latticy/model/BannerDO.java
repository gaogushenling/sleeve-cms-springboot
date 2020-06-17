package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("banner")
public class BannerDO {
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
    private Date deleteTime;
}
