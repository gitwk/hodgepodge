package com.wk.hodgepodge.business.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkai
 * @since JDK8
 */
@RestController
public class ConfigController {

    @NacosValue(value = "${business:12}", autoRefreshed = true)
    private String test;

    @GetMapping("config/get")
    public Object getConfig() {
        return test;
    }

}
