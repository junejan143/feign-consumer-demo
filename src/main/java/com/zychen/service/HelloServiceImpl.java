package com.zychen.service;

import com.zychen.config.DisableHystrixConfiguration;
import com.zychen.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 章源辰
 * @time: 2017/9/26 21:50
 * @describion:
 */
@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class, configuration = DisableHystrixConfiguration.class)
public interface HelloServiceImpl {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
