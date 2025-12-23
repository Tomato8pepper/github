// vue插件必须具备install函数
function Installer() {

}

Installer.install = function(Vue) {
    // 接收vue的构造函数，给原型挂载属性或注册全局属性或过滤器
    // 1. 注册全局组件
    Vue.component('test', {
        template: `<h1>haha</h1>`
    })

    // 2. 注册全局属性
    let log = function() {
        console.log('我们自己插件的log函数')
    }

    Object.defineProperty(Vue.prototype, '$log', {
        set: function(newV) {
            console.log('你做梦')
        },
        get: function() {
            return log
        }
    })
}

export default Installer