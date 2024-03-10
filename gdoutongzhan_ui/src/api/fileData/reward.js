//这个模块是奖励组件的模块 用于获取数据
import request from "@/utils/send"
//获取展示数据
export const reqRewardData = ({ current, number }) => request({
    url: "http://localhost:9108/servicefile/prices/price/selectByPage",
    params: {
        current,
        number,
    },
    method: "post"
})

//通过姓名获取用户id信息(修改奖励参数)
export const reqPersonId = (name) => request({
    url: "http://localhost:9108/servicePerson/pricePersons/person/selectByName",
    params: {
        name
    },
    method: "post"
})

//通过id获取当前奖励信息，展示便于用户的修改
export const reqRewardId = (pid) => request({
    url: "http://localhost:9108/servicefile/prices/price/selectById",
    params: { pid },
    method: "get"
})

//上传奖励信息
export const reqRewardAddMsg = ({ id, name, pPriceName, pLevel }) => request({
    url: "http://localhost:9108/servicefile/prices/price/save",
    params: {
        id,
        name,
        pPriceName,
        pLevel
    },
    method: "post"
})

//修改奖励信息
export const reqRewardUpdataMsg = ({ id, name, pPriceName, pid, pLevel }) => request({
    url: "http://localhost:9108/servicefile/prices/price/update",
    params: {
        id,
        name,
        pid,
        pPriceName,
        pLevel
    },
    method: "post"
})

//添加获奖文件 pid为用户人的id
export const reqRewardFile = (fd) => request({
    url: "http://localhost:9108/servicefile/Pricefiles/priceFile/insertfile",
    data: fd,
    method: "post"
})

//删除奖励信息
export const reqRewardRemove = (pid) => request({
    url: "http://localhost:9108/servicefile/prices/price/delete",
    params: {
        pid
    },
    method: "post"
})

//查询奖励信息
export const reqRewardSearch = (searchMsg, p) => request({
    url: "http://localhost:9108/servicefile/prices/price/selectByNameOrPriceName",
    params: {
        name: searchMsg.searchPerson,
        priceName: searchMsg.searchReward,
        current: p.current,
        number: p.number
    },
    method: "post"
})