package com.ph.springcloud.cofig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // @Configuration --> Spring application.xml
public class ConfigBean {
    //本来是在xml中使用<bean>中配置，

    @Bean
    @LoadBalanced // ribbon,配置负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
        // 把这个Bean注册到容器中使用
    }


}
