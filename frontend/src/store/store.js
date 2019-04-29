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
        ,
        { id:	5,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        ,
        { id:	6,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        ,
        { id:	7,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        ,
        { id:	8,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        ,
        { id:	9,
          startDate:	"2019-01-16T12:00:00",
          endDate:	"2019-02-16T12:00:00",
          type:	"TWELWE",
          paid:	false
        }
        ,
        { id:	10,
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