package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.entity.AchievementArticle;
import com.atguigu.serviceprice.entity.AchievementOfPhotoVo;
import com.atguigu.serviceprice.entity.ResultVo;
import com.atguigu.serviceprice.entity.AchievementOfPhoto;
import com.atguigu.serviceprice.service.AchievementOfPhotoService;
import com.atguigu.serviceprice.util.DateTimeUtil;
import com.atguigu.serviceprice.util.IdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/servicefile/AchievementOfPhoto")
@Api(tags = "图片管理")
public class AchievementOfPhotoController {
    @Autowired
    AchievementOfPhotoService service;



    //展示图片，先前端传图片地址
    @ApiOperation("展示图片")
    @GetMapping("/list")
    public ResultVo list(int page,int size) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> map=new HashMap<>();
        List<AchievementOfPhotoVo> list = new ArrayList<>();
        Integer total;
        try {
            total=service.queryTotalOfPhoto();
            list = service.listAll(page,size);
            map.put("list",list);
            map.put("total",total);
            resultVo.setT(map);
            resultVo.setMess("展示科技成功图片成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }

        return resultVo;
    }


    //删除轮播图
    @ApiOperation("删除图片")
    @PostMapping(value = "/delete")
    public ResultVo delete(String id,String imgName) {
        ResultVo resultVo=new ResultVo();
        try{
            String fileName = "service\\service_price\\src\\main\\resources\\static\\image\\" + imgName;
            File file = new File(fileName);
            file.delete();
            service.deleteById(id);
            resultVo.setMess("查询成功");
        }catch (Exception e){
            e.printStackTrace();
        }
       return resultVo;
    }


    //图片的添加上传
    @ApiOperation("上传图片")
    @PostMapping(value = "/upload")
    public ResultVo upload(@RequestParam("file") MultipartFile multipartFile, AchievementOfPhoto achievementOfPhoto) throws IOException {
        ResultVo resultVo = new ResultVo();
        IdWorker idWorker = new IdWorker(1, 1);
        String id = String.valueOf(idWorker.nextId());
        InputStream inputStream = multipartFile.getInputStream();
        File file=new File("service\\service_price\\src\\main\\resources\\static\\image\\"+multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        String imgUrl="http://localhost:9108/AchievementOfPhoto/"+multipartFile.getOriginalFilename();
        String imgName=multipartFile.getOriginalFilename();
        achievementOfPhoto.setId(id);
        achievementOfPhoto.setCreateTime(DateTimeUtil.getDate());
        achievementOfPhoto.setUpdateTime(DateTimeUtil.getDate());
        achievementOfPhoto.setImgUrl(imgUrl);
        achievementOfPhoto.setImgName(imgName);
        try {
            service.savePhoto(achievementOfPhoto);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
            e.printStackTrace();
        }
        return resultVo;
    }


    //修改图片信息
    @ApiOperation("修改图片信息")
    @PostMapping(value = "/update")
    public ResultVo update(AchievementOfPhoto achievementOfPhoto) {
        ResultVo resultVo = new ResultVo();
        try{
            achievementOfPhoto.setUpdateTime(DateTimeUtil.getDate());
            service.updatePhoto(achievementOfPhoto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultVo;
    }


    @ApiOperation("查询图片类别")
    @PostMapping("/queryPhotoType")
    public ResultVo queryPhotoType() {
        ResultVo resultVo = new ResultVo();
        List<Map<String, String>> list;
        try {
            list=service.queryPhotoType();
            resultVo.setT(list);
        } catch (Exception e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation("分类查询图片")
    @PostMapping("/queryPhotoByType")
    public ResultVo queryPhotoByType(String typeId,int page,int size) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> map=new HashMap<>();
        List<AchievementOfPhotoVo> photoList = service.queryPhotoByType(typeId,page,size);
        Integer total=service.queryPhotoTotalByType(typeId);
        map.put("list",photoList);
        map.put("total",total);
        resultVo.setT(map);
        resultVo.setMess("查询所有文章成功");
        System.out.println("ok");
        resultVo.setOk(true);
        System.out.println();
        return resultVo;
    }
}