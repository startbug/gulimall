package com.ggs.gulimall.product.dao;

import com.ggs.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author starbug
 * @email a1285226024@gmail.com
 * @date 2020-12-14 11:35:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
