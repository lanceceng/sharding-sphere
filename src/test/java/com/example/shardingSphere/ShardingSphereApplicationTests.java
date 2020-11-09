package com.example.shardingSphere;

import com.example.shardingSphere.entity.DistInfo;
import com.example.shardingSphere.entity.UserInfo;
import com.example.shardingSphere.service.DistService;
import com.example.shardingSphere.service.UserService;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingSphereApplicationTests {

	@Autowired(required = false)
	private UserService userService;

	@Autowired(required = false)
	private DistService distService;

	@Test
	public void contextLoads() {
		// 清空所有user表
		userService.deleteAllUsers();
//		List<Integer> ids = Arrays.asList(1, 2, 3, 4);
//		userService.removeByIds(ids);
		// 插入到数据库：ds1 ， 表：user_1
		var user1 = new UserInfo(1, "小明", 19);
		// 插入到数据库：ds0 ， 表：user_0
		var user2 = new UserInfo(2, "张三", 20);
		// 插入到数据库：ds1 ， 表：user_0
		var user3 = new UserInfo(3, "李四", 22);
		// 插入到数据库：ds0 ， 表：user_1
		var user4 = new UserInfo(4, "小红", 17);
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);

		// 广播表，每个库都会插入
		var dist = new DistInfo(new Random().nextInt(1000), "配置表");
		distService.save(dist);
	}

}
