import { projectName } from '../../config/config.default'
import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import FrontHome from '../views/front/Home.vue'
import FrontPerson from '../views/front/Person.vue'
import FrontPassword from '../views/front/Password.vue'
import BackHome from '../views/back/Home.vue'
import BackPerson from '../views/back/Person.vue'
import BackPassword from '../views/back/Password.vue'
import BackUser from '../views/back/User.vue'
import BackAdmin from '../views/back/Admin.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import NotFound from '../views/404.vue'
import Front from '../views/Front.vue'
import Back from '../views/Back.vue'

const routes = [
  {
    path: '/',
    name: '/',
    component: Home,
    meta: {
      title: '主页'
    }
  },
  {
    path: '/404',
    name: '404',
    component: NotFound,
    meta: {
      title: '404'
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      title: '登录'
    }
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
    meta: {
      title: '注册'
    }
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    meta: {
      title: '主页'
    }
  },
  {
    path: '/front',
    name: 'Front',
    component: Front,
    meta: {
      title: '主页'
    },
    children: [
      {
        path: 'home',
        name: 'FrontHome',
        component: FrontHome,
        meta: {
          title: '主页'
        }
      },
      {
        path: 'password',
        name: 'FrontPassword',
        component: FrontPassword,
        meta: {
          title: '修改密码'
        }
      },
      {
        path: 'person',
        name: 'FrontPerson',
        component: FrontPerson,
        meta: {
          title: '个人信息'
        }
      }
    ]
  },
  {
    path: '/back',
    name: 'Back',
    component: Back,
    meta: {
      title: '主页'
    },
    children: [
      {
        path: 'home',
        name: 'BackHome',
        component: BackHome,
        meta: {
          title: '主页'
        }
      },
      {
        path: 'password',
        name: 'BackPassword',
        component: BackPassword,
        meta: {
          title: '修改密码'
        }
      },
      {
        path: 'person',
        name: 'BackPerson',
        component: BackPerson,
        meta: {
          title: '个人信息'
        }
      },
      {
        path: 'user',
        name: 'BackUser',
        component: BackUser,
        meta: {
          title: '用户管理'
        }
      },
      {
        path: 'admin',
        name: 'BackAdmin',
        component: BackAdmin,
        meta: {
          title: '管理员管理'
        }
      }
    ]
  }
  
]

 

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  console.log('beforeEach', to)
  const account = JSON.parse(localStorage.getItem('account') || '{}')
  if(to.matched.length === 0) {
    next('/404')
    return
  }
  if(to.path === '/') {
    if(account.role) {
      if(account.role === 'ROLE_ADMIN') {
        next('/back/home')
      } else {
        next('/front/home')
      }
    }else {
      next('/login')
    }
  } else {
    next()
  }
})


router.afterEach((to) => {
  console.log('afterEach')
  document.title = to.meta.title ? `${to.meta.title} - ${projectName}` : projectName
})

export default router
