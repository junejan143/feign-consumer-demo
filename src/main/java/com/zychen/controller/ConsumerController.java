package com.zychen.controller;

import com.zychen.dto.User;
import com.zychen.service.HelloServiceImpl;
import com.zychen.service.RefactorHelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 章源辰
 * @time: 2017/9/24 22:10
 * @describion:
 */
@RestController
public class ConsumerController {

    @Qualifier(value = "hello-service")
    @Autowired
    private HelloServiceImpl helloService;
    @Autowired
    private RefactorHelloServiceImpl refactorHelloService;

    @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI", 30)).append("\n");
        sb.append(helloService.hello(new com.zychen.domain.User("DIDI", 30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        //System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI", 20)).append("\n");
        sb.append(refactorHelloService.hello(new User("MIMI", 20))).append("\n");
        return sb.toString();
    }
}
