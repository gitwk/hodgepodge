package com.wk.hodgepodge.storage.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkai
 * @since JDK8
 */
@RestController
public class ConfigController {

    @NacosValue(value = "${storage:1}", autoRefreshed = true)
    private String test;

    @GetMapping(value = "config/get")
    public Object getConfig() {
        return test;
    }

}
