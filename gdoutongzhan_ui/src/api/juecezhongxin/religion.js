//这个模块主要获取的是决策中心 宗教的数据
import request from '@/utils/send';


export const echart4 = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ZongJiao/queryAge",
    method: 'post'
});
export const echart5 = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ZongJiao/querySex",
    method: 'post'
});
export const echart6 = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ZongJiao/queryReligion",
    method: 'post'
});
export const echart7 = () => request({
    url: "http://localhost:9107/service/servicedecisioncenter/ZongJiao/queryDepartment",
    method: 'post'
});