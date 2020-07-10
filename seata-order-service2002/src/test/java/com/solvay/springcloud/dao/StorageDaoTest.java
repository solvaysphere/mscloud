package com.solvay.springcloud.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageDaoTest {

    @Resource
    private StorageDao storageDao;

    @Test
    public void decreaseTest(){
        storageDao.decrease(1L, 10);
        System.out.println("库存扣减成功");
    }
}
