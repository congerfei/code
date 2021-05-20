package com.xl.client.controller;


import com.xl.provider.pojo.User;
import com.xl.provider.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 使用restTemplate进行远程调用
 */
@RestController
@Slf4j
public class UserController {


//    public static final String PROVIDER_URL = "http://localhost:8001";//单机写死
    public static final String PROVIDER_URL = "http://PROVIDER";//负载均衡写服务名，然后restTemplate配置配上 @LoadBalanced


    @Resource
    private RestTemplate restTemplate;



    @GetMapping("/consumer/user/insert")
    public CommonResult<User> create(User user) {
        return  restTemplate.postForObject(PROVIDER_URL + "/user/insert/",user,CommonResult.class);
    }

    @GetMapping("/consumer/user/getOne/{id}")
    public CommonResult<User> getPayment(@PathVariable("id")String id) {
        return  restTemplate.getForObject(PROVIDER_URL+"/user/getOne/"+id,CommonResult.class);
    }
}
