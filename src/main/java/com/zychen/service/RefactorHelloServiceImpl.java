package com.zychen.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author 章源辰
 * @time: 2017/9/26 21:50
 * @describion:
 */
@FeignClient("HELLO-SERVICE")
public interface RefactorHelloServiceImpl extends HelloService{

}
