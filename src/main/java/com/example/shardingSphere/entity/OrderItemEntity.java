package com.example.shardingSphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("t_order_item")
public class OrderItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer productId;

    private String productName;

    private BigDecimal price;

    private BigDecimal discount;

    private Integer count;


}
