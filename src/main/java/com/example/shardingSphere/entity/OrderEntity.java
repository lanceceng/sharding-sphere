package com.example.shardingSphere.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("t_order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private Long orderId;

    private Long userId;

    private BigDecimal amount;

    private BigDecimal discount;

    private Date createTime;


}
