package com.solvay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${username}")
    private String username;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getUsername")
    public String getUsername(){
        return username;
    }

    @GetMapping("/configinfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
