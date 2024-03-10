//此模块为决策中心中民主党派的相关apo
import axios from "axios"

export async function callDepartment(department) {
    let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryDegree/${department}`)
    let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/querySex/${department}`)
    let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryNational/${department}`)
    let { data: res8 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryTitle/${department}`)
    let { data: res0 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ShaoShuMinZu/queryCountOfTeacherByDepartment/${department}`)
    return { res4, res5, res6, res8, res0 }
}