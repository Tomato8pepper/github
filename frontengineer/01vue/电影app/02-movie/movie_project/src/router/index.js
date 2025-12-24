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
  routes
})

export default router
