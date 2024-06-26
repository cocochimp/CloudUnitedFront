package com.atguigu.serviceprice.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class PathConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/AchievementOfPhoto/**").addResourceLocations("file:service\\service_price\\src\\main\\resources\\static\\image\\");
        registry.addResourceHandler("/fileUpload/**").addResourceLocations("file:service\\service_price\\src\\main\\resources\\status\\");
        super.addResourceHandlers(registry);
    }


}
