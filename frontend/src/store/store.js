import Vue from 'vue'
import Vuex from 'vuex'
import DogApi from '../api/dog-api'
Vue.use(Vuex)


const moduleSeasonTickets = {
  state: { 
    seasonTickets:[],
   },
  mutations: {  },
  actions: {  },
}
const moduleDog={
  state:{
    dog:{},
    seasonTickets: [],
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
    INIT_DOG_BY_ID(state,dog){
      state.dog=dog
    },
    INIT_SEASON_TICKETS_BY_A_DOG(state,seasonTickets){
      state.seasonTickets=[...seasonTickets]
    }
   },
  actions: {  
    getDogById(context,dogID){
      DogApi.getDogById(dogID)
      .then(res=>{
        context.commit('INIT_DOG_BY_ID',res.data)
      })
    },
    getAllSeasonTicketsByDog(context,dogID){
      DogApi.getAllSeasonTicketsByDog(dogID)
      .then(res => {
          console.log("STORE: Ticket_res: ",res.data, dogID)
          context.commit('INIT_SEASON_TICKETS_BY_A_DOG',res.data)
      })
  },

  },

}
export default new Vuex.Store({
  modules: {
    moduleSeasonTickets: moduleSeasonTickets,
    moduleDog:moduleDog
  },
    state: {
      
    },
    mutations: {
      
    }
  });