import axios from "axios"

export async function callDepartment(department) {
    let { data: res4 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ZongJiao/queryAge/${department}`)
    let { data: res5 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ZongJiao/querySex/${department}`)
    let { data: res6 } = await axios.post(`http://localhost:9107/service/servicedecisioncenter/ZongJiao/queryReligion/${department}`)
    return { res4, res5, res6 }
}