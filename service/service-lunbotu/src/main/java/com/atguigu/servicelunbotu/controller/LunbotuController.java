package com.atguigu.servicelunbotu.controller;


import com.atguigu.servicelunbotu.Feign.TestFeign;
import com.atguigu.servicelunbotu.entity.FileData;
import com.atguigu.servicelunbotu.entity.Lunbotu;
import com.atguigu.servicelunbotu.entity.ResultVo;
import com.atguigu.servicelunbotu.exception.AllException;
import com.atguigu.servicelunbotu.service.LunbotuService;
import com.atguigu.servicelunbotu.util.DateTimeUtil;
import com.atguigu.servicelunbotu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/lunbotuservice/lunbotu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LunbotuController {
    @Autowired
    LunbotuService lunbotuService;

   /* @Autowired
    TestFeign feign;

    @RequestMapping("/hello")
    public void hello(){
        ResultVo resultVo = feign.queryAllArticles();
        System.out.println(resultVo.getT());
    }*/

    /*分页*/
    @GetMapping("/lunbotu/selectByPage")
    public ResultVo selectByPage(int current,int number){
        Map map=lunbotuService.selectLunbotuByPage(current, number);
        ResultVo resultVo=new ResultVo();
        resultVo.setT(map);
        resultVo.setMess("分页查询轮播图成功");
        resultVo.setOk(true);
        return resultVo;

    }

    //展示图片，先前端传图片地址
    @GetMapping("/lunBoTu/list")
    public ResultVo list() {
        ResultVo resultVo = new ResultVo();
        List<Lunbotu> list = new ArrayList<>();
        try {
            list = lunbotuService.listAll();
            resultVo.setT(list);
            resultVo.setMess("展示轮播图成功");
            resultVo.setOk(true);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }

        return resultVo;
    }


    //删除轮播图
    @PostMapping(value = "/lunBoTu/delete")
    public void delete(String id) {
        String imgName = lunbotuService.queryFileName(id);
        String fileName = "service\\service-lunbotu\\src\\main\\resources\\static\\image\\" + imgName;
        File file = new File(fileName);
        file.delete();
        lunbotuService.deleteById(id);
    }


    //轮播图的添加上传
    @PostMapping(value = "/lunBoTu/upload")
    public ResultVo upload(@RequestParam("file") MultipartFile multipartFile, FileData fileData) throws IOException{
        ResultVo resultVo = new ResultVo();
        InputStream inputStream = multipartFile.getInputStream();
        File file=new File("service\\service-lunbotu\\src\\main\\resources\\static\\image\\"+multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        String imgUrl="http://localhost:9103/lunbotu/"+multipartFile.getOriginalFilename();
        String imgName=multipartFile.getOriginalFilename();
        try {
            lunbotuService.saveLunBoTu(UUIDUtil.getUUID(),DateTimeUtil.getSysTime(),imgUrl, fileData.getName(), fileData.getInfo(), imgName);
        } catch (AllException e) {
            resultVo.setMess(e.getMessage());
        }
        return resultVo;
    }


    //修改轮播图
    @PostMapping(value = "/lunBoTu/update")
    public ResultVo update(@RequestParam("file") MultipartFile multipartFile, FileData fileData) {
        ResultVo resultVo = new ResultVo();
        String id,imgUrl, imgName,name,info;
        // replaceAll 用来替换windows中的\\ 为 /
        if (multipartFile.getSize()==0) {
            Lunbotu lunbotu=lunbotuService.queryLunBoTu(fileData.getId());
            lunbotu.setName(fileData.getName());
            lunbotu.setInfo(fileData.getInfo());
            try {
                lunbotuService.updateLunBoTu(lunbotu);
            } catch (AllException e) {
                resultVo.setMess(e.getMessage());
            }
        }else{
            imgUrl = "http://localhost:9103/lunbotu/"+multipartFile.getOriginalFilename();
            imgName = multipartFile.getOriginalFilename();
            String createTime = DateTimeUtil.getSysTime();
            String fileName = "service\\service_lunbotu\\src\\main\\resources\\static\\image\\" + fileData.getImgName();
            File file = new File(fileName);
            Lunbotu lunBoTu = new Lunbotu();
            lunBoTu.setId(fileData.getId());
            lunBoTu.setCreateTime(createTime);
            lunBoTu.setImgUrl(imgUrl);
            lunBoTu.setName(fileData.getName());
            lunBoTu.setInfo(fileData.getInfo());
            lunBoTu.setImgName(imgName);
            try {
                lunbotuService.updateNew(lunBoTu);
                file.delete();
                System.out.println("ok");
            } catch (AllException e) {
                resultVo.setMess(e.getMessage());
            }
        }

        return resultVo;
    }


}

