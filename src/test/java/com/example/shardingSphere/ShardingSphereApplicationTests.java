package com.example.shardingSphere;

import com.example.shardingSphere.entity.OrderEntity;
import com.example.shardingSphere.entity.OrderItemEntity;
import com.example.shardingSphere.service.DistService;
import com.example.shardingSphere.service.OrderItemService;
import com.example.shardingSphere.service.OrderService;
import com.example.shardingSphere.service.UserService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereApplicationTests {

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private DistService distService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    /**
     * 与分片子表关联
     *
     * @param
     * @return void
     * @author cat
     * @date 2020-11-11 11:01
     */
    @Test
    public void contextLoads() {
        // 清空所有user表
//		userService.deleteAllUsers();
////		List<Integer> ids = Arrays.asList(1, 2, 3, 4);
////		userService.removeByIds(ids);
//		// 插入到数据库：ds1 ， 表：user_1
//		var user1 = new UserInfo(1, "小明", 19);
//		// 插入到数据库：ds0 ， 表：user_0
//		var user2 = new UserInfo(2, "张三", 20);
//		// 插入到数据库：ds1 ， 表：user_0
//		var user3 = new UserInfo(3, "李四", 22);
//		// 插入到数据库：ds0 ， 表：user_1
//		var user4 = new UserInfo(4, "小红", 17);
//		userService.save(user1);
//		userService.save(user2);
//		userService.save(user3);
//		userService.save(user4);
//
//		// 广播表，每个库都会插入
//		var dist = new DistInfo(new Random().nextInt(1000), "配置表");
//		distService.save(dist);
    }

    /**
     * 与分片子表关联
     *
     * @param
     * @return void
     * @author cat
     * @date 2020-11-11 11:10
     */
    @Test
    @ShardingTransactionType(value = TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void testSaveOrder() {
        for (int i = 0; i < 10; i++) {
            Integer orderId = 1000 + i;
            Integer userId = 10 + i;

            OrderEntity o = new OrderEntity();
            o.setOrderId(orderId);
            o.setUserId(userId);
            o.setAmount(new BigDecimal(100));
            o.setDiscount(new BigDecimal(100));
            o.setCreateTime(new Date());
            orderService.save(o);

            // XA事务验证失败，后续跟进
//            if (orderId > 1005) {
//                int a = 1 / 0;
//            }
            Integer productId = 2000 + i;
            OrderItemEntity oi = new OrderItemEntity();
            oi.setProductId(productId);
            oi.setProductName("产品" + productId);
            oi.setOrderId(orderId);
            orderItemService.saveOrderItem(oi, userId);
        }
    }

    /**
     * 根据分片键查询
     *
     * @param
     * @return void
     * @author cat
     * @date 2020-11-11 11:26
     */
    @Test
    public void testSelectByUserId() {
        Integer userId = 12;
        HintManager.getInstance().setMasterRouteOnly();
        OrderEntity o1 = orderService.selectByUserId(userId);
        System.out.println(o1);

        userId = 17;
        OrderEntity o2 = orderService.selectByUserId(userId);
        System.out.println(o2);
    }

    /**
     * 与分片子表关联
     *
     * @param
     * @return void
     * @author cat
     * @date 2020-11-11 11:28
     */
    @Test
    public void testSelectOrderJoinOrderItem() {
        // 指定了子表分片规则
        List<OrderEntity> o1 = orderService.selectOrderJoinOrderItem(12, 1002);
        System.out.println(o1);
        System.out.println("------------------------------------------------------------------------");
        // 未指定子表分片规则：导致子表的全路由
        List<OrderEntity> o2 = orderService.selectOrderJoinOrderItemNoSharding(12, 1002);
        System.out.println(o2);
    }


}
