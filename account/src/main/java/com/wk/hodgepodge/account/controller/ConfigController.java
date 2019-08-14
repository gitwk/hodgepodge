package com.wk.hodgepodge.account.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkai
 * @since JDK8
 */
@RestController
public class ConfigController {

    @NacosValue(value = "${user:1}", autoRefreshed = true)
    private String username;

    @GetMapping("config/get")
    public Object getConfig() {
        return username;
    }
}
