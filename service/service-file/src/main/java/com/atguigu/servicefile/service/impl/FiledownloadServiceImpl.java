package com.atguigu.servicefile.service.impl;

import com.atguigu.servicefile.entity.Filedownload;
import com.atguigu.servicefile.mapper.FiledownloadMapper;
import com.atguigu.servicefile.service.FiledownloadService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhu
 * @since 2022-04-22
 */
@Service
public class FiledownloadServiceImpl extends ServiceImpl<FiledownloadMapper, Filedownload> implements FiledownloadService {

    @Override
    public List<Filedownload> fileselectAll() {
        QueryWrapper queryWrapper=new QueryWrapper();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteById(String id) {
        baseMapper.deleteById(id);
    }

    @Override
    public Filedownload queryFileById(String id) {
        return baseMapper.selectById(id);
    }


    @Override
    public Map selectFileByPage(int current, int number) {
        IPage page=new Page(current,number);
        baseMapper.selectPage(page,null);
        long pages=page.getPages();
        List<Filedownload> files = page.getRecords();
        long total=page.getTotal();
        Map map=new HashMap();
        map.put("pages",pages);
        map.put("totalNum",total);
        map.put("files",files);
        return map;
    }
}
