package com.example.shardingSphere.controller;

import com.example.shardingSphere.entity.UserEntity;
import com.example.shardingSphere.service.UserService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<UserEntity> list = null;
        try(HintManager hintManager = HintManager.getInstance()) {
            //清除分片键值，分片键值保存在ThreadLocal中，所以需要在操作结束时调用hintManager.close()来清除ThreadLocal中的内容。hintManager实现了AutoCloseable接口，可推荐使用try with resource自动关闭。
            hintManager.setMasterRouteOnly();
            list = userService.getUserList();
        }
        return list;
    }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody UserEntity user) {
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
