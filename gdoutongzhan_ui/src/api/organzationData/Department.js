//这个模块主要获取的是组织库 基层统战的数据

import axios from "axios"

//获取左侧导航栏列表列表接口
export async function callAllMenu(){
    let { data: res1 } = await axios.get("http://localhost:9109/Organization/ZuZhi/Department") 
    let { data: res2}  = await axios.get("http://localhost:9109/Organization/ZuZhi/Party") 
    let { data: res3}  = await axios.get("http://localhost:9109/Organization/ZuZhi/PartyOther")
    let { data: res4}  = await axios.get("http://localhost:9109/Organization/ZuZhi/Political")
    return{res1,res2,res3,res4}
}
