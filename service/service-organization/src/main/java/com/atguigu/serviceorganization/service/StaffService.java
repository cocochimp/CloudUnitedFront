package com.atguigu.serviceorganization.service;

import com.atguigu.serviceorganization.util.QueryResult;

import java.util.List;
import java.util.Map;

public interface StaffService {
    QueryResult queryPageByDepartment(String department, Map<String, Object> params);

    QueryResult queryPageByParty(String party, Map<String, Object> params);

    QueryResult queryPageByNation(Map<String, Object> params);

    QueryResult queryPageByPartyOthers(String partyOthers, Map<String, Object> params);

    QueryResult queryPageByCategory(String category, Map<String, Object> params);

    QueryResult queryPageByOrganization(int page,int limit);

    QueryResult queryPageBySearch(int page,int limit,String name);
}
