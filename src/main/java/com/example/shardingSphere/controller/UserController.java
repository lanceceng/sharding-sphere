package com.example.shardingSphere.controller;

import com.example.shardingSphere.entity.UserEntity;
import com.example.shardingSphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:45
 * @Description:
 */
@RestController
@RequestMapping("/users/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserEntity> getList(){
        return userService.getUserList();
    }

    @PostMapping("/insert")
    public Boolean insert(UserEntity user) {
        return userService.save(user);
    }

    /**
     * update的逻辑是:分片的列必须在where条件里,并且必须同更新的值相同
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Boolean update(UserEntity user) {
//        return userService.updateById(user);
        int count = userService.updateUser(user);
        System.out.println(count);
        return count > 0 ? true : false;
    }

    @PostMapping("/delete")
    public Boolean delete(Integer id) {
        return userService.removeById(id);
    }

    @GetMapping("getListCondition")
    public List<UserEntity> getListCondition(){
        return userService.getListCondition();
    }

    @GetMapping("getListCondition1")
    public List<UserEntity> getListCondition1(){
        return userService.getListCondition1();
    }

    @GetMapping("getListCondition2")
    public List<UserEntity> getListCondition2(){
        return userService.getListCondition2();
    }

    @GetMapping("queryList")
    public List<UserEntity> queryList(){
        return userService.queryList();
    }


}
