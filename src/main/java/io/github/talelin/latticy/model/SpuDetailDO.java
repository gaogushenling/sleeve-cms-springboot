package io.github.talelin.latticy.model;

import lombok.Data;
import java.util.List;

@Data
public class SpuDetailDO extends SpuDO {
    // 关联查询 category
    private String categoryName;

    // 关联查询 spec_key
    private String sketchSpecKeyName;

    // 关联查询 sku
    private String defaultSkuName;

    // 关联查询 spu_img
    private List<String> spuImgList;

    // 关联查询 spu_detail_img
    private List<String> spuDetailImgList;
}
