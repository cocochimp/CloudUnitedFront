package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Fulltimedegree;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface FullTimeDegreeService extends IService<Fulltimedegree> {
    List<Fulltimedegree> queryAllFullTimeDegree();

    void addFullTimeDegree(Fulltimedegree fulltimedegree);

    void deleteFullTimeDegree(String fulltimedegree_id);

    void updateFullTimeDegree(Fulltimedegree fulltimedegree);
}
