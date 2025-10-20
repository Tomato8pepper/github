import { createStore } from 'vuex'

export default createStore({
  state: {
    isShowTabbar: true
  },
  getters: {
  },
  mutations: {
    show(state) {
      state.isShowTabbar = true
    },
    hide(state) {
      state.isShowTabbar = false
    }
  },
  actions: {
  },
  modules: {
  }
})
