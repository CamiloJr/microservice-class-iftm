package com.iftm.consumeservice.Controllers;

import com.iftm.consumeservice.Feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume-service")
public class ConsumeServiceControllers {

    @Autowired
    MsServiceClientFeign msServiceClientFeign;

    @Value("${eureka.instance.instance-id}")
    String feignId;

    @GetMapping("/instances-id")
    public String getFeignId() {
        return "ConsumeService ID: " + feignId + "<br>\nService ID: " + msServiceClientFeign.getId();
    }

    @GetMapping("/ms-service-configs")
    public String getConfigs() {
        return msServiceClientFeign.getConfigs();
    }

    @GetMapping("/to-upper/{string}")
    public String toUpper(@PathVariable String string) {
        return msServiceClientFeign.toUpperString(string);
    }

    @GetMapping("/reverse/{string}")
    public String reverse(@PathVariable String string) {
        return msServiceClientFeign.reverseString(string);
    }
}
