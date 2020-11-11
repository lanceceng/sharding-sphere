package com.example.shardingSphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingSphere.dao.UserMapper;
import com.example.shardingSphere.entity.DistEntity;
import com.example.shardingSphere.entity.UserEntity;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired(required = false)
    private DistService distService;

    // 开启XA事务
    @ShardingTransactionType(value = TransactionType.XA)
    // 防止遇到RuntimeException的时候才会回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(UserEntity entity) {
        DistEntity distInfo = new DistEntity(entity.getId(), "key");
        distService.save(distInfo);
        return super.save(entity);
//        int count = baseMapper.saveInfo(entity);
//        System.out.println(count);
//        return true;
    }
    @Override
    public List<UserEntity> getUserList() {
        return this.baseMapper.selectList(Wrappers.<UserEntity>lambdaQuery());
    }

    @Override
    public List<UserEntity> getListCondition() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserEntity::getAge,"5");
        return this.baseMapper.selectList(queryWrapper);
    }
    @Override
    public List<UserEntity> getListCondition1() {
        /***
         *  ***尚未清楚为什么 between and 语句不行
         */
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(UserEntity::getAge,3,9);
        return this.baseMapper.selectList(queryWrapper);
    }
    @Override
    public List<UserEntity> getListCondition2() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserEntity::getAge,3);
        queryWrapper.le(UserEntity::getAge,15);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserEntity> queryList() {
        return this.baseMapper.queryList();
    }

    @Override
    public int deleteAllUsers(){
        return this.baseMapper.deleteAllUsers();
    }

    @Override
    public int updateUser(UserEntity user){
        return this.baseMapper.updateUser(user);
    }
}
