package com.example.shardingSphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shardingSphere.entity.UserInfo;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:40
 * @Description:
 */
public interface UserService extends IService<UserInfo> {
    /**
     * 保存用户信息
     * @param entity
     * @return
     */

    @Override
    boolean save (UserInfo entity);


    /**
     * 查询全部用户信息
     * @return
     */

    List<UserInfo> getUserList();

    List<UserInfo> getListCondition();
    List<UserInfo> getListCondition1();
    List<UserInfo> getListCondition2();

    List<UserInfo> queryList();

    int deleteAllUsers();

    int updateUser(UserInfo user);
}
