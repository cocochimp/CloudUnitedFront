package com.atguigu.servicepublicity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
//@MapperScan("com.atguigu.serviceprice.mapper")
@EnableSwagger2
public class PublicityApplication {
    public static void main(String[] args){
        SpringApplication.run(PublicityApplication.class,args);
    }
}
