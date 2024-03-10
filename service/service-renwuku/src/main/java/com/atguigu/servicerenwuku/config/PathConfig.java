package com.atguigu.servicerenwuku.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class PathConfig extends WebMvcConfigurerAdapter{
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/RenWuKuPhoto/**").addResourceLocations("file:service/service-renwuku/src/main/resources/static/image/");
        super.addResourceHandlers(registry);
    }

 
}
