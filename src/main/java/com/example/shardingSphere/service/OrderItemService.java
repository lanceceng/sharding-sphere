package com.example.shardingSphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shardingSphere.entity.OrderItemEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    boolean saveOrderItem(OrderItemEntity orderItem, Long userId);

}
