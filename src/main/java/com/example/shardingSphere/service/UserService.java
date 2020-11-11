package com.example.shardingSphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shardingSphere.entity.UserEntity;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:40
 * @Description:
 */
public interface UserService extends IService<UserEntity> {
    /**
     * 保存用户信息
     * @param entity
     * @return
     */

    @Override
    boolean save (UserEntity entity);


    /**
     * 查询全部用户信息
     * @return
     */

    List<UserEntity> getUserList();

    List<UserEntity> getListCondition();
    List<UserEntity> getListCondition1();
    List<UserEntity> getListCondition2();

    List<UserEntity> queryList();

    int deleteAllUsers();

    int updateUser(UserEntity user);
}
