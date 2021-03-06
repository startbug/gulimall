package com.ggs.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggs.common.utils.PageUtils;
import com.ggs.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author starbug
 * @email a1285226024@gmail.com
 * @date 2020-12-14 13:08:12
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

