package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.service.*;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.vo.DepartmentVo;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.atguigu.serviceorganization.vo.PartyVo;
import com.atguigu.serviceorganization.vo.PersonVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PartyService partyService;
    @Autowired
    private OrganizationIdentityService organizationIdentityService;
    @Autowired
    private PartyOthersService partyOthersService;
    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private PersonalInfoService personalInfoService;
    @Autowired
    private NationService nationService;
    @Autowired
    private PoliticalService politicalService;

    @Override
    public QueryResult queryPageByDepartment(String department, Map<String, Object> params) {
        DepartmentEntity departmentEntity = departmentService.getDepartmentIdByName(department);
        PageUtils page= staffInfoService.getAllStaffInfoByDepartmentId(departmentEntity.getDepartmentId(), params);


        List<StaffInfoEntity> staffInfoList = (List<StaffInfoEntity>) page.getList();
        List<DepartmentVo> personVoList=new ArrayList<>();

        staffInfoList.stream().forEach(item->{
            DepartmentVo departmentVo = new DepartmentVo();

            if(StringUtils.isNotEmpty(item.getPartyId())) {
                PartyEntity partyById = partyService.getPartyById(item.getPartyId());
                departmentVo.setParty(partyById.getParty());
            }

            departmentVo.setJoinPartyDate(item.getJoinpartydate());

            PersonalInfoEntity personalInfoById = personalInfoService.getPersonalInfoById(item.getSId());

            departmentVo.setPhone(personalInfoById.getPhone());
            departmentVo.setName(personalInfoById.getName());
            departmentVo.setNativePlace(personalInfoById.getNativeplace());
            departmentVo.setId(item.getSId());
            personVoList.add(departmentVo);
        });
        page.setList(personVoList);
        return new QueryResult(page);
    }


    @Override
    public QueryResult queryPageByParty(String party, Map<String, Object> params) {
        PartyEntity partyEntity = partyService.getPartyByName(party);
        PageUtils page= staffInfoService.getAllStaffInfoByPartyId(partyEntity.getPartyId(), params);
        return getQueryResult(page);
    }

    @Override
    public QueryResult queryPageByNation(Map<String, Object> params) {
        NationEntity hanNation = nationService.getHanNation();
        PageUtils page = personalInfoService.getAllStaffInfoByLessNation(hanNation.getNationId(), params);
        List<PersonalInfoEntity> list = (List<PersonalInfoEntity>)page.getList();
        List<PersonVo> personVoList=new ArrayList<>();

        list.stream().forEach(item->{
            PersonVo personVo = new PersonVo();
            personVo.setPhone(item.getPhone());
            personVo.setName(item.getName());
            personVo.setNativePlace(item.getNativeplace());

            StaffInfoEntity staffInfo = staffInfoService.getStaffInfoByPersonId(item.getId());

            personVo.setJoinPartyDate(staffInfo.getJoinpartydate());

            if(StringUtils.isNotEmpty(staffInfo.getOrganizationId())) {
                OrganizationIdentityEntity identityById = organizationIdentityService.getOrganizationIdentityById(staffInfo.getOrganizationId());
                personVo.setO_identity(identityById.getOIdentity());
            }

            DepartmentEntity departmentIdById = departmentService.getDepartmentIdById(staffInfo.getDepartmentId());
            personVo.setDepartment(departmentIdById.getDepartment());

            String partyId = staffInfo.getPartyId();

            if (partyId!=null) {
                PartyEntity partyById = partyService.getPartyById(partyId);
                personVo.setParty(partyById.getParty());
            }

            personVo.setId(item.getId());
            personVoList.add(personVo);
        });
        page.setList(personVoList);
        return new QueryResult(page);
    }

    @Override
    public QueryResult queryPageByPartyOthers(String partyOthers, Map<String, Object> params) {
        PartyOthersEntity partyOthersEntity= partyOthersService.getPartyOthersByName(partyOthers);
        PageUtils page = staffInfoService.getAllStaffInfoByPartyOthersId(partyOthersEntity.getPId(), params);
        return getQueryResult(page);
    }

    @Override
    public QueryResult queryPageByCategory(String category, Map<String, Object> params) {
        List<PoliticalEntity> politicalEntityList = politicalService.getPoliticalByName(category);
        PageUtils page = staffInfoService.getAllStaffInfoByCategoryId(politicalEntityList, params);

        return getQueryResult(page);
    }

    @Override
    public QueryResult queryPageByOrganization(int page,int limit) {
        List<OrganizationVo> organizationVoList=new ArrayList<>();
        departmentService.getAllDepartmentId(organizationVoList);
        partyService.getAllPartyId(organizationVoList);
        partyOthersService.getAllPartyOthersId(organizationVoList);
        politicalService.getAllPoliticalId(organizationVoList);

        return organizationPage(page, limit, organizationVoList);

    }

    @Override
    public QueryResult queryPageBySearch(int page, int limit,String name) {
        List<OrganizationVo> organizationVoList=new ArrayList<>();
        departmentService.getAllDepartmentIdByName(organizationVoList,name);
        partyService.getAllPartyIdByName(organizationVoList,name);
        partyOthersService.getAllPartyOthersIdByName(organizationVoList,name);
        politicalService.getAllPoliticalIdByName(organizationVoList,name);

        return organizationPage(page, limit, organizationVoList);
    }

    private QueryResult organizationPage(int page, int limit, List<OrganizationVo> organizationVoList) {
        //分页
        int total = organizationVoList.size();
        //总页数
        int pageSum = total % limit == 0 ? total / limit : total / limit + 1;

        //分页
        List<OrganizationVo> subList = organizationVoList.stream().skip((long) (page - 1) * limit).limit(limit).
                collect(Collectors.toList());

        List<OrganizationVo> info=new ArrayList<>();
        subList.stream().forEach(vo->{
            staffInfoService.getStaffInfoCount(vo);
            info.add(vo);
        });


        PageUtils pageUtils = new PageUtils(info,total, limit, page);
        return new QueryResult(pageUtils);
    }

    private QueryResult getQueryResult(PageUtils page) {
        List<StaffInfoEntity> staffInfoList = (List<StaffInfoEntity>) page.getList();
        List<PartyVo> personVoList = new ArrayList<>();

        if (staffInfoList != null) {
            staffInfoList.stream().forEach(item -> {
                PartyVo partyVo = new PartyVo();

                if (StringUtils.isNotEmpty(item.getDepartmentId())) {
                    DepartmentEntity departmentIdById = departmentService.getDepartmentIdById(item.getDepartmentId());
                    partyVo.setDepartment(departmentIdById.getDepartment());
                }
                partyVo.setJoinPartyDate(item.getJoinpartydate());

                PersonalInfoEntity personalInfoById = personalInfoService.getPersonalInfoById(item.getSId());

                partyVo.setPhone(personalInfoById.getPhone());
                partyVo.setName(personalInfoById.getName());
                partyVo.setNativePlace(personalInfoById.getNativeplace());
                partyVo.setId(item.getSId());
                personVoList.add(partyVo);
            });
        }
            page.setList(personVoList);
            return new QueryResult(page);
        }


}
