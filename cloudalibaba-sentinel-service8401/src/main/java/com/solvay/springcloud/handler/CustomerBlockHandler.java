package com.solvay.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.solvay.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义的限流处理信息......" + exception.getClass().getCanonicalName() + ".... CustomerBlockHandler");
    }
}
