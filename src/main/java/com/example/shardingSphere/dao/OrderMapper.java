package com.example.shardingSphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingSphere.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

    OrderEntity selectByUserId(Integer userId);

    List<OrderEntity> selectOrderJoinOrderItem(Integer userId, Integer orderId);

    List<OrderEntity> selectOrderJoinOrderItemNoSharding(Integer userId, Integer orderId);
}
