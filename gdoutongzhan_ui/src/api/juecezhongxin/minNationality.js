//这个模块主要获取的是决策中心 少数民族的数据
import request from '@/utils/send';

export const abcde = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryTitle",
    method: 'post'
})
export const abcd = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDegree",
    method: 'post'
})
export const abc = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDepartment",
    method: 'post'
})