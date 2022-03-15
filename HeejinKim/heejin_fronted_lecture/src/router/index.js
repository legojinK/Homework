import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '@/views/Test.vue'

import ItemListPage from '@/views/item/ItemListPage.vue'
import ItemRegisterPage from '@/views/item/ItemRegisterPage.vue'
import ItemReadPage from '@/views/item/ItemReadPage.vue'
import ItemModifyPage from '@/views/item/ItemModifyPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/itemList',
    name: 'ItemListPage',
    component: ItemListPage
  },
  {
    path: '/itemRegister',
    name: 'ItemRegisterPage',
    component: ItemRegisterPage
  },
  {
    path: '/itemRead/:itemNo',
    name: 'ItemReadPage',
    component: {
          default: ItemReadPage
    },
    props: {
      default: true //v-바인드에서 자동으로 값을 가져올 경우 props설정을 안해도 자동으로 들어옴
    }
  },
  {
    path: '/itemModify/:itemNo',
    name: 'ItemModifyPage',
    component: {
      default: ItemModifyPage
    },
    props: {
      default: true 
    }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router