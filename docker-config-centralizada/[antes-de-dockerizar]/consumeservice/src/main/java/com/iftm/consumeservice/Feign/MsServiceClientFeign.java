package com.iftm.consumeservice.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-service") // Nome do microsservico que sera acessado pelo feignclient
public interface MsServiceClientFeign {

    @GetMapping("/service")
    public String getId();

    @GetMapping("/service/configs")
    public String getConfigs();

    @GetMapping("/service/reverse/{string}")
    public String reverseString(@PathVariable String string);

    @GetMapping("/service/to-upper/{string}")
    public String toUpperString(@PathVariable String string);

}