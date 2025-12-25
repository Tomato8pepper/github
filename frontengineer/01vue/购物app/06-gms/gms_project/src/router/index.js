import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/home/Home'
import Member from '../views/member/Member'
import Shopcart from '../views/shopcart/Shopcart'
import Find from '../views/find/Find'
import NewsList from '../views/home/NewsList'
import DetailList from '../views/home/DetailList'
import PhotoList from '../views/home/PhotoList'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/member',
    name: 'Member',
    component: Member
  },
  {
    path: '/shopcart',
    name: 'Shopcart',
    component: Shopcart
  },
  {
    path: '/find',
    name: 'Find',
    component: Find
  },
  {
    path: '/newList',
    name: 'NewsList',
    component: NewsList
  },
  {
    path: '/detail',
    name: 'DetailList',
    component: DetailList
  },
  {
    path: '/photolist',
    name: 'PhotoList',
    component: PhotoList
  }
]

const router = new VueRouter({
  routes
})

export default router
