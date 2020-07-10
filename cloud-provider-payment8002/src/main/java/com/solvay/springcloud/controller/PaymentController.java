package com.solvay.springcloud.controller;

import com.solvay.springcloud.entities.CommonResult;
import com.solvay.springcloud.entities.Payment;
import com.solvay.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("执行结果：" + result);
        if(result > 0 ){
            return new CommonResult(200, "插入数据成功", result);
        }else{
            return new CommonResult(400, "插入数据失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("执行结果：" + payment);
        if(payment != null){
            return new CommonResult(200, "查询数据成功: port" + port, payment);
        }else{

            return new CommonResult(400, "查询数据失败，没有对应的id=" + id);
        }
    }

    @GetMapping("/payment/hello")
    public CommonResult<String> hello(){
        return new CommonResult<>(200, "hello springcloud");
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB () {
        return "服务端口号：" + port;
    }
}
