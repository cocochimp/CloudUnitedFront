//这个模块是资料库中统战成果展示轮播图的模块 用于获取数据
import request from "@/utils/gain"

//获取图片类型
export const reqPicType = () => request({
    url: "http://localhost:9108/servicefile/AchievementOfPhoto/queryPhotoType",
    method: "post",
})

//获取所有图片
export const reqGetAllPic = (p) => request({
    url: "http://localhost:9108/servicefile/AchievementOfPhoto/list",
    params: {
        page: p.current,
        size: p.number
    },
    method: "get"
})

//分类查询
export const reqGetTypePic = (searchTypeValue, p) => request({
    url: "http://localhost:9108/servicefile/AchievementOfPhoto/queryPhotoByType",
    params: {
        typeId: searchTypeValue,
        page: p.current,
        size: p.number
    },
    method: "post"
})

//删除图片
export const reqRemovePic = (id, imgName) => request({
    url: "http://localhost:9108/servicefile/AchievementOfPhoto/delete",
    params: {
        id,
        imgName
    },
    method: "post"
})