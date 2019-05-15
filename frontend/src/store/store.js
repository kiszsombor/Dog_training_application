import Vue from 'vue'
import Vuex from 'vuex'
import DogApi from '../api/dog-api'
import SeasonTicketApi from '../api/season-tickets-api'
import TrainerApi from '../api/trainer-api'
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
    trainer:{}
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
    DELETE_SEASON_TICKET(state, seasonTicket){
      delete state.seasonTickets[seasonTicket];
  },
  INIT_TRAINER_BY_ID(state,trainer){
    state.trainer=trainer;

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
  deleteSeasonTicketById(context,seasonTicketId){
    SeasonTicketApi.deleteSeasonTicketById(seasonTicketId)
    .then(res=>{
        // console.log("Res.data delete: ",res.data)
        context.commit('DELETE_SEASON_TICKET', res.data)
        return Promise.resolve()

    })
  },
  getTrainerById(context,TrainerId){
    TrainerApi.getTrainerById(TrainerId)
    .then(res=>{
        // console.log("Res.data delete: ",res.data)
        context.commit('INIT_TRAINER_BY_ID', res.data)
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