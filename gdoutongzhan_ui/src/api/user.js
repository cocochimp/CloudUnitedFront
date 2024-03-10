//引入axios（对axios进行二次封装）
import request from '@/utils/request'

// 对外暴露登录接口函数
// export function login(data) {
//     return request({
//         url: '/vue-admin-template/user/login',
//         method: 'post',
//         data
//     })
// }
export function login(username, password) {
    // debugger
    return request({
        url: 'http://localhost:8222/admin/acl/login',
        method: 'post',
        data: {
            username,
            password
        }
    })
}

//对外暴露获取用户信息的函数
export function getInfo(token) {
    return request({
        url: 'http://localhost:8222/admin/acl/index/info',
        method: 'get',
        params: { token }
    })
}

//对外暴露退出登录函数
export function logout() {
    return request({
        url: '/vue-admin-template/user/logout',
        method: 'post'
    })
}

//获取菜单权限数据
export function getMenu() {
    return request({
        url: 'http://localhost:8222/admin/acl/index/menu',
        method: 'get'
    })
}