package com.example.shardingSphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingSphere.entity.OrderItemEntity;
import com.example.shardingSphere.dao.OrderItemMapper;
import com.example.shardingSphere.service.OrderItemService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

    @Override
    public boolean saveOrderItem(OrderItemEntity orderItem, Long userId) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addDatabaseShardingValue("t_order_item", userId);
            return this.save(orderItem);
        }
    }
}
