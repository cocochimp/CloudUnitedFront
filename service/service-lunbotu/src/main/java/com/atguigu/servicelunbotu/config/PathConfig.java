package com.atguigu.servicelunbotu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class PathConfig extends WebMvcConfigurerAdapter{
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/lunbotu/**").addResourceLocations("file:service\\service-lunbotu\\src\\main\\resources\\static\\image\\");
        super.addResourceHandlers(registry);
    }

    /*分页插件*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
 
}
