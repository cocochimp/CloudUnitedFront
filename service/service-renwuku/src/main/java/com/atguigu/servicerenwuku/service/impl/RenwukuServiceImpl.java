package com.atguigu.servicerenwuku.service.impl;


import com.atguigu.servicerenwuku.entity.*;
import com.atguigu.servicerenwuku.mapper.RenwukuMapper;
import com.atguigu.servicerenwuku.service.RenwukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenwukuServiceImpl implements RenwukuService {

    @Autowired
    RenwukuMapper mapper;

    //查询所有人物库成员
    @Override
    public List<PersonVo> queryallpeople() {

        return mapper.queryallpeople();
    }

    //添加人物库dangpai_personal_info信息
    @Override
    public void addPeopletoPersonal(Person_personal person_personal) {
        mapper.addPeopletoPersonal(person_personal);
    }

    @Override
    public void addPeopletoStaff(Person_staff person_staff) {
        mapper.addPeopletoStaff(person_staff);
    }

    @Override
    public void deletePeople(String id) {
        mapper.deletePeople(id);
    }

    @Override
    public void updatePeopletoPersonal(Person_personal Person_personal) {
        mapper.updatePeopletoPersonal(Person_personal);
    }

    @Override
    public void updatePeopletoStaff(Person_staff person_staff) {
        mapper.updatePeopletoStaff(person_staff);
    }

    @Override
    public List<PersonVo> queryPeopleByCondition(String name, String partyId, String departmentId, String otherPartyId) {
        return mapper.queryPeopleByCondition(name, partyId, departmentId, otherPartyId);
    }



}
