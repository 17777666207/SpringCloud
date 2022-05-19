package com.ph.springcloud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
        private Long dempno;
        private String dname;
//        这个数据咋哪个数据库的字段--微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
        private String db_sourse;

        public Dept(String dname){
            this.dname = dname;
        }
//        连式写法：相当于重写set方法，将返回值改成实体类
//          Dept dept = new Dept();
//         dept.setDept(11).setDname('asd')
}
