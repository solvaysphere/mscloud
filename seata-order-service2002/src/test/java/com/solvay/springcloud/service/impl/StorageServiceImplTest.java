package com.solvay.springcloud.service.impl;

import com.solvay.springcloud.service.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageServiceImplTest {
    @Autowired
    private StorageService storageService;

    @Test
    public void decreaseTest(){
        storageService.decrease(1L, 10);
        System.out.println("库存扣减成功");
    }
}
