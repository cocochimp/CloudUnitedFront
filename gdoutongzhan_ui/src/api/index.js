//将模块请求的接口函数统一暴露
import * as Department from './organzationData/Department'
import * as Party from './organzationData/Party'
import * as Portrait from './decisionData/Portrait'
import * as minNationality from './juecezhongxin/minNationality'
import * as religion from './juecezhongxin/religion'


//对外暴露
export default {
    Department,
    Party,
    Portrait,
    religion,
    minNationality
}