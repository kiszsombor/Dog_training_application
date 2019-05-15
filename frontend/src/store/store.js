import Vue from 'vue'
import Vuex from 'vuex'
import DogApi from '../api/dog-api'
import SeasonTicketApi from '../api/season-tickets-api'
<<<<<<< HEAD
import TrainerApi from '../api/trainer-api'
=======
import TrickApi from '../api/tricks-api'
>>>>>>> 5e3d6db2bb58787c4423445d5b0a143b177cb33b
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
    trainer:{},
    tricks:[],
    allTricks:[],
    categoryTricks:[]
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
    },
    GET_TRICKS_BY_DOG(state,tricks){
      state.tricks=[...tricks]
    },
    GET_ALL_TRICKS(state,tricks){
      state.allTricks=[...tricks]
    },
    GET_TRICKS_BY_CATEGORY(state,categoryTricks){
      state.categoryTricks=[...categoryTricks]
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
    getTricksByADog(context,dogId){
      TrickApi.getTricksByADog(dogId)
      .then(res=>{
        context.commit('GET_TRICKS_BY_DOG', res.data)
      });
    },
    getAllTricks(context){
      TrickApi.getAllTricks()
      .then(res=>{
        context.commit('GET_ALL_TRICKS', res.data)
      });
    },
    getTricksByCategory(context, categoryName){
      TrickApi.getTricksByCategory(categoryName)
      .then(res=>{
        context.commit('GET_TRICKS_BY_CATEGORY', res.data)
        return res.data.length
      });
    }
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