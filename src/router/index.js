import Vue from 'vue'
import Router from 'vue-router'
import Layout from '../layout/Layout'
import User from '../views/User'
import Login from '../views/Login'
import Register from '../views/Register'
import Person from '../views/Person'
import Goods from '../views/Goods'
// import Header from '@/components/Header'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Layout',
      component: Layout,
      redirect: '/user',
      children: [
        {
          path: 'user',
          name: 'User',
          component: User
        },
        {
          path: 'goods',
          name: 'Goods',
          component: Goods
        },
        {
          path: 'person',
          name: 'Person',
          component: Person
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    }
  ]
})

// const router = createRouter( {
//   history: createWebHistory(process.env.BASE_URL),
//   routes
// })
// export default router
