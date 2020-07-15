package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("spec_key")
public class SpecKeyDO {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String name;
    private String unit;
    private byte standard;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Date deleteTime;
    private String description;
}
