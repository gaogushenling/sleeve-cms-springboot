package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.model.SpuDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuService extends ServiceImpl<SpuMapper, SpuDO> {
    @Autowired
    private SpuMapper spuMapper;

    public SpuDO getById(Long id) {
        SpuDO spu = spuMapper.selectById(id);
        return spu;
    }

    public SpuDetailDO getDetail(Long id){
        return this.getBaseMapper().getDetail(id);
    }
}
