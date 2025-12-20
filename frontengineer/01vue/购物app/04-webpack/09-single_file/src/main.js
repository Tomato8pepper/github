import Vue from 'vue'
import App from './App.vue'

new Vue({
    el: '#app',
    // vue2.0新增 使用虚拟dom来渲染节点提升性能，基于js计算，通过使用createElement(h)来创建节点
    render: c => c(App)


    // components: {
    //     App
    // },
    // template: '<App />'
})