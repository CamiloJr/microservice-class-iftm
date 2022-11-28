package com.iftm.service.Controllers;

import com.iftm.service.Services.Utils;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private Utils utils;

    @Value("${eureka.instance.instance-id}") // obtem o id da instancia da variavel de ambiente
    String id;

    @Value("${test.config}") // obtem as configs da variavel de ambiente test armazenadas no github
    String testConfig;

    @GetMapping
    public String getId() {
        return id;
    }

    @GetMapping("/configs")
    public String getConfigs() {
        return testConfig;
    }

    @GetMapping("/reverse/{string}")
    public String reverseString(@PathVariable String string) {
        return utils.reverseString(string);
    }

    @GetMapping("/to-upper/{string}")
    public String toUpperString(@PathVariable String string) {
        return utils.toUpperCase(string);
    }
}
