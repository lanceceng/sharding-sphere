package com.example.shardingSphere.controller;


import com.example.shardingSphere.entity.DistEntity;
import com.example.shardingSphere.service.DistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cat
 * @since 2020-11-11
 */
@RestController
@RequestMapping("/dist/v1")
public class DistController {

    @Autowired
    private DistService distService;

    @GetMapping("/list")
    public List<DistEntity> getList(){
        return distService.list();
    }

    @PostMapping("/insert")
    public Boolean insert(DistEntity user) {
        return distService.save(user);
    }

    /**
     * update的逻辑是:分片的列必须在where条件里,并且必须同更新的值相同
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Boolean update(DistEntity user) {
        return distService.updateById(user);
    }

    @PostMapping("/delete")
    public Boolean delete(Integer id) {
        return distService.removeById(id);
    }
}
