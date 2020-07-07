package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {
    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    public void update(BannerDTO dto, Long id) {
        BannerDO banner = this.getById(id);
        if (banner == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(dto, banner);
        this.updateById(banner);
    }

    public void delete(Long id) {
        BannerDO banner = this.getById(id);
        if (banner == null) {
            throw new NotFoundException(20000);
        }
        this.getBaseMapper().deleteById(id);
    }

    // 一个主banner和一组bannerItem一起返回
    public BannerWithItemsBO getWithItems(Long id) {
        // 单表查询
        BannerDO banner = this.getById(id);
        if (banner == null) {
            throw new NotFoundException(20000);
        }

        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();

//        LambdaQueryWrapper<BannerItemDO> wrapper1 = new LambdaQueryWrapper<>();
//        wrapper.eq("banner_id", id); // 对应表的字段名
        wrapper.lambda().eq(BannerItemDO::getBannerId, id); // 操作 DO, lambda 表达式
        List<BannerItemDO> bannerItems = bannerItemMapper.selectList(wrapper);

        return new BannerWithItemsBO(banner, bannerItems);
    }
}
