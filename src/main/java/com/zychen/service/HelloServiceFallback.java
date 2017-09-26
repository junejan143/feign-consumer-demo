package com.zychen.service;

import com.zychen.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 章源辰
 * @time: 2017/9/26 23:50
 * @describion:
 */
@Component
public class HelloServiceFallback implements HelloServiceImpl {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }
}
