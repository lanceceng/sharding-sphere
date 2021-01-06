package com.example.shardingSphere;

//import org.apache.shardingsphere.underlying.common.config.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = {"com.example.shardingSphere.*"})
@SpringBootApplication(exclude = {JtaAutoConfiguration.class})
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class ShardingSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereApplication.class, args);
	}

}
