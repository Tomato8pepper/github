// 1. 对于数据请求的封装

import axios from "axios";
import {   Toast } from 'vant'

// function httpfoxx() {
//     return axios({
//         url: '',
//         headers: {}
//     })
// }
// export default { httpfoxx }

// 2. 自定义配置
const http = axios.create({
    baseURL: 'https://m.maizuo.com/',
    timeout: 10000,
    headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.1","e":"1745218806485863880392705","bc":"440300"}'
    }
})





// Add a request interceptor
http.interceptors.request.use(function (config) {
    // Do something before request is sent
    
    Toast.loading({
        message: '加载中...',
        forbidClick: true,
        duration: 5000, // 持续展示 toast
    });
    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });

// Add a response interceptor
http.interceptors.response.use(function (response) {
    // Any status code that lie within the range of 2xx cause this function to trigger
    // Do something with response data
    Toast.clear()

    return response;
  }, function (error) {
    // Any status codes that falls outside the range of 2xx cause this function to trigger
    // Do something with response error
    return Promise.reject(error);
});



export default http