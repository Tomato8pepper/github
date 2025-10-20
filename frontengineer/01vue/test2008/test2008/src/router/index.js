import Vue from 'vue'
import VueRouter from 'vue-router'
import Nowplaying from '../views/films/Nowplaying.vue'
import Detail from '../views/films/Detail.vue'
import Cinemas from '../views/films/Cinemas.vue'
import Mine from '../views/films/Mine.vue'
import City from '../views/films/City.vue'
import Search from '../views/films/Search.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '*',
    redirect: '/home'
  },
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: HomeView
  // },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  // {
  //   path: '/',
  //   name: 'Nowplaying',
  //   component: Nowplaying
  // },
  {
    path: '/home',
    name: 'Home',
    component: Nowplaying
  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail
  },
  {
    path: '/cinemas',
    name: 'Cinemas',
    component: Cinemas
  },
  {
    path: '/mine',
    name: 'Mine',
    component: Mine
  },
  {
    path: '/search',
    name: 'Search',
    component: Search
  },
  {
    path: '/city',
    name: 'City',
    component: City
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

// router.beforeEach((to, from, next) => {
  // console.log('==before', to, from, next)
  // next()
// })

// router.afterEach((to, from, next) => {
//   console.log('==after', to, from)
// })

export default router
