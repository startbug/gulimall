package com.ggs.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggs.common.utils.PageUtils;
import com.ggs.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author starbug
 * @email a1285226024@gmail.com
 * @date 2020-12-14 11:35:57
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

