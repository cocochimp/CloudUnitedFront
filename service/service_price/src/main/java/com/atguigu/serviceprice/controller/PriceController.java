package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.controller.ex.FileIOUploadException;
import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.entity.priceAndFile;
import com.atguigu.serviceprice.service.IPriceService;
import com.atguigu.serviceprice.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/servicefile/prices")
public class PriceController extends BaseController {
    @Autowired
    private IPriceService priceService;

    /*根据id查询*/
    @GetMapping("/price/selectById")
    public JsonResult<priceAndFile> selectById(@RequestParam("pid") String pid){
        priceAndFile price = priceService.selectById(pid);
        return new JsonResult<>(OK,price);
    }

    /*添加*/
    @PostMapping("/price/save")
    public JsonResult<Void> save(Price price) {
        //获奖人、获奖名称、文件路径、上传人
        Price p=new Price();
        p.setId(price.getId());
        p.setName(price.getName());
        p.setPPriceName(price.getPPriceName());
        p.setPLevel(price.getPLevel());
        priceService.insertPrice(p);
        return new JsonResult<>(OK);
    }


    /*删除*/
    @RequestMapping("/price/delete")
    public JsonResult<Void> delete(@RequestParam("pid") String pid){
        priceService.deletePrice(pid);
        return new JsonResult<>(OK);
    }


    @PostMapping("/price/update")
    public JsonResult<Void> update(Price price){
        //获奖人、获奖名称、文件路径、上传人
        Price p=new Price();
        p.setId(price.getId());
        if (price.getName()!=null){
            p.setName(price.getName());
        }
        if (price.getId()!=null){
            p.setId(price.getId());
        }
        if (price.getPPriceName()!=null){
            p.setPPriceName(price.getPPriceName());
        }
        if (price.getPLevel()!=null){
            p.setPLevel(price.getPLevel());
        }
        priceService.updatePrice(p);
        return new JsonResult<>(OK);
    }



    /*分页查询*/
    @RequestMapping("/price/selectByPage")
    public JsonResult<Map> selectByPage(int current,int number){
        Map map = priceService.selectPrice(current, number);
        return new JsonResult<>(OK,map);
    }


    /*根据姓名或获奖名称查询*/
    @RequestMapping("/price/selectByNameOrPriceName")
    public JsonResult<Map> selectByNameOrPriceName(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "priceName",required = false) String pPriceName,long current,long number){
        Map map = priceService.selectByNameOrPrice(name, pPriceName, current, number);
        return new JsonResult<>(OK,map);

    }


}
