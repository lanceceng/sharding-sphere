package com.example.shardingSphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingSphere.dao.UserMapper;
import com.example.shardingSphere.entity.UserInfo;
import com.example.shardingSphere.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Breet
 * @Date: 2019/7/10 11:43
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {
    @Override
    public boolean save(UserInfo entity) {
        return super.save(entity);
    }
    @Override
    public List<UserInfo> getUserList() {
        return this.baseMapper.selectList(Wrappers.<UserInfo>lambdaQuery());
    }

    @Override
    public List<UserInfo> getListCondition() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserInfo::getAge,"5");
        return this.baseMapper.selectList(queryWrapper);
    }
    @Override
    public List<UserInfo> getListCondition1() {
        /***
         *  ***尚未清楚为什么 between and 语句不行
         */
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(UserInfo::getAge,3,9);
        return this.baseMapper.selectList(queryWrapper);
    }
    @Override
    public List<UserInfo> getListCondition2() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserInfo::getAge,3);
        queryWrapper.le(UserInfo::getAge,15);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserInfo> queryList() {
        return this.baseMapper.queryList();
    }
}
