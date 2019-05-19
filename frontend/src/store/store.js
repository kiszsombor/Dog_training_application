import Vue from 'vue'
import Vuex from 'vuex'
import DogApi from '../api/dog-api'
import SeasonTicketApi from '../api/season-tickets-api'
import TrainerApi from '../api/trainer-api'
import TrickApi from '../api/tricks-api'
import Login from '../api/login-api';
import axios from 'axios';

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
    // status: '',
    // token: localStorage.getItem('token') || '',
    me:{},


    dog:{},
    dogs:[],
    seasonTickets: [],
    trainer:{},
    owner:{},
    trainerDogs:[],
    tricks:[],
    allTricks:[],
    dogTricksCategory:[],
    categoryTricks:[],
 	  users:[]
  },
  mutations: { 
    GET_ALL_DOGS(state,dogs){
      state.dogs=[...dogs]
    },
    INIT_DOG_BY_ID(state,dog){
      state.dog=dog
    },
    INIT_DOGS_BY_TRAINER(state,trainerDogs){
      state.trainerDogs=[...trainerDogs]
    },
    DELETE_DOG(state,dog){
      delete state.dogs[dog];
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
    GET_OWNER_BY_DOG(state,owner){
      state.owner=owner;
    },
    GET_TRICKS_BY_DOG(state,tricks){
      state.tricks=[...tricks]
    },
    GET_ALL_TRICKS(state,tricks){
      state.allTricks=[...tricks]
    },
    GET_TRICKS_BY_CATEGORY(state,categoryTricks){
      state.categoryTricks=[...categoryTricks]
    },
    GET_TRICKS_BY_DOG_AND_CATEGORY(state,dogTricksCategory){
      state.dogTricksCategory=[...dogTricksCategory]
    },
    ADD_NEW_DOG_TRICKS(state, dogTrick){
      state.tricks.push(dogTrick)
    },
    DELETE_DOG_TRICKS(state, dogTrick){
      delete state.tricks[dogTrick];
    },

    GET_TRAINER_BY_USERNAME(state,trainer){
      state.trainer=trainer
    },

    REGISTRATION(state,user){
      state.users.push(user)

    },

    LOGIN(state,me){

      state.me=me;
      console.log("mutation state me", state.me)
    },
    LOGOUT(state){
      state.me={}
    }

   },
  actions: {  
    getAllDogs(context){
      DogApi.getAllDogs()
      .then(res=>{
        context.commit('GET_ALL_DOGS', res.data)
      });
    },
    deleteDogById(context, dogId){
      DogApi.deleteDogById(dogId)
      .then(res=>{
          // console.log("Res.data delete: ",res.data)
          context.commit('DELETE_DOG', res.data)
          return Promise.resolve()
      })
    },
    getDogById(context,dogID){
      DogApi.getDogById(dogID)
      .then(res=>{
        context.commit('INIT_DOG_BY_ID',res.data)
      })
    },
    getDogsByTrainerId(context,trainerId){
      DogApi.getDogsByTrainerId(trainerId)
      .then(res=>{
        context.commit('INIT_DOGS_BY_TRAINER',res.data)
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
    getOwnerByDog(context,dogId){
      DogApi.getOwnerByDog(dogId)
      .then(res=>{
        context.commit('GET_OWNER_BY_DOG', res.data)
      });
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
    },
    getTricksByADogAndCategory(context,{dogId,categoryName}){
      TrickApi.getTricksByDogIdAndCategory(dogId,categoryName)
      .then(res=>{
        context.commit('GET_TRICKS_BY_DOG_AND_CATEGORY', res.data)
        return res.data.length
      });
    },
    addDogTricks(context,{dogId,trickId}){
      return TrickApi.postDogTricks(dogId,trickId)
          .then(res => {
              context.commit('ADD_NEW_DOG_TRICKS', res.data)
              return Promise.resolve()
          })
  },
    deleteDogTricksByDogIdAndTrickId(context, {dogId, trickId}){
      TrickApi.deleteDogTricksByDogIdAndTrickId(dogId, trickId)
      .then(res=>{
          // console.log("Res.data delete: ",res.data)
          context.commit('DELETE_DOG_TRICKS', res.data)
          return Promise.resolve()
    })
  },

  getTrainerByUserName(context, username){
    TrainerApi.getTrainerByUserName(username)
    .then(res=>{
      context.commit('GET_TRAINER_BY_USERNAME', res.data)
      //return res.data
    });
  },





  registration(context,user){
    TrainerApi.registration({...user})
    .then(res=>{
      console.log("STORE: reg: ", res.data);
      context.commit('REGISTRATION', res.data);
     // return Promise().resolve();
    })
    
},

  login(context, payload){
    console.log("Store",payload)
    Login.login({...payload})
      .then(loggedinUser=>{
        console.log("loggedinUser: ",loggedinUser)
        context.commit('LOGIN', loggedinUser)
        return Promise.resolve()
    })
  },
  logout(context){
    Login.logout()
      .then(context.commit('LOGOUT', loggedinUser))
  },
  







  },
  deleteDogById(context,dogId){
    DogApi.deleteDogById(dogId)
    .then(res=>{
        // console.log("Res.data delete: ",res.data)
        context.commit('DELETE_DOG', res.data)
        return Promise.resolve()
  })
},
getters : {
  isLoggedIn: state => !!state.token,
  authStatus: state => state.status,
}
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