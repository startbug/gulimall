package com.ggs.gulimall.order.dao;

import com.ggs.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author starbug
 * @email a1285226024@gmail.com
 * @date 2020-12-15 13:04:51
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
