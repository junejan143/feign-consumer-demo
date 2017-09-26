# Spring Cloud Feign

* 调用`server-provider-a`项目提供的服务
* `eureka-server-demo`提供注册服务

### 禁用Hystrix
* feign.hystrix.enabled=false 可以全局关闭Hystrix支持
* 如果只是想针对某个服务关闭Hystrix支持是，需要使用`@Scope("prototype"`注解为指定的客户端配置`Feign.Builder`实例
> 1. 构建一个关闭Hystrix的配置类`DisableHystrixConfiguration`
> 2. 在`HelloServiceImpl`中加入如下配置```@FeignClient(value = "hello-service", configuration = DisableHystrixConfiguration.class)```

### 服务降级
* 构建一个类`HelloServiceFallback`
* 在`HelloServiceImpl`中加入如下配置```@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)```

### 请求压缩
* 支持对请求与响应进行GZIP压缩
```
feign.compression.request.enabled=true
feign.compression.response.enabled=true
```

### 日志配置
* 四种日志级别
1. NONE: 不记录任何信息
2. BASIC: 仅记录请求方法、URL以及响应状态码和执行时间
3. HEADERS: 除了记录BASIC级别的信息外，还会记录请求和响应的头信息
4. FULL: 记录所有的请求与响应的明细，包括头信息、请求体、元数据等