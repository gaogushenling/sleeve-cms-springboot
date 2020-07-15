package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.model.CategoryDO;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, CategoryDO> {
    public CategoryDO getCategoryById(Integer id) {
        CategoryDO categoryDO = this.getById(id);
        if (categoryDO == null) {
            throw new NotFoundException(40000);
        }
        return categoryDO;
    }
}
