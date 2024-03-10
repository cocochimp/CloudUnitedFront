//这个模块主要获取的是组织库 民主党派的数据
import request from '@/utils/send';
//获取基层统战列表接口
//http://localhost:9106/Organization/Party/{party}/{page}/{limit}
export const reqPartyList = (party, page, limit) =>
    request({
        url: `http://localhost:9106/Organization/Party/${party}/${page}/${limit}`,
        method: 'get'
    });


//处理添加信息
//新增对象：http://localhost:9106/Organization/insert  post
export const reqAddParty = (organization) =>
    request({
        url: `http://localhost:9106/Organization/insert`,
        method: `post`,
        data: organization
    })


//删除对象：http://localhost:9106/Organization/delete/{id} get
export const reqDelParty = (id) =>
    request({
        url: `http://localhost:9106/Organization/delete/${id}`,
        method: `get`
    })

//查询对象:http://localhost:9106/Organization/Party/{party}/{name} get
export const reqSearchParty = (party, name, page, limit) =>
    request({
        url: `http://localhost:9106/Organization/Party/${party}/${name}/${page}/${limit}`,
        method: `get`
    })