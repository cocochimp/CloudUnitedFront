//此模块为决策中心中港澳台的相关api
import axios from "axios"
export async function callAll() {
    let { data: res1 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryAge")
    let { data: res2 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/GangAoTai/querySex")
    let { data: res3 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryDegree")
    let { data: res4 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryDepartment")
    return { res1, res2, res3, res4 }
}

export async function callDepartment(department) {
    let { data: res1 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryAge/${department}`)
    let { data: res2 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/GangAoTai/querySex/${department}`)
    let { data: res3 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryDegree/${department}`)
    let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/GangAoTai/queryDepartment/${department}`)
    return { res1, res2, res3, res4 }
}