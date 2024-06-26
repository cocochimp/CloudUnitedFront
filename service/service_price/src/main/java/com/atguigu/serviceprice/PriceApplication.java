package com.atguigu.serviceprice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Configuration
@MapperScan("com.atguigu.serviceprice.mapper")
@EnableSwagger2
public class PriceApplication {
    public static void main(String[] args){
        SpringApplication.run(PriceApplication.class,args);
    }
}
