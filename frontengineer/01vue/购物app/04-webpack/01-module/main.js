// es6 module

import App from "./app.js";
import Vue from './vue.js'

new Vue({
    el: '#app',
    components: {
        App
    },
    template: `
        <App />
    `
})

// webpack ./main.js ./build.js