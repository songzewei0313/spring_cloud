package com.song.orderCenter.pojo;

import com.song.pojo.User;
import lombok.Data;

/**
 * @author song
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}