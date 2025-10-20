import axios from 'axios'
import router from '../router'
import { serverHost } from '../../config/config.default'

import { ElMessage } from 'element-plus'

const request = axios.create({
    baseURL: serverHost,
    timeout: 5000
})

request.interceptors.request.use(
    (config) => {
        config.headers['Content-Type'] = 'application/json;charset=utf-8'
        let account = localStorage.getItem('account') ? JSON.parse(localStorage.getItem('account')) : null
        if(account) {
            config.headers['token'] = account.token
        }
        return config
    },
    (err) => {
        return Promise.reject(err)
    }
)

request.interceptors.response.use(
    (response) => {
         let res = response.data
         if(response.config.responseType === 'blob') {
            return res
         }
         if(typeof res === 'string') {
            res = res ? JSON.parse(res) : res
         }

         if(res.code === '401') {
            ElMessage.error(res.msg)
            router.push('/login')
         }
         return res
    },
    (err) => {
        return Promise.reject(err)
    }
)

export default request



