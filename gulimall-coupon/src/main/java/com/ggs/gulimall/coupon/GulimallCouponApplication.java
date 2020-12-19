package com.ggs.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  @Author Starbug
 *  @Date 2020/12/14 13:10
配置中心配置方式
1、引入依赖
        <dependency>
           <groupId>com.alibaba.cloud</groupId>
           <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
       </dependency>
2、创建bootstrap.yml
  spring:
    application:
      name: gulimall-coupon
    cloud:
      nacos:
        config:
          server-addr: localhost:8848
          file-extension: yaml
3、需要给配置中心添加一个叫数据集(Data Id) gulimall-coupon.yaml
默认: 微服务名-环境名(dev,prop).指定后缀  ==>  如: gulimall-coupon-dev.yaml
4、给配置中心的配置添加配置信息
5、获取动态配置
    @RefrteshScope: 动态获取并刷新配置
    @Value("${配置项名}"): 获取配置
    如果配置中心和当前应用的配置文件中都配置了相同的项,优先使用配置中心的配置
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
