import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './globe.css'

import mint from 'mint-ui'
Vue.use(mint)   // 注册所有的全局组件，和给Vue.prototype挂载一些全局对象，通过this.xx就可以使用
import 'mint-ui/lib/style.min.css'

import axios from 'axios'
Vue.prototype.$axios = axios
axios.defaults.baseURL = 'https://www.sinya.online/api/'


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
