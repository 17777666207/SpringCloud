package com.ph.springcloud.service;

import com.ph.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept QueryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> QueryAll();

    @PostMapping("/dept/add")
    public Boolean addDept(Dept dept);

}


