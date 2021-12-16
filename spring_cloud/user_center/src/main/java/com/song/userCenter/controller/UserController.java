package com.song.userCenter.controller;

import com.song.userCenter.pojo.User;
import com.song.userCenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author song
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * 路径： http://localhost:8013/user/3
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    /**
     * http://localhost:8013/user/queryById2?id=3
     * @param id
     * @return
     */
    @GetMapping("/queryById2")
    public User queryById2(@RequestParam Long id) {
        return userService.queryById(id);
    }
}
