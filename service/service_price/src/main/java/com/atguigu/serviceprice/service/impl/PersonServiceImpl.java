package com.atguigu.serviceprice.service.impl;

import com.atguigu.serviceprice.entity.Person;
import com.atguigu.serviceprice.entity.Price;
import com.atguigu.serviceprice.mapper.PersonMapper;
import com.atguigu.serviceprice.service.IPersonService;
import com.atguigu.serviceprice.service.IPriceService;
import com.atguigu.serviceprice.service.ex.PageSelectException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    public static String PRICE_UUID;


    /*分页查询*/
    @Override
    public Map selectPerson(int current, int number) {
        IPage page=new Page(current,number);
        personMapper.selectPage(page,null);
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

    /*查询全部*/
    @Override
    public List<Person> selectList() {
        List<Person> list = personMapper.selectList(null);
        return list;
    }

    /*根据姓名查询*/
    @Override
    public List<Person> selectByName(String name) {
        List<Person> people = personMapper.selectByName(name);
        List<Person> selectPeople=new LinkedList<>();

        //如果在数据库中查找不到数据
        if (people.size()==0){
            //就用uuid为连接获奖文件
            PRICE_UUID= java.util.UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
            Person person=new Person();
            person.setId(PRICE_UUID);
            selectPeople.add(person);
            return selectPeople;
        }
        for (Person p:people) {
            Person person=new Person();
            person.setId(p.getId());
            person.setName(p.getName());
            person.setPhone(p.getPhone());
            selectPeople.add(person);
        }
        return selectPeople;
    }
}
