package com.atguigu.serviceprice.service.impl;

import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.entity.PriceFile;
import com.atguigu.serviceprice.entity.priceAndFile;
import com.atguigu.serviceprice.mapper.PriceFileMapper;
import com.atguigu.serviceprice.mapper.PriceMapper;
import com.atguigu.serviceprice.service.IPriceFileService;
import com.atguigu.serviceprice.service.IPriceService;
import com.atguigu.serviceprice.service.ex.DeleteException;
import com.atguigu.serviceprice.service.ex.InsertException;
import com.atguigu.serviceprice.service.ex.PageSelectException;
import com.atguigu.serviceprice.service.ex.UpdateException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.atguigu.serviceprice.service.impl.PersonServiceImpl.PRICE_UUID;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private PriceMapper priceMapper;

    @Resource
    private IPriceFileService priceFileService;

    @Resource
    private PriceFileMapper priceFileMapper;

    /*根据id查询*/
    @Override
    public priceAndFile selectById(String pid) {
        Price price = priceMapper.selectById(pid);
        String id = price.getId();

        LambdaQueryWrapper<PriceFile> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PriceFile::getPid,id);
        List<PriceFile> list = priceFileMapper.selectList(queryWrapper);

        priceAndFile priceAndFile = new priceAndFile();
        priceAndFile.setName(price.getName());
        priceAndFile.setPPriceName(price.getPPriceName());
        priceAndFile.setPLevel(price.getPLevel());
        priceAndFile.setPid(price.getPid());
        priceAndFile.setPriceFile(list);

        return priceAndFile;
    }

    /*新增获奖信息*/
    @Override
    public void insertPrice(Price price) {
        /*
         * price: 获奖人（id），获奖名称，文件，当前用户（uid）
         * 1. 填写信息
         * 2. 选择获奖人
         * 3. 上传文件
         * 4. 获取时间
         * 5. 调用插入
         * */
        price.setPUploadTime(new Date());
        price.setPModifiedTime(new Date());

        price.setId(PRICE_UUID);

        int rows = priceMapper.insert(price);

        if (rows!=1){
            throw new InsertException("保存获奖信息时产生未知异常");
        }
    }

    /*删除获奖信息*/
    @Override
    public void deletePrice(String pid) {
        int rows = priceMapper.deleteById(pid);
        if (rows!=1){
            throw new DeleteException("删除获奖信息时出现未知异常");
        }
    }

    /*修改获奖信息*/
    @Override
    public void updatePrice(Price price){
        price.setPModifiedTime(new Date());
        int rows = priceMapper.updateById(price);
        if (rows!=1){
            throw new UpdateException("更新获奖信息时出现未知异常");
        }
    }

    /*获奖信息分页查询*/
    @Override
    public Map selectPrice(int current, int number) {
        IPage page=new Page(current,number);
        priceMapper.selectPage(page,null);
        long pages = page.getPages(); //总页数
        if (number<0){
            throw new PageSelectException("查询条数应该大于0");
        }
        if (current>pages){
            throw new PageSelectException("查询页超出总页数");
        }
        long total = page.getTotal(); //总条数
        List<Price> list = page.getRecords();

        Map map=new HashMap();
        map.put("page",pages);
        map.put("total",total);
        map.put("prices",list);
        return map;
    }

    /*根据姓名查询*/
    @Override
    public List<Price> selectByName(String name) {
        List<Price> prices = priceMapper.selectByName(name);
        return prices;
    }

    /*根据获奖名称查询*/
    @Override
    public List<Price> selectByPriceName(String pPriceName) {
        List<Price> prices = priceMapper.selectByPriceName(pPriceName);
        return prices;
    }

    /*根据获奖名称和姓名查询*/
    @Override
    public List<Price> selectByPriceAndName(String name, String pPriceName) {
        List<Price> prices = priceMapper.selectByPriceAndName(name, pPriceName);
        return prices;
    }

    /*按照姓名或获奖信息分页查询*/
    @Override
    public Map selectByNameOrPrice(String name, String price, long current, long number) {
        IPage page=new Page(current,number);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (name!=null){
            queryWrapper.like("name",name);
        }
        if (price!=null){
            queryWrapper.like("p_priceName",price);
        }
        queryWrapper.orderByDesc("p_modifiedTime");
        priceMapper.selectPage(page,queryWrapper);
        long pages=page.getPages();
        List<Price> prices=page.getRecords();
        long total=page.getTotal();
        Map map=new HashMap();
        map.put("page",pages);
        map.put("total",total);
        map.put("prices",prices);
        return map;
    }
}
