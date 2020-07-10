package com.solvay.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.solvay.springcloud.dao"})
public class MyBatisConfig {
}
