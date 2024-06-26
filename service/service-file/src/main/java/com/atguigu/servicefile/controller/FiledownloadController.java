package com.atguigu.servicefile.controller;


import com.atguigu.servicefile.entity.Filedownload;
import com.atguigu.servicefile.entity.ResultVo;
import com.atguigu.servicefile.service.FiledownloadService;
import com.atguigu.servicefile.util.DateTimeUtil;
import com.atguigu.servicefile.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhu
 * @since 2022-04-22
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/servicefile/filedownload")
@Api(tags = "文件下载专区")
public class FiledownloadController {


    @Autowired
    FiledownloadService filedownloadService;

    /*
    下载专区
    txt文件里面有中文会乱码
     */
    @PostMapping(value = "/file/upload")
    @ApiOperation(value = "文件上传")
    public ResultVo upload(@RequestParam("name")String filename,@RequestParam("file") MultipartFile multipartFile) throws IOException {
        ResultVo resultVo = new ResultVo();
        if (filename==null||"".equals(filename)){
            filename=multipartFile.getOriginalFilename();
        }
        InputStream inputStream = multipartFile.getInputStream();
        File file=new File("service\\service-file\\src\\main\\resources\\static\\"+multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024 * 8];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        Filedownload filedownload = new Filedownload();
        filedownload.setId(UUIDUtil.getUUID());
        filedownload.setTitle(filename);
        filedownload.setPath("http://localhost:9104/file/"+multipartFile.getOriginalFilename());
        filedownload.setReleaseTime(DateTimeUtil.getDate());
        filedownload.setFileName(multipartFile.getOriginalFilename());
        filedownloadService.save(filedownload);
        return resultVo;
    }

    /*分页查询*/
    @GetMapping(value = "/file/fileSelectByPage")
    @ApiOperation(value = "文件分页查询")
    public ResultVo selectFileByPage(int current,int number){
        Map map=filedownloadService.selectFileByPage(current, number);
        ResultVo resultVo=new ResultVo();
        resultVo.setT(map);
        resultVo.setMess("分页查询文件成功");
        resultVo.setOk(true);
        return resultVo;
    }



    //查询所有文件
    @GetMapping(value = "/file/fileselectAll")
    @ApiOperation(value = "所有文件查询")
    public List<Filedownload> selectAll(){
        ResultVo resultVo = new ResultVo();
        List<Filedownload> list=filedownloadService.fileselectAll();
        resultVo.setT(list);
        return list;
    }

    @PostMapping("/file/deleteById")
    @ApiOperation(value = "按id删除文件")
    public ResultVo deleteById(String id){
        Filedownload filedownload = filedownloadService.queryFileById(id);
        String fileName=filedownload.getFileName();
        String url = "service\\service-file\\src\\main\\resources\\static\\" + fileName;
        File file = new File(url);
        file.delete();
        ResultVo resultVo = new ResultVo();
        filedownloadService.deleteById(id);
        return resultVo;
    }


}

