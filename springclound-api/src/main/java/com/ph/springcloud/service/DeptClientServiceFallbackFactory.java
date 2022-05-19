package com.ph.springcloud.service;

import com.ph.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

// 降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){
            @Override
            public Dept QueryById(Long id) {
                return new Dept().setDempno(id).setDname("id =>"+id+",没有对应信息，客户端提供了降级的信息，这个服务已经被关闭")
                        .setDb_sourse("没有数据");
            }

            @Override
            public List<Dept> QueryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
