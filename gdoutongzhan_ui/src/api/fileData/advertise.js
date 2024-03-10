//这个模块是统战宣传文章管理组件的模块 用于获取数据
import request from "@/utils/send"

// 发布文章
export const reqAdverAdd = ({ title, author, content, type }) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/insertPublicity",
    method: "post",
    params: {
        title,
        author,
        content,
        type
    }
})

//删除文章
export const reqAdverRemove = (xid) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/deletePublicity",
    method: "post",
    params: {
        xid
    }
})

//获取文章内容，便于用户进行修改
export const reqAdverToUpdata = (xid) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/selectByXid",
    method: "post",
    params: { xid }
})

//修改文章
export const reqAdverUpdata = ({ xid, title, author, content, type }) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/updatePublicity",
    method: "post",
    params: {
        xid,
        title,
        author,
        content,
        type
    }
})

//获取文章数据
export const reqAdverData = ({ current, number }) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/selectByPage",
    method: "post",
    params: {
        current,
        number
    }
})

//查询文章数据
export const reqAdverSearch = (searchData, p) => request({
    url: "http://localhost:9110/publicity/servicepublicity/publicity/selectByType",
    method: "post",
    params: {
        type: searchData.searchValue,
        current: p.current,
        number: p.number
    }
})