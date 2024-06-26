package com.atguigu.servicefile.service;

import com.atguigu.servicefile.entity.Filedownload;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhu
 * @since 2022-04-22
 */
public interface FiledownloadService extends IService<Filedownload> {


    List<Filedownload> fileselectAll();

    void deleteById(String id);

    Filedownload queryFileById(String id);

    /*分页查询*/
    Map selectFileByPage(int current, int number);
}
