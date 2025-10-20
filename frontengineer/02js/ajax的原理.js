// 是什么：通过XMLHttpRequest向服务器发送异步请求，从服务器获取数据，然后用js操作dom更新页面。
// XMLHttpRequest.open(method, url, true(执行异步操作), null(可选的用户名用于认证), 
// null(可选的密码用于认证)) 封装ajax：
function ajax(options) {
    const xhr = new XMLHttpRequest()
    
    options = options || {}
    options.type = (options.type || 'GET').toUpperCase()
    // 服务器返回的数据类型
    options.dataType = options.dataType || 'json'
    const params = options.data
    
    if (options.type === 'GET') {
        // 与服务器建立连接
        xhr.open('GET', options.url + '?' + params, true)
        // 给服务端发送数据
        xhr.send(null)
    } else if (options.type === 'POST') {
        // 与服务器建立连接
        xhr.open('POST', options.url, true)
        // 给服务端发送数据
        xhr.send(params)
    }
    
    xhr.onreadystatechange = function () {
        // 0 open方法未调用  1 send方法未调用 2 send方法已经调用响应头、响应方法已经返回
        // 3 响应体下载中，responseText已经获取部分数据  4 整个请求已经完毕
        if (xhr.readyState === 4) {
            let status = xhr.status
            if (status >= 200 && status < 300) {
                // && 只要前面是false就返回前面的值，只要前面是true就返回后面的值
                options.success && options.success(xhr.responseText, xhr.responseXML)
            } else {
                options.fail && options.fail(status)
            }
        }
    }
}

ajax({
    type: 'post',
    // 服务器返回的数据类型
    dataType: 'json',
    // {} || ''
    data: {},
    url: 'http://xxx',
    success: (text, xml) => {},
    fail: (status) => {}
})