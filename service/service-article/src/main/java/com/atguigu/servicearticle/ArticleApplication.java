package com.atguigu.servicearticle;/**
 * Create By retempalon .
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@PackageName:com.atguigu
 *@ClassName:EduApplication
 *@Description:
 *@author retempal
 *@date 2021/9/1211:09
 */
@EnableAsync //开启异步注解功能
@EnableScheduling //开启基于注解的定时任务
@SpringBootApplication
@MapperScan("com/atguigu/servicearticle/mapper")
@ComponentScan(basePackages = {"com.atguigu","com.atguigu.servicearticle"}) //因为默认的包名就是com.atguigu
@EnableDiscoveryClient//nacos注册 可以发现客户端 //让云端发现注册的服务
@EnableFeignClients//调用端使用
public class ArticleApplication {
    public static void main(String[] args){
        SpringApplication.run(ArticleApplication.class,args);
    }
}
