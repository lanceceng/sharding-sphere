package com.example.shardingSphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingSphere.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:39
 * @Description: user dao层
 */
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    /**
     * 定义SQL查询
     * @return
     */
    List<UserInfo> queryList();

    int saveInfo(UserInfo userInfo);

    int deleteAllUsers();

    int updateUser(UserInfo user);
}
