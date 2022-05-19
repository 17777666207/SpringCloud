package com.ph.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.ph.springcloud.dao")
@EnableEurekaClient  //在服务启动后自动注册到Eureka中
@EnableDiscoveryClient // 服务的发现，可发现注册中心的服务
public class DeptProvider_8003 {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider_8003.class,args);
    }
}
