package com.atguigu.servicepublicity.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageConfig {
    /*1. 定义Mp拦截器*/

    @Bean
    public MybatisPlusInterceptor myInterceptor(){
        /*1. 定义Mp拦截器*/
        MybatisPlusInterceptor mpInterceptor=new MybatisPlusInterceptor();
        /*2. 添加具体拦截器*/
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        /*3. 返回*/
        return mpInterceptor;
    }
}
