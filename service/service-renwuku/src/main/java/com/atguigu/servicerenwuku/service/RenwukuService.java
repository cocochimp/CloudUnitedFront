package com.atguigu.servicerenwuku.service;



import com.atguigu.servicerenwuku.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface RenwukuService  {

    List<PersonVo> queryallpeople();

    void addPeopletoPersonal(Person_personal Person_personal);

    void addPeopletoStaff(Person_staff person_staff);

    void deletePeople(String id);

    void updatePeopletoPersonal(Person_personal Person_personal);

    void updatePeopletoStaff(Person_staff person_staff);


    List<PersonVo> queryPeopleByCondition(String name, String partyId,String departmentId,String otherPartyId);


}
