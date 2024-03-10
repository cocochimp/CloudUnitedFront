//此模块为决策中心中民主党派的相关apo
import axios from "axios"

export async function callDepartment(department) {
    var sort = window.sessionStorage.getItem("sort")
    if (sort == "留学归国人员") {
        // console.log(sort);
        let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegreeOfAboard/${department}`)
        let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySexOfAboard/${department}`)
        let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAgeOfAboard/${department}`)
        let { data: res7 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitleOfAboard/${department}`)
        let { data: res8 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex//%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res9 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge//%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res10 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree//%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res11 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle//%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res13 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTimeOfAboardByDepartment/${department}`)

        return { res4, res5, res6, res7, res8, res9, res10, res11, res13 }
    } else {
        let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree/%E6%97%A0%E5%85%9A%E6%B4%BE%E4%BA%BA%E5%A3%AB/${department}`)
        let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex/%E6%97%A0%E5%85%9A%E6%B4%BE%E4%BA%BA%E5%A3%AB/${department}`)
        let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge/%E6%97%A0%E5%85%9A%E6%B4%BE%E4%BA%BA%E5%A3%AB/${department}`)
        let { data: res7 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle/%E6%97%A0%E5%85%9A%E6%B4%BE%E4%BA%BA%E5%A3%AB/${department}`)
        let { data: res8 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/querySex/%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res9 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryAge/%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res10 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryDegree/%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res11 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTitle/%E7%9F%A5%E8%81%94%E4%BC%9A/${department}`)
        let { data: res13 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/WuDangPaiRenYuan/queryTimeOfAboardByDepartment/${department}`)

        return { res4, res5, res6, res7, res8, res9, res10, res11, res13 }
    }

}