package com.song.orderCenter.mapper;

import com.song.orderCenter.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author song
 */
@Mapper
@Component
public interface OrderMapper {
    Order selectById(@Param("id") long id);
}
