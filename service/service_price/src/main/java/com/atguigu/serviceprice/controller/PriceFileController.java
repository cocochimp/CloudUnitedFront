package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.controller.ex.FileIOUploadException;
import com.atguigu.serviceprice.entity.PriceFile;
import com.atguigu.serviceprice.service.IPriceFileService;
import com.atguigu.serviceprice.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/servicefile/Pricefiles")
public class PriceFileController extends BaseController {
    @Autowired
    private IPriceFileService priceFileService;


    //下载专区
    @PostMapping(value = "/priceFile/insertfile")
    public JsonResult upload(@RequestParam(value = "pid",required = false) String pid, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()||multipartFile==null){
            System.out.println("文件没有上传");
            throw new FileIOUploadException("文件为空");
        }
        String filename=multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        File file=new File("service\\service_price\\src\\main\\resources\\static\\"+multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        PriceFile priceFile=new PriceFile();
        priceFile.setFName(filename);
        String fileAdd="http://localhost:9108/fileUpload/"+multipartFile.getOriginalFilename();
        priceFile.setFPath(fileAdd);

        if (pid!=null){
            priceFile.setPid(pid);
        }
        priceFileService.insertPriceFile(priceFile);

        return new JsonResult<>(OK);
    }

}
