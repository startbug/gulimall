package com.ggs.gulimall.member.feign;

import com.ggs.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @Author Starbug
 *  @Date 2020/12/19 16:05
 *  @Description 这是一个声明式远程调用
 */
@FeignClient(value = "gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}