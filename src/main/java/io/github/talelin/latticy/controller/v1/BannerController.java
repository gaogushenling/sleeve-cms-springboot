package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RequestMapping("/v1/banner")
@RestController
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PostMapping
    public CreatedVO create(@RequestBody @Validated BannerDTO dto){
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(dto, bannerDO);
        this.bannerService.save(bannerDO);
        return new CreatedVO();
    }

    @GetMapping("/{id}")
    public BannerWithItemsBO getWithItems(@PathVariable @Positive Long id){
        return bannerService.getWithItems(id);
    }


    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated BannerDTO dto,
                            @PathVariable @Positive Long id) {
        bannerService.update(dto, id);
        // 返回结果形式
        // 1. Page 分页结果
        // 2. 查询的资源结果JSON BannerDO
        // 3. UnifyResponseVO（Lin CMS）
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id){
        bannerService.delete(id);
        return new DeletedVO();
    }

    // 分页查询
    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(value = 0) Integer page,
                                               @RequestParam(required = false, defaultValue = "1")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }
}
