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
        
      ],
      dogs:[
        {
          id:	1,
          name:	"Buksi",
          birthDate:	"2019-03-21T17:52:00.000+0000",
          breed:	"breed_Buksi",
          weight:	5,
          description:"The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from  by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
        },
        {
          id:	2,
          name:	"Pamacs",
          birthDate:	"2019-03-21T17:52:00.000+0000",
          breed:	"breed_pami",
          weight:	5,
        },
        {
          id:	3,
          name:	"Szilva",
          birthDate:	"2019-03-21T17:52:00.000+0000",
          breed:	"breed_Buksi",
          weight:	5,
        },
        {
          id:	4,
          name:	"Körte",
          birthDate:	"2019-03-21T17:52:00.000+0000",
          breed:	"breed_Buksi",
          weight:	5,
        },
        {
          id:	5,
          name:	"Kutyi",
          birthDate:	"2019-03-21T17:52:00.000+0000",
          breed:	"breed_Buksi",
          weight:	5,
        }
      ]
    },
    mutations: {
      increment (state) {
        state.count++
      }
    }
  });