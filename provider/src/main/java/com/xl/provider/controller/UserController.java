package com.xl.provider.controller;

import com.xl.provider.pojo.User;
import com.xl.provider.service.UserService;
import com.xl.provider.util.CommonResult;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    Environment environment;

    /**
     * 使用 @RequestBody 接收前端传过来的json，转换成User对象
     * @param user
     * @return
     */
    @PostMapping(value = "/insert")
    CommonResult insert(@RequestBody User user) {
        System.out.println(user);
        userService.insert(user);
        return new CommonResult<>(200,"插入成功！");
    }

    /**
     * 如果是取请求路径的值，一定要记得带{}
     * @param id
     * @return
     */
    @GetMapping(value = "/getOne/{id}")
    CommonResult<User> selectUserById(@PathVariable("id") String id) {
        System.out.println("**************************"+environment.getProperty("server.port"));
        User user = userService.selectUserById(id);
        return new CommonResult<>(200,"查询成功！",user);
    }

}
