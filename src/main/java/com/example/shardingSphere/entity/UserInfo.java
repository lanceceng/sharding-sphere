package com.example.shardingSphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Author: Breet
 * @Date: 2019/7/10 11:37
 * @Description:
 */
@Data
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
