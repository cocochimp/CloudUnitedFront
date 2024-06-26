package com.atguigu.serviceprice.service.impl;

import com.atguigu.serviceprice.entity.PriceFile;
import com.atguigu.serviceprice.mapper.PriceFileMapper;
import com.atguigu.serviceprice.service.IPriceFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PriceFileImpl implements IPriceFileService {

    @Autowired
    private PriceFileMapper priceFileMapper;

    @Override
    public void insertPriceFile(PriceFile priceFile) {
        priceFile.setCreateTime(new Date());
        priceFile.setModifiedTime(new Date());
        priceFileMapper.insert(priceFile);
    }
}
