import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Comingsoon from '../views/films/Comingsoon.vue'
import Detail from '../views/films/Detail.vue'
import Nowplaying from '../views/films/Nowplaying.vue'
import Cinemas from '../views/Cinemas.vue'
import Films from '../views/Films.vue'
import Center from '../views/Center.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/films',
    name: 'Films',
    component: Films,
    children: [
      {
        path: '/films/comingsoon',
        name: 'Comingsoon',
        component: Comingsoon
      },
      {
        path: '/films/nowplaying',
        name: 'Nowplaying',
        component: Nowplaying
      }
    ]
  },
  {
    path: '/center',
    name: 'Center',
    component: Center
  },
  {
    path: '/cinemas',
    name: 'Cinemas',
    component: Cinemas
  },
  {
    path: '/:any',
    // redirect: '/films'
    redirect: {
      name: 'Films'
    }
  },
  {
    path: '/detail/:id',
    name: 'Detail',
    component: Detail
  }
]

const router = createRouter({
  // history: createWebHistory(process.env.BASE_URL),    // history模式
  history: createWebHashHistory(process.env.BASE_URL),   // hash模式
  routes
})

export default router
