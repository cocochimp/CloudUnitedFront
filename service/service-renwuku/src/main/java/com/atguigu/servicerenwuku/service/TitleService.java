package com.atguigu.servicerenwuku.service;

import com.atguigu.servicerenwuku.entity.Title;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TitleService extends IService<Title> {
    List<Title> queryAllTitle();

    void addTitle(Title title);

    void deleteTitle(String title_id);

    void updateTitle(Title title);
}
