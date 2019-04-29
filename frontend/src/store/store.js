import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

export default new Vuex.Store({
    state: {
      seasonTickets:[
        { id:	1,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	true
        },
        { id:	2,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	true
        },
        { id:	3,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	true
        },
        { id:	4,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        
      ]
    },
    mutations: {
      increment (state) {
        state.count++
      }
    }
  });