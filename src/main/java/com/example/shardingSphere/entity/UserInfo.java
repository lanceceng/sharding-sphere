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
@TableName("user")
public class UserInfo extends Model<UserInfo> {

    /**
     * 主键Id
     */
    private int id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
}
