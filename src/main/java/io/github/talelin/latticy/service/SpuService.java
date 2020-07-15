package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpuService extends ServiceImpl<SpuMapper, SpuDO> {
    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;

    @Autowired
    private SpuKeyService spuKeyService;

    public SpuDO getById(Integer id) {
        SpuDO spu = spuMapper.selectById(id);
        return spu;
    }

    public SpuDetailDO getDetail(Integer id) {
        return this.getBaseMapper().getDetail(id);
    }

    @Transactional // 事务
    public void create(SpuDTO dto) {
        // 保存 spu 的基本信息 -> spu 表
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(dto, spuDO);

        // 校验category是否存在 判断关联表是否存在匹配数据
        CategoryDO categoryDO = categoryService.getCategoryById(dto.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());
        this.save(spuDO);

        // 保存到 spu_img 表
        List<String> spuImgList = new ArrayList<>();
        if (dto.getSpuImgList() == null) {
            spuImgList.add(dto.getImg());
        } else {
            spuImgList = dto.getSpuImgList();
        }
        this.insertSpuImgList(spuImgList, spuDO.getId());

        // 保存到 spu_detail_img 表

        if (dto.getDetailImgList() != null) {
            this.insertSpuDetailImgList(dto.getDetailImgList(), spuDO.getId());
        }

        // 保存到 spu_key 表
        if (dto.getSpecKeyIdList() != null) {
            this.insertSpecKeyList(dto.getSpecKeyIdList(), spuDO.getId());
        }
    }

    // 数据库批量插入 stream 方式
    private void insertSpuImgList(List<String> spuImgList, Integer spuId) {
        // string list 转化成 DO list
        List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s -> {
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(s);
            spuImgDO.setSpuId(spuId);
            return spuImgDO;
        }).collect(Collectors.toList());
        this.spuImgService.saveBatch(spuImgDOList);
    }

    // 批量插入 for 循环方式
    private void insertSpuDetailImgList(List<String> spuDetailImgList, Integer spuId) {
        List<SpuDetailImgDO> spuDetailImgDOList = new ArrayList<>();
        for (int i = 0; i < spuDetailImgList.size(); i++) {
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setImg(spuDetailImgList.get(i))
                    .setSpuId(spuId)
                    .setIndex(i);
            spuDetailImgDOList.add(spuDetailImgDO);
        }
        this.spuDetailImgService.saveBatch(spuDetailImgDOList);
    }

    // 多对多关系表插入
    private void insertSpecKeyList(List<Integer> specKeyIdList, Integer spuId) {
        List<SpuKeyDO> spuKeyDOList = specKeyIdList.stream()
                .map(sk -> {
                    SpuKeyDO spuKeyDO = new SpuKeyDO();
                    spuKeyDO.setSpuId(spuId)
                            .setSpecKeyId(sk);
                    return spuKeyDO;
                }).collect(Collectors.toList());
        this.spuKeyService.saveBatch(spuKeyDOList);
    }
}
