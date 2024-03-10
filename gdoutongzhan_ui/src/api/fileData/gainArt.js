//这个模块是资料库中统战成果展示新闻的模块 用于获取数据
import request from "@/utils/gain"

//获取文章分类 
export const reqArtType = () => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/queryArticleType",
    method: "post",
})

//获取所有文章
export const reqAllArt = (p) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/queryAllArticles",
    method: "get",
    params: {
        page: p.current,
        size: p.number
    }
})

//上传文章
export const reqAddArt = (uploadData) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/addArticle",
    method: "post",
    params: {
        author: uploadData.articleAuth,
        title: uploadData.articleTitle,
        content: uploadData.content,
        type: uploadData.typeValue
    }
})

//查询指定类别文章
export const reqSearchTypeArt = (searchTypeValue, p) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/queryArticleByType",
    method: "post",
    params: {
        typeId: searchTypeValue,
        page: 1,
        size: 6
    }
})

//删除文章
export const reqRemoveArt = (id) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/deleteArticleById",
    method: "post",
    params: {
        id
    }
})

//修改文章
export const reqUpdataArt = (id, updataData) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/updateArticle",
    method: "post",
    params: {
        id: id,
        author: updataData.articleAuth,
        title: updataData.articleTitle,
        content: updataData.content,
        type: updataData.typeValue,
    }
})

// 获取文章内容用户展示，方便用户修改
export const reqGetArticleToUpdata = (id) => request({
    url: "http://localhost:9108/servicefile/scientificAchievementOfArticle/queryArticleById",
    params: { id },
    method: "post"
})