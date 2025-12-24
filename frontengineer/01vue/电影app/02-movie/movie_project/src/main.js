import Vue from 'vue'
import App from './App.vue'
import PCApp from './PCApp.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

import Vant from 'vant'
import { Lazyload } from 'vant'
import 'vant/lib/index.css';
Vue.use(Vant)
Vue.use(Lazyload)


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);


new Vue({
  router,  // this.$router
  store,   // this.$store
  render: h => h(App)
}).$mount('#app')
