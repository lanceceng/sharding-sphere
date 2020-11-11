package com.example.shardingSphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingSphere.dao.UserMapper;
import com.example.shardingSphere.entity.DistInfo;
import com.example.shardingSphere.entity.UserInfo;
import com.example.shardingSphere.service.DistService;
import com.example.shardingSphere.service.UserService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:43
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired(required = false)
    private DistService distService;

    // 开启XA事务
    @ShardingTransactionType(value = TransactionType.XA)
    // 防止遇到RuntimeException的时候才会回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(UserInfo entity) {
        DistInfo distInfo = new DistInfo(entity.getId(), "key");
        distService.save(distInfo);
        return super.save(entity);
//        int count = baseMapper.saveInfo(entity);
//        System.out.println(count);
//        return true;
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

    @Override
    public int deleteAllUsers(){
        return this.baseMapper.deleteAllUsers();
    }

    @Override
    public int updateUser(UserInfo user){
        return this.baseMapper.updateUser(user);
    }
}
