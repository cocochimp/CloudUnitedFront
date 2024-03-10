const state = {
    id: []
}
const mutations = {
    SELECTIONCHANGE(state, id) {
        state.id = id
    }

}
const actions = {
    //获取勾选的id
    SelectionChange({ commit }, id) {
        commit("SELECTIONCHANGE", id)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}