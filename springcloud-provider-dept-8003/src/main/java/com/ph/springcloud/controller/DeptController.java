package com.ph.springcloud.controller;

import com.ph.springcloud.entity.Dept;
import com.ph.springcloud.Service.DeptService;
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

    // 得到具体的配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept){

        return deptService.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept queryDept(@PathVariable("id") long id ){

        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>service"+services);

        //得到一个具体的微服务信息,通过具体的微服务id,Eureka网址的addlicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for(ServiceInstance instance :instances){
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }
        return this.client;
    }

}