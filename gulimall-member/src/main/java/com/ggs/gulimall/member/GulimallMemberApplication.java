package com.ggs.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1.远程调用流程
 * 	<dependency>
 * 		<groupId>org.springframework.cloud</groupId>
 * 		<artifactId>spring-cloud-starter-openfeign</artifactId>
 * 	</dependency>
 *	 1、引入open-feign
 *	 2、编写一个接口,告诉SpringCloud这个接口需要调用远程服务
 *	 	1)声明接口的每一个方法都是调用那个远程服务的那个请求
 *        @FeignClient(value = "gulimall-coupon")
 *	 3、开启远程调用功能,指定扫描那个包下的远程调用接口
 *        @EnableFeignClients(basePackages = {"com.ggs.gulimall.member.feign"})
 **/
@EnableFeignClients(basePackages = {"com.ggs.gulimall.member.feign"})
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
