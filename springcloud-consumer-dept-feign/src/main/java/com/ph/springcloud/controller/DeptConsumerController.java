package com.ph.springcloud.controller;

import com.ph.springcloud.entity.Dept;
import com.ph.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：消费者，不需要service层
    // RestTemplate:供我们直接调用就可以了，注册到Spring中
    //核心方法，三个参数，url,参数类型，返回值类型（url，实体：Map，Class<T> responseType）

 /*   @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程http服务的方法，简单的restful服务模板

//    private static final String REST_URL_PERFIX = "http://localhost:8001";
    // 使用Ribbon做负载均衡，访问地址应该是一个变量，通过8001的SPRINGCLOUD-PROVIDER-DEPT服务名来访问，配置文件中服务地址存在三种选择（application.yaml中的defaultZone ）
    // 可通过特殊的处理达到负载均衡
    private static final String REST_URL_PERFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
*/
    // 使用 Feign 来做负载均衡，以上都不需要了，使用注解
    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/dept/list")
    public List<Dept> query(Dept dept){

//        return restTemplate.getForObject(REST_URL_PERFIX+"/dept/list",List.class);
        List<Dept> depts = deptClientService.QueryAll();
        return this.deptClientService.QueryAll();
    }

    @RequestMapping("/dept/add")
    public boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.QueryById(id);
    }

}
