package com.atguigu.servicelunbotu.service.impl;

import com.atguigu.servicelunbotu.entity.Lunbotu;
import com.atguigu.servicelunbotu.mapper.LunbotuMapper;
import com.atguigu.servicelunbotu.service.LunbotuService;
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
 * @since 2022-04-17
 */
@Service
public class LunbotuServiceImpl extends ServiceImpl<LunbotuMapper, Lunbotu> implements LunbotuService {

    @Override
    public List<Lunbotu> listAll() {
        return baseMapper.selectList(null);
    }

    /*分页查询*/
    @Override
    public Map selectLunbotuByPage(int current, int number) {
        IPage page=new Page(current,number);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("createTime");
        baseMapper.selectPage(page,queryWrapper);
        long pages=page.getPages();
        List<Lunbotu> lunbotus = page.getRecords();
        long total=page.getTotal();
        Map map=new HashMap();
        map.put("pages",pages);
        map.put("totalNum",total);
        map.put("lunbotus",lunbotus);
        return map;
    }

    @Override
    public String queryFileName(String id) {
        Lunbotu lunbotu = baseMapper.selectById(id);
        String imgName=lunbotu.getImgName();
        return imgName;
    }

    @Override
    public void saveLunBoTu(String uuid, String sysTime, String imgUrl, String name, String info, String imgName) {
        Lunbotu lunbotu=new Lunbotu();
        lunbotu.setId(uuid);
        lunbotu.setCreateTime(sysTime);
        lunbotu.setImgUrl(imgUrl);
        lunbotu.setName(name);
        lunbotu.setInfo(info);
        lunbotu.setImgName(imgName);
        baseMapper.insert(lunbotu);
    }

    @Override
    public void deleteById(String id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateLunBoTu(Lunbotu lunbotu) {
        baseMapper.updateById(lunbotu);
    }

    @Override
    public void updateNew(Lunbotu lunBoTu) {
        baseMapper.updateById(lunBoTu);
    }

    @Override
    public Lunbotu queryLunBoTu(String id) {
        return baseMapper.selectById(id);
    }
}
