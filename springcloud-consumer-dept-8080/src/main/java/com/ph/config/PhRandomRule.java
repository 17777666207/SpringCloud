
package com.ph.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;
// import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class PhRandomRule extends AbstractLoadBalancerRule {
    public PhRandomRule() {
    }

    // 定义自己的负载均衡策略
    //每个服务访问五次，换下一个服务，共三个服务
    // total = 0 默认 = 0 如果等于5，则指向下一个节点
    //index = 0,默认0，如果total=5，index+1
    private int total = 0; // 被调用的次数
    private int currentIndex = 0; // 当前是谁在提供服务

    //@SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) { // 有没有负载均衡
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获取活着的服务
                List<Server> allList = lb.getAllServers();  //获取全部服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                // int index = this.chooseRandomInt(serverCount); // 生成区间随机数
                // server = (Server)upList.get(index);  // 从活着的服务中随机获取一个

                //----------开始自定义自己的负载规则
                    if (total<5){
                        server = upList.get(currentIndex);// 从0开始获取服务
                        total++;
                    }else {
                        total=0;
                        currentIndex++;
                        if (currentIndex > upList.size()){
                            currentIndex = 0; // 当前服务数大于活着的服务，重新开始
                        }
                        server = upList.get(currentIndex);

                    }
                //-----------自定义结束


                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
