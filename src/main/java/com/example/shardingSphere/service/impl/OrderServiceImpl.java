package com.example.shardingSphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingSphere.entity.OrderEntity;
import com.example.shardingSphere.dao.OrderMapper;
import com.example.shardingSphere.service.OrderService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {


    @Override
    public OrderEntity selectByUserId(Integer userId){
        return this.baseMapper.selectByUserId(userId);
    }

    @Override
    public List<OrderEntity> selectOrderJoinOrderItem(Integer userId, Integer orderId){
        // 目前发现只要在yml配置文件中加上 bindingTables: - t_order,t_order_item 绑定表的属性，就会自动避免全路由关联查询
        // HintManager（分片键值管理器） 这一步可能有点多余，可能是针对读写分离这种形式的强制路由，起作用，有待考证
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addDatabaseShardingValue("t_order_item", userId);
            return this.baseMapper.selectOrderJoinOrderItem(userId, orderId);
        }
    }

    @Override
    public List<OrderEntity> selectOrderJoinOrderItemNoSharding(Integer userId, Integer orderId){
        return this.baseMapper.selectOrderJoinOrderItemNoSharding(userId, orderId);
    }
}
