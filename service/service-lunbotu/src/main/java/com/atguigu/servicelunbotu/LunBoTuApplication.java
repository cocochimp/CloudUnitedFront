package com.atguigu.servicelunbotu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *@PackageName:com.atguigu
 *@ClassName:EduApplication
 *@Description:
 *@author retempal
 *@date 2021/9/1211:09
 */
@SpringBootApplication
@MapperScan("com/atguigu/servicelunbotu/mapper")
@ComponentScan(basePackages = {"com.atguigu","com.atguigu.servicelunbotu"}) //因为默认的包名就是com.atguigu
@EnableDiscoveryClient//nacos注册 可以发现客户端 //让云端发现注册的服务
@EnableFeignClients(basePackages = "com.atguigu.servicelunbotu.Feign")//调用端使用
public class LunBoTuApplication {
    public static void main(String[] args){
        SpringApplication.run(LunBoTuApplication.class,args);
    }
}