package com.ph.springcloud.Service;

import com.ph.springcloud.entity.Dept;

import java.util.List;


public interface DeptService {
    public  boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
