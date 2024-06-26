package com.atguigu.servicedecisioncenter.service.impl;

import com.atguigu.servicedecisioncenter.entity.Person;
import com.atguigu.servicedecisioncenter.mapper.PortraitMapper;
import com.atguigu.servicedecisioncenter.service.PortraitService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PortrainServiceImpl implements PortraitService {

    @Autowired
    private PortraitMapper portraitMapper;

    /*人物画像-人物信息*/
    @Override
    public Map<String, Object> selectPeopleById(String id) {
        /*人物头像*/
        String imgUrl=portraitMapper.queryImgUrl(id);
        /*姓名*/
        String name = portraitMapper.queryName(id);
        /*生日*/
        String birth = portraitMapper.queryBirth(id);
        /*性别*/
        String sex = portraitMapper.querySex(id);
        /*民族*/
        String nation = portraitMapper.queryNation(id);
        /*籍贯*/
        String naticePlace = portraitMapper.queryNaticePlace(id);
        /*岗位职务*/
        String title = portraitMapper.queryTitle(id);
        /*政治面貌*/
        String party = portraitMapper.queryParty(id);
        /*党派职务（无）*/
        String partyPosition=null;
        /*社会职务（无）*/
        String socialPosition=null;
        /*培训次数（无）*/
        Integer trainingTimes=0;
        /*参政议政次数（无）*/
        Integer politicalParticipationTimes=0;
        /*获奖次数*/
        Integer priceTimes=portraitMapper.countPriceNumber(id);
        /*任职轴*/
        String  positionAxis=portraitMapper.queryPositionAxis(id);
        /*活动轴*/
        String  activeAxis=portraitMapper.queryActiveAxis(id);
        /*获奖轴*/
        String  awardAxis=portraitMapper.queryAwardAxis(id);

        Map map=new HashMap();
        map.put("imgUrl",imgUrl);
        map.put("name",name);
        map.put("birth",birth);
        map.put("sex",sex);
        map.put("nation",nation);
        map.put("naticePlace",naticePlace);
        map.put("title",title);
        if (party==null){
            party="无党派";
        }
        map.put("party",party);
        map.put("partyPosition",partyPosition);
        map.put("socialPosition",socialPosition);
        map.put("trainingTimes",trainingTimes);
        map.put("politicalParticipationTimes",politicalParticipationTimes);
        map.put("priceNumber",priceTimes);
        map.put("positionAxis",positionAxis);
        map.put("activeAxis",activeAxis);
        map.put("awardAxis",awardAxis);
        return map;
    }

    /*民主党派*/
    @Override
    public List<Person> queryDemocraticParties() {
        List<Person> people = portraitMapper.queryDemocraticParties();
        return people;
    }

    /*非党派*/
    @Override
    public List<Person> queryNonPartisan() {
        List<Person> people=portraitMapper.queryNonPartisan();
        return people;
    }

    /*根据姓名查询*/
    @Override
    public List<Person> queryByName(String name) {
        List<Person> people = portraitMapper.queryByName(name);
        return people;
    }

    /*根据姓名模糊查询*/
    @Override
    public List<Person> fuzzyQueryByName(String name) {
        List<Person> person = portraitMapper.fuzzyQueryByName(name);
        return person;
    }
}
