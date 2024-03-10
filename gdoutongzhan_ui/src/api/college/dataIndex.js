//此模块为决策中心中首页的相关api
import axios from "axios"
export async function callAll() {
    let { data: res1 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/WorkObject")
    let { data: res2 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/NonPartyCadres")
    let { data: res3 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/MemberShip")
    let { data: res4 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/wuDangPai")
    let { data: res5 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/queryNational")
    let { data: res6 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/queryGangAoTai")
    let { data: res7 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/liangDaiBiao")
    let { data: res8 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/queryAward")
    let { data: res9 } = await axios.post("http://localhost:9107/service/servicedecisioncenter/FrontPage/politics")
    return { res1, res2, res3, res4, res5, res6, res7, res8,res9 }
}

export async function callDepartment(department) {
    let { data: res1 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/WorkObject/${department}`)
    let { data: res2 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/NonPartyCadres/${department}`)
    let { data: res3 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/MemberShip/${department}`)
    let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/wuDangPai/${department}`)
    let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/queryNational/${department}`)
    let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/queryGangAoTai/${department}`)
    let { data: res7 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/FrontPage/liangDaiBiao/${department}`)
    return { res1, res2, res3, res4, res5, res6, res7 }
}