//此模块主要是获取决策中心 人物画像模块的数据
import request from '@/utils/send';

//获取民主党派的人物信息和id
export const getDemocraticParties = () => request({
    url: `http://localhost:9107/service/servicedecisioncenter/portrain/queryDemocraticParties`,
    methods: "post"
})

//获取无党派人士的人物信息和id
export const getNonPartisan = () => request({
    url: `http://localhost:9107/service/servicedecisioncenter/portrain/queryNonPartisan`,
    methods: "post"
})


//通过id查询人物信息
export const getInformation = (id) => request({
    url: `http://localhost:9107/service/servicedecisioncenter/portrain/queryPeopleInfoByid`,
    methods: "post",
    params: {
        id
    }
})