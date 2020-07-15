package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("category")
public class CategoryDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private byte isRoot;
    private Integer parentId;
    private String img;

    @TableField(value="`index`")   // index 是 SQL 保留关键字，需要转译，否则报错
    private Integer index;
    private Integer online;
    private Integer level;
}
