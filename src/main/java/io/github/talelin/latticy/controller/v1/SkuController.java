package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.SkuDO;
import io.github.talelin.latticy.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    // 一行代码一个API，否则要分别写 service mapper SQL
    // lambda 表达式 链式调用
    @GetMapping("/by/spu/{id}")
    public List<SkuDO> getBySpuId(@PathVariable(value = "id") @Positive Long spuId) {
        return this.skuService.lambdaQuery().eq(SkuDO::getSpuId, spuId).list();
    }
}
