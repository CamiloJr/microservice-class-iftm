package com.iftm.clientfeign.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client")
public interface ClientFeign {

    @RequestMapping("/client")
    public String getId();
}
