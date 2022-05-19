package com.ph.springcloud;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@ComponentScan("com.ph.springcloud")
@EnableFeignClients(basePackages = {"com.ph.springcloud"})
public class feignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(feignDeptConsumer_80.class,args);
    }
}
