package com.ph.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class phRule {
    // 该配置类不可以放在主启动类的上下文、同级包下（官网有说明）
    @Bean
    public IRule myRule(){
        return new PhRandomRule(); // 默认是轮巡，现在自定义为自己的
    }
}
