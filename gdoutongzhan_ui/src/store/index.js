import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import app from './modules/app'
import settings from './modules/settings'
import user from './modules/user'
import reward from './modules/reward'
import politics from './modules/politics'
import permission from './modules/permission'
import advertise from './modules/advertise'
import gainArt from './modules/gainArt'

Vue.use(Vuex)

const store = new Vuex.Store({
    modules: {
        app,
        settings,
        user,
        reward,
        politics,
        permission,
        advertise,
        gainArt
    },
    getters
})

export default store