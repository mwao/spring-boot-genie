import { createRouter, createWebHistory } from 'vue-router'
import Main from '../views/Main.vue'

//우리가 사용할 route 생성 및 설정
const routes = [
  {
    path: '/',
    name: 'Main - Java/Vue CloneProject',
    component: Main,
  },
  {
    path: '/program',
    name: '프로그램 소개',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Program.vue')
  },
  {
    path: '/mc',
    name: 'MC 소개',
    component: () => import('../views/Mc.vue')
  },
  {
    path: '/lineup',
    name: '출연진 소개',
    component: () => import('../views/Lineup.vue')
  },
  {
    path: '/clip',
    name: '다시보기',
    component: () => import('../views/Clip.vue')
  },
  {
    path: '/notice',
    name: '공지사항',
    component: () => import('../views/Notice.vue')
  },
  {
    path: '/noticedetail',
    name: '공지사항상세',
    component: () => import('../views/NoticeDetail.vue')
  },
]

//VueRouter에 route를 등록하고 설정
const router = createRouter({
  // mode: 'history',
  // base: process.env.BASE_URL,
  history: createWebHistory(),
  routes,
})

//설정한 VueRouter 내보냄
export default router
