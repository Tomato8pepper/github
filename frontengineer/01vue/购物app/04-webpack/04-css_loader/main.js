// es6 module

import './main.css'

import Vue from './vue.js'
import App from "./app.js";

new Vue({
    el: '#app',
    components: {
        App
    },
    template: `
        <App />
    `
})