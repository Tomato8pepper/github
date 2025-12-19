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
    watch: true,
    // 声明模块，包含各个loader
    module: {
        loaders: [
            {
                // 对于后缀名为.css的
                test: /\.css$/,
                // css-loader解析文件，然后style-loader生成一个内容为解析完的css代码的style标签，放入head标签里面
                loader: 'style-loader!css-loader'
            },
            {
                test: /\.(jpg|png|jpeg|gif|svg)$/,
                loader: 'url-loader?limit=50000'
            }
        ]
    }
}


