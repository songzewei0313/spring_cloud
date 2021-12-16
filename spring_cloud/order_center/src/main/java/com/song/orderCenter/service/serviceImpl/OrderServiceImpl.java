package com.song.orderCenter.service.serviceImpl;


import com.song.feignclients.UserClient;
import com.song.orderCenter.mapper.OrderMapper;
import com.song.orderCenter.pojo.Order;

import com.song.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author song
 */
@Service
public class OrderServiceImpl {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    /*public Order selectById(long id) {
        Order order = orderMapper.selectById(id);

//        String url = "http://localhost:8011/user/" + order.getUserId();
        String url = "http://user-center/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }*/

    public Order selectById(long id) {
        Order order = orderMapper.selectById(id);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }

}
