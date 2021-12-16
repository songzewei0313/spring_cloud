package com.song.orderCenter.controller;

import com.song.orderCenter.pojo.Order;
import com.song.orderCenter.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Song
 */
@RestController
@RequestMapping("/order")
public class OrdersController {
    private OrderServiceImpl orderService;

    @Autowired
    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Autowired
    private StringRedisTemplate strRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public Order selectById(@PathVariable("id") long id) {
        return orderService.selectById(id);
    }

    /*@GetMapping("/redis")
    public String getRedis(String value) {
        strRedisTemplate.opsForValue().set("song", value);
        String song = strRedisTemplate.opsForValue().get("song");
        return song;
    }*/

    @GetMapping("/redis/{value}")
    public String getRedis(@PathVariable("value") String value) {
        strRedisTemplate.opsForValue().set("song", value);
        String song = strRedisTemplate.opsForValue().get("song");
        return song;
    }

}
