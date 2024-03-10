//这个是reward的vuex仓库
const state = {
    pid: []
}
const mutations = {
    SELECTIONCHANGE(state, pid) {
        state.pid = pid
    }

}
const actions = {
    //获取勾选的id
    SelectionChange({ commit }, pid) {
        commit("SELECTIONCHANGE", pid)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}