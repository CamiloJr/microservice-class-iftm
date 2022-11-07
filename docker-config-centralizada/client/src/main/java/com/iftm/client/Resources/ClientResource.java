package com.iftm.client.Resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/client")
public class ClientResource {

    @Value("${eureka.instance.instance-id}")
    String id;

    @Value("${test.config}")
    String testConfig;

    @GetMapping
    public String getId() {
        return id;
    }

    @GetMapping("/configs")
    public String getConfigs() {
        return testConfig;
    }
}
