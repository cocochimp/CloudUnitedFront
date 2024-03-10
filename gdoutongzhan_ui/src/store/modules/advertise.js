// 此模块为资料库 统战宣传模块的vuex仓库
const state = {
    xid: []
}
const mutations = {
    SELECTIONCHANGE(state, xid) {
        state.xid = xid
    }
}
const actions = {
    //获取勾选的id
    SelectionChange({ commit }, xid) {
        commit("SELECTIONCHANGE", xid)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}