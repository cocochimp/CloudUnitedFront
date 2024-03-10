//这个模块是门户网站文章管理组件的模块 用于获取数据
import request from "@/utils/send"

//获取所有文章
export const reqGetArticle = ({ current, number }) => request({
    url: "http://localhost:9102/servicearticle/article/article/selectByPage",
    params: {
        current,
        number
    },
    method: "post"
})

//发布文章
export const reqAddArticle = (fd) => request({
    url: "http://localhost:9102/servicearticle/article/article/addArticle",
    data: fd,
    method: "post"
})


//删除文章
export const reqRemoveArticle = (id) => request({
    url: "http://localhost:9102/servicearticle/article/article/deleteArticleById",
    params: {
        id
    },
    method: "post"
})

// 获取文章内容用户展示，方便用户修改
export const reqGetArticleToUpdata = (id) => request({
    url: "http://localhost:9102/servicearticle/article/article/queryArticleById",
    params: { id },
    method: "post"
})

//修改文章
export const reqUpdataArticle = (fd) => request({
    url: "http://localhost:9102/servicearticle/article/article/updateArticle",
    data: fd,
    method: "post"
})

//查询文章
export const reqSearchArticle = (showTable, p) => request({
    url: "http://localhost:9102/servicearticle/article/article/queryArticleByType",
    params: {
        type: showTable.searchValue,
        current: p.current,
        number: p.number
    },
    method: "get"
})