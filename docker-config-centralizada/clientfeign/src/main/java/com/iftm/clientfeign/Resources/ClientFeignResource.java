package com.iftm.clientfeign.Resources;

import com.iftm.clientfeign.Feign.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client-feign")
public class ClientFeignResource {

    @Autowired
    ClientFeign clientFeign;

    @Value("${eureka.instance.instance-id}")
    String feignId;

    @GetMapping
    public String getFeignId() {
        return "Feign ID: " + feignId + "<br>\nClient ID: " + clientFeign.getId();
    }

    @GetMapping("/configs")
    public String getConfigs() {
        return clientFeign.getConfigs();
    }
}
