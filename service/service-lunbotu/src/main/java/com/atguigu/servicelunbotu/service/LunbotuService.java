package com.atguigu.servicelunbotu.service;

import com.atguigu.servicelunbotu.entity.Lunbotu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhu
 * @since 2022-04-17
 */
public interface LunbotuService extends IService<Lunbotu> {

    List<Lunbotu> listAll();

    String queryFileName(String id);

    void saveLunBoTu(String uuid, String sysTime, String imgUrl, String name, String info, String imgName);

    void deleteById(String id);

    void updateLunBoTu(Lunbotu lunbotu);

    void updateNew(Lunbotu lunBoTu);

    Lunbotu queryLunBoTu(String id);

    /*分页查询*/
    Map selectLunbotuByPage(int current, int number);
}
