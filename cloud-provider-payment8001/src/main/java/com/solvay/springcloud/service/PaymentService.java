package com.solvay.springcloud.service;

import com.solvay.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    /**
     * 新增
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
