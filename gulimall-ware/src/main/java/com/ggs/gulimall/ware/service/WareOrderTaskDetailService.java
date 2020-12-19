package com.ggs.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggs.common.utils.PageUtils;
import com.ggs.gulimall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author starbug
 * @email a1285226024@gmail.com
 * @date 2020-12-15 13:07:17
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

