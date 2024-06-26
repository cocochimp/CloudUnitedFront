package com.atguigu.servicelunbotu.Feign;

import com.atguigu.servicelunbotu.entity.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("service-article")
public interface TestFeign {
    @GetMapping("/servicearticle/article/article/queryAllArticles")
    ResultVo queryAllArticles();
}
