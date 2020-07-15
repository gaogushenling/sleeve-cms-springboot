package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("spec_value")
public class SpecValueDO {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String value;
    private int specId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String extend;
}
