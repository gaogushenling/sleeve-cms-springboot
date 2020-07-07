package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.model.SpuDetailDO;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuMapper extends BaseMapper<SpuDO> {
    SpuDetailDO getDetail(Long id);
}
