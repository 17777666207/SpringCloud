package com.ph.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.ph.springcloud.Service.DeptService;
import com.ph.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 提供Restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet") // 熔断
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id=>"+id+",不存在该用户，或信息无法找到--RuntimeException");
        }
        return dept;
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        return new Dept().setDempno(id).setDname("id=>"+id+",熔断：不存在该用户，或信息无法找到--@hystrix")
                         .setDb_sourse("NO THIS DATABASE IN MYSQL");
    }
}
