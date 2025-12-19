// es6 module

import Vue from './vue.js'
import App from "./app.js";


import { num1, num2, add } from './app.js'
console.log(num1)
console.log(num2)
console.log(add(3, 5))

new Vue({
    el: '#app',
    components: {
        App
    },
    template: `
        <App />
    `
})

// 整个模块的加载
// import * as obj from './app.js'
// obj.default
// obj.num1
// obj.num2
// obj.add(3, 5)

// webpack ./main.js ./build.js