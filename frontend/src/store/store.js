import Vue from 'vue'
import Vuex from 'vuex'
import DogApi from '../api/dog-api'
import SeasonTicketApi from '../api/season-tickets-api'
Vue.use(Vuex)


const moduleSeasonTickets = {
  state: { 
    seasonTickets:[],
   },
  mutations: { 
    
   },
  actions: { 
    
   },
}
const moduleDog={
  state:{
    dog:{},
    seasonTickets: [],
  },
  mutations: { 
    INIT_DOG_BY_ID(state,dog){
      state.dog=dog
    },
    INIT_SEASON_TICKETS_BY_A_DOG(state,seasonTickets){
      state.seasonTickets=[...seasonTickets]
    },
    ADD_NEW_SEASON_TICKET(state, seasonTicket){
      state.seasonTickets.push(seasonTicket)
    },
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
          context.commit('INIT_SEASON_TICKETS_BY_A_DOG',res.data)
      })
  },
  addNewSeasonTicket(context, payload){
    return SeasonTicketApi.addNewSeasonTicket({...payload})
        .then(res => {
            context.commit('ADD_NEW_SEASON_TICKET', res.data)
            return Promise.resolve()
        })
},

  },

}
export default new Vuex.Store({
  modules: {
    // moduleSeasonTickets: moduleSeasonTickets,
    moduleDog:moduleDog
  },
    state: {
      
    },
    mutations: {
      
    }
  });