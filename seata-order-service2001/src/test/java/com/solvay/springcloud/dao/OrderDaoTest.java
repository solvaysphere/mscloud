package com.solvay.springcloud.dao;

import com.solvay.springcloud.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void createTest(){
        Order order = new Order();
        order.setUserId(1L);
        order.setProductId(1L);
        order.setCount(10);
        order.setMoney(new BigDecimal(100));
        orderDao.create(order);
        System.out.println("创建订单成功");
    }

    @Test
    public void updateTest(){
        orderDao.update(1L, 0);
        System.out.println("更新订单成功");
    }
}
