// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// import {createApp} from 'vue'
import App from './App'
import router from './router'
// import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/assets/css/global.css'
import axios from 'axios'
// import locale from 'element-ui/src/mixins/locale'

// createApp(App).use(store).use(router).mount('#app')
axios.defaults.baseURL = '/api'

// Vue.use(ElementUI, {locale, size: 'small'})
Vue.use(ElementUI)
/* eslint-disable no-new */

// this.$axios.create({
//   timeout: 5000
// })

// request 拦截器
// 可以自请求发送前对请求做一些处理
// 比如统一加token，对请求参数统一加密
axios.interceptors.request.use(config => {
  config.headers['Content-Type'] = 'application/json;charset=utf-8'
  // config.headers['token'] = user.token;  // 设置请求头
  // 取出sessionStorage里面的用户信息
  let userJson = window.sessionStorage.getItem('user')
  if (!userJson) {
    // userJson是空的，游客登录
    router.push('/login')
  }
  return config
}, error => {
  return Promise.reject(error)
}
)

// axios.interceptors.request.use(config => {
//   config.headers.Authorization = window.sessionStorage.getItem('user')
//   return config
// })

// response 拦截器
// 可以在接口响应后统一处理结果
// axios.interceptors.response.use(
//   response => {
//     let res = response.data.data
//     // 如果是返回的文件
//     if (response.config.responseType === 'blob') {
//       return res
//     }
//     // 兼容服务端返回的字符串数据
//     if (typeof res === 'string') {
//       res = res ? JSON.parse(res) : res
//     }
//     return res
//   },
//   error => {
//     console.log('err' + error)
//     return Promise.reject(error)
//   }
// )
Vue.prototype.$axios = axios
Vue.config.productionTip = false
new Vue({
  // el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App)
}).$mount('#app')
