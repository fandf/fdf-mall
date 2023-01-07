package com.fdf.api.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fandongfeng
 * @date 2023/1/7 17:38
 */
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.fdf.api.impl.mapper")
@ComponentScan(value = {"com.fdf.api.base", "com.fdf.api.impl"})
public class AppMember {

    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }

}
