// webpack ./main.js ./build.js
module.exports = {
    // 入口
    entry: {
        // 可以有多个，也可以有一个
        "main": './main.js'
    },
    output: {
        filename: './build.js'
    },
    // 监听文件的改动，自动产出build.js
    watch: true
}