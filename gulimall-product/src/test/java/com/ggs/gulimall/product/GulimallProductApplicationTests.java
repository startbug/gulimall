package com.ggs.gulimall.product;

import com.ggs.gulimall.product.entity.BrandEntity;
import com.ggs.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为...");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}
