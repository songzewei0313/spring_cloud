package com.song.orderCenter;


import com.song.feignclients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author song
 * @EnableFeignClients(basePackages = "com.song.feignclients")
 * 包扫描，不然不在SpringBootApplication的扫描宝范围内，无法自动装配
 * @EnableFeignClients(clients = UserClient.class) 指定特定的feign，多个可以数组形式
 */
@MapperScan("com.song.orderCenter.mapper")
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableFeignClients(clients = UserClient.class)
public class OrderCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderCenterApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
