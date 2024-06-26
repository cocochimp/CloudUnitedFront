package com.atguigu.servicerenwuku.service.impl;

import com.atguigu.servicerenwuku.entity.Title;
import com.atguigu.servicerenwuku.mapper.TitleMapper;
import com.atguigu.servicerenwuku.service.TitleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TitleServiceImpl extends ServiceImpl<TitleMapper,Title> implements TitleService {
    @Override
    public List<Title> queryAllTitle() {
        return baseMapper.selectList(null);
    }

    @Override
    public void addTitle(Title title) {
        baseMapper.insert(title);
    }

    @Override
    public void deleteTitle(String title_id) {
        baseMapper.deleteById(title_id);
    }

    @Override
    public void updateTitle(Title title) {
        baseMapper.updateById(title);
    }


}
