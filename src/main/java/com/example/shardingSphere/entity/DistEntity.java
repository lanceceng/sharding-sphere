package com.example.shardingSphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:37
 * @Description:
 */
@Data
@AllArgsConstructor
@TableName("dist")
public class DistEntity extends Model<DistEntity> {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

}
