import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/router/views/Home'
import LoginPage from '@/router/views/Login'
import SeasonTickets from '@/components/SeasonTickets'

import TrickPage from '@/components/TrickPage'
import BasicTricks from '@/components/BasicTricks'
import IntermediateTricks from '@/components/IntermediateTricks'
import AdvancedTricks from '@/components/AdvancedTricks'
import DogProfile from '@/router/views/DogProfile'
import Page2 from '@/router/views/Page2'
import DogList from '@/router/views/DogList'
import Page4 from '@/router/views/Page4'

Vue.use(Router)


const router = new Router({


  
  base: '/app',
  mode: 'history',
  routes: [
    {
      path: '/logged/:trainerId/:dogId',
      name: 'Home',
      component: Home,
      children:[
        {
          path: 'SeasonTickets',
          name: 'SeasonTickets',
          component: SeasonTickets,
          meta: { requiresAuth: true }
        },
        {
          path: 'profile',
          name: 'DogProfile',
          component: DogProfile
        },
        {
          path: 'tricks',
          name: 'TrickPage',
          component: TrickPage
        },
        {
          path: 'alapszint',
          name: 'BasicTricks',
          component: BasicTricks
        },
        {
          path: 'kozepszint',
          name: 'IntermediateTricks',
          component: IntermediateTricks
        },
        {
          path: 'haladoszint',
          name: 'AdvancedTricks',
          component: AdvancedTricks
        },
        {	
          path: 'kutyaim',
          name: 'Kutyáim',
          component: DogList
        },
      ]
    },
    {
      path: '/LoginPage',
      name: 'LoginPge',
      component: LoginPage
    },

	  {
      path: '/Page2',
      name: 'Page2',
      component: Page2
    },

    {
      path: '/Page4',
      name: 'Page4',
      component: Page4
    }
  ]
})


router.beforeEach((to, from, next) => {
  console.log(to)
  if(to.matched.some(record => record.meta.requiresAuth)) {
    if (store.getters.isLoggedIn) {
      next()
      return
    }
    next('/login') 
  } else {
    next() 
  }
})

// router.beforeEach((to, from, next) => {
//   if(to.matched.some(record => record.meta.requiresAuth)) {
//       if (localStorage.getItem('jwt') == null) {
//           next({
//               path: '/login',
//               params: { nextUrl: to.fullPath }
//           })
//       } else {
//           let user = JSON.parse(localStorage.getItem('user'))
//           if(to.matched.some(record => record.meta.is_admin)) {
//               if(user.is_admin == 1){
//                   next()
//               }
//               else{
//                   next({ name: 'userboard'})
//               }
//           }else {
//               next()
//           }
//       }
//   } else if(to.matched.some(record => record.meta.guest)) {
//       if(localStorage.getItem('jwt') == null){
//           next()
//       }
//       else{
//           next({ name: 'userboard'})
//       }
//   }else {
//       next() 
//   }
// })


export default router;