import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/router/views/Home'
import LoginPage from '@/router/views/LoginPage'
import SeasonTickets from '@/components/SeasonTickets'

import TrickPage from '@/components/TrickPage'
import BasicTricks from '@/components/BasicTricks'
import IntermediateTricks from '@/components/IntermediateTricks'
import AdvancedTricks from '@/components/AdvancedTricks'
import Page1 from '@/router/views/Page1'
import Page2 from '@/router/views/Page2'
import Page3 from '@/router/views/Page3'
import Page4 from '@/router/views/Page4'

Vue.use(Router)

export default new Router({
  base: '/app',
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/LoginPage',
      name: 'LoginPge',
      component: LoginPage
    },
    {
      path: '/SeasonTickets',
      name: 'SeasonTickets',
      component: SeasonTickets
    },
    {
      path: '/tricks',
      name: 'TrickPage',
      component: TrickPage
    },
    {
      path: '/alapszint',
      name: 'BasicTricks',
      component: BasicTricks
    },
    {
      path: '/kozepszint',
      name: 'IntermediateTricks',
      component: IntermediateTricks
    },
    {
      path: '/haladoszint',
      name: 'AdvancedTricks',
      component: AdvancedTricks
    },
    {
      path: '/profile',
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
