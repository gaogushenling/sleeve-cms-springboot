package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.mapper.SpecKeyMapper;
import io.github.talelin.latticy.model.SpecKeyDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecKeyService extends ServiceImpl<SpecKeyMapper, SpecKeyDO> {
    public List<SpecKeyDO> getBySpuId(Long spuId) {
        return this.getBaseMapper().getBySpuId(spuId);
    }
}
