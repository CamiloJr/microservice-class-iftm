package com.iftm.clientfeign.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface ClientFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/client")
    public String getId();

    @RequestMapping(method = RequestMethod.GET, value = "/client/configs")
    public String getConfigs();
}
