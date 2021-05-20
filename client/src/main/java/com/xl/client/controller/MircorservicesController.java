package com.xl.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class MircorservicesController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        //服务列表，负载均衡的服务器算一个
        for (String service : services) {
            log.info("*****element:" + service);
        }

        //通过服务名获取实例，负载均衡的服务器算多个
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER");
        for (ServiceInstance instance : instances) {
            log.info("*****CLIENT服务信息*********"+instance.getServiceId()+"\t" + instance.getHost() +
                    "\t" + instance.getPort() +"\t" + instance.getUri());
        }

        return  this.discoveryClient;
    }


}
