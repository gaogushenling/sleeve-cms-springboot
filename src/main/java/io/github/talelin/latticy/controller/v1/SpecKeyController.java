package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.service.SpecKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/spec-key")
public class SpecKeyController {
    @Autowired
    private SpecKeyService specKeyService;

    // 根据SpuId获取所有规格，spu与spec是多对多关系
    @GetMapping("/by/spu/{id}")
    public List<SpecKeyDO> getBySpuId(@PathVariable(value = "id") @Positive Long id) {
        return this.specKeyService.getBySpuId(id);
    }
}
