package com.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Simon
 */
@SpringBootApplication
@ComponentScan("com.manager")       //加载@Service @Control注解类
@MapperScan(value = "com.manager.mapper")  //mybatis 需要扫描mapper接口
@EnableWebMvc                   //启用mvc
@EnableTransactionManagement    //启用事务管理
public class LotteryApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LotteryApplication.class);
    }
}
