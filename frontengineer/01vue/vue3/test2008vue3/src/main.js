import { createApp } from 'vue'
import App from './App.vue'
// import baseApp from './base/10-app.vue'
import router from './router'
import store from './store'

createApp(App).use(store).use(router).mount('#app')                                                     
