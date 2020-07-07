package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.service.SpuService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/spu")
@Validated
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/{id}")
    public SpuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        SpuDO spu = spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException("spu not found", 30001);
        }
        return spu;
    }

    @GetMapping("/page")
    public PageResponseVO<SpuDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Integer count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Integer page
    ) {
        Page<SpuDO> pager = new Page<>(page, count);
        IPage<SpuDO> paging = spuService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }

    @GetMapping("/{id}/detail")
    public SpuDetailDO getDetail(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        SpuDetailDO spuDetailDO = spuService.getDetail(id);
        if (spuDetailDO == null) {
            throw new NotFoundException("spu not found", 30001);
        }
        return spuDetailDO;
    }
}
