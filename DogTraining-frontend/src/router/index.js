import Vue from 'vue'
import Router from 'vue-router'

import MainPage from '@/routes/MainPage'
import LoginPage from '@/routes/LoginPage'
import Page1 from '@/routes/Page1'
import Page2 from '@/routes/Page2'
import Page3 from '@/routes/Page3'
import Page4 from '@/routes/Page4'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainPage',
      component: MainPage
    },
    {
      path: '/LoginPage',
      name: 'LoginPage',
      component: LoginPage
    },
    {
      path: '/Page1',
      name: 'Page1',
      component: Page1
    },
    {
      path: '/Page2',
      name: 'Page2',
      component: Page2
    },
    {
      path: '/Page3',
      name: 'Page3',
      component: Page3
    },
    {
      path: '/Page4',
      name: 'Page4',
      component: Page4
    }
  ]
})
