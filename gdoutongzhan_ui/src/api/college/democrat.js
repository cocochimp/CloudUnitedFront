//此模块为决策中心中民主党派的相关api
import axios from "axios"
export async function callAll() {
    let { data: res1 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/MemberShip")
    let { data: res2 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryAge")
    let { data: res3 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryDegree")
    let { data: res4 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/IncreaseCount")
    let { data: res5 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/querySex")
    let { data: res6 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryTitle")
    let { data: res7 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/politics")
    let { data: res8 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/DepartmentCount")
    return { res1, res2, res3, res4, res5, res6, res7, res8 }
}

export async function callDepartment(department) {
    let { data: res1 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/MemberShip/${department}`)
    let { data: res2 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryAge/${department}`)
    let { data: res3 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryDegree/${department}`)
    let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/IncreaseCount/${department}`)
    let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/querySex/${department}`)
    let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/MinZuDangPai/queryTitle/${department}`)
    return { res1, res2, res3, res4, res5, res6 }
}