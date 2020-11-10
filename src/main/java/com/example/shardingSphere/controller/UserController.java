package com.example.shardingSphere.controller;

import com.example.shardingSphere.entity.UserInfo;
import com.example.shardingSphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:45
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getList")
    public List<UserInfo> getList(){
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public Boolean insert(UserInfo user) {
        return userService.save(user);
    }

    /**
     * update的逻辑是:分片的列必须在where条件里,并且必须同更新的值相同
     * @param user
     * @return
     */
    @GetMapping("/update")
    public Boolean update(UserInfo user) {
//        return userService.updateById(user);
        int count = userService.updateUser(user);
        System.out.println(count);
        return count > 0 ? true : false;
    }

    @GetMapping("/delete")
    public Boolean delete(Integer id) {
        return userService.removeById(id);
    }

    @GetMapping("getListCondition")
    public List<UserInfo> getListCondition(){
        return userService.getListCondition();
    }

    @GetMapping("getListCondition1")
    public List<UserInfo> getListCondition1(){
        return userService.getListCondition1();
    }

    @GetMapping("getListCondition2")
    public List<UserInfo> getListCondition2(){
        return userService.getListCondition2();
    }

    @GetMapping("queryList")
    public List<UserInfo> queryList(){
        return userService.queryList();
    }


}
