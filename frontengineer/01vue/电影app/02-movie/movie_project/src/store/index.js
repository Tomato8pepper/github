import Vue from 'vue'
import Vuex from 'vuex'
// import index from './city.js'
import http from '../util/http'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  plugins: [createPersistedState({

    // 控制需要存储的数据
    reducer: (state) => {
      return {
        cityId: state.cityId,
        cityName: state.cityName
      }
    }
  })],

  // 公共状态
  state: {
    cityId: '310100',
    cityName: '上海',
    cinemasList: [],
    isTabbarShow: true
  },
  getters: {
  },

  // 只能支持同步
  mutations: {
    changeCityName(state, cityName) {
      state.cityName = cityName
    },
    changeCityId(state, cityId) {
      state.cityId = cityId
    },
    changeCinemasData(state, data) {
      state.cinemasList = data
    },
    clearCinemasList(state) {
      state.cinemasList = []
    },
    show(state) {
      state.isTabbarShow = true
    },
    hide(state) {
      state.isTabbarShow = false
    }
  },

  // 支持异步和同步
  actions: {
    getCinemasData(store, cityId) {
      console.log(cityId)
      return http({
          url: `/gateway?cityId=${cityId}&ticketFlag=1&k=8771621`,
          headers: {
              'X-Host': 'mall.film-ticket.cinema.list'
          }
      }).then(res => {
          console.log(res.data.data.cinemas)
          this.cinemas = res.data.data.cinemas
 
          store.commit('changeCinemasData', res.data.data.cinemas)
      })
    }
  },
  modules: {

  }
})


// Vuex 保存公共状态

// vuex默认是管理在内存，一刷新页面公共状态就失效了
// vuex 持久化 


  // 项目中的应用
    // 1. 非父子组件应用
    // 2. 缓存后端数据，减少重复请求数据，减轻服务器压力，提高用户体验