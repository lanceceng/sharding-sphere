package com.example.shardingSphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shardingSphere.entity.OrderEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
public interface OrderService extends IService<OrderEntity> {

    OrderEntity selectByUserId(Integer userId);

    List<OrderEntity> selectOrderJoinOrderItem(Integer userId, Integer orderId);

    List<OrderEntity> selectOrderJoinOrderItemNoSharding(Integer userId, Integer orderId);
}
