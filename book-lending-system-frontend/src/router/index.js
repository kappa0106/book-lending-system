import Vue from 'vue'
import VueRouter from 'vue-router'
import Cookies from "js-cookie";
import Layout from "@/views/Layout";

Vue.use(VueRouter)

const routes = [
  // login
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login/Login')
  },
  // register
  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/register/Register')
  },

  // layout
  {
    path: '/',
    name: 'layout',
    redirect: 'home',
    component: Layout,
    children: [
      // home(book list)
      {
        path: 'home',
        name: 'home',
        component: () => import('@/views/home/HomeView')
      },
      // borrow
      {
        path: 'borrowList',
        name: 'borrowList',
        component: () => import('@/views/borrow/List')
      }
    ]
  },
  // ===== 404 =====
  {
    path: '*',
    component: () => import('@/views/404')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeResolve((to, from, next) => {
  if (to.path === '/login') next()
  const admin = Cookies.get("admin")
  if (!admin && to.path !== '/login') return next('/login')
  next()
})

export default router
