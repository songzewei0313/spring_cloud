package com.song.feignclients;

import com.song.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author song
 * FeignClient("user-center") 指定要远程调用的服务名称
 */
@Component
@FeignClient("user-center")
public interface UserClient {
    /**
     * 远程调用 --> 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") long id);
}
