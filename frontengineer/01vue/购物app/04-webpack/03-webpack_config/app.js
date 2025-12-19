var App = {
    template: `
        <div>我是入口组件sss</div>
    `
}

export default App

// 声明并导出
export var num1 = 2

// 声明再导出
var num2 = 3
export { num2 }

export function add(x, y) {
    return console.log(x + y)
}