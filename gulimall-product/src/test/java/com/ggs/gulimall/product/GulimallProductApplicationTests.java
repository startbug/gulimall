package com.ggs.gulimall.product;

<<<<<<< HEAD
import com.ggs.gulimall.product.entity.BrandEntity;
import com.ggs.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.junit.jupiter.api.Test;
>>>>>>> 2ed043713065bde2f5c7793492317d75f1aa505f
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

<<<<<<< HEAD
    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为...");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }
=======
	@Test
	void contextLoads() {
	}
>>>>>>> 2ed043713065bde2f5c7793492317d75f1aa505f

}
