import axios from 'axios';
const BASE_URL = 'http://localhost:8080';
export default{

    

    getAllDogs(){
        return axios.get(`${BASE_URL}/dog`);
    },

    getDogById(dogId){
        return axios.get(`${BASE_URL}/dog/${dogId}`);
    },
    getDogsByTrainerId(trainerId){
        return axios.get(`${BASE_URL}/trainer/${trainerId}/dogs`);
    },

    getAllSeasonTicketsByDog(dogId){
        //http://localhost:8080/dog/1/season_tickets
        // return axios.get(`api/dog/${dogId}/season_tickets`);
        return axios.get(`${BASE_URL}/dog/${dogId}/season_tickets`);
    },

    deleteDogById(dogId){
        return axios.delete(`${BASE_URL}/dog/delete/${dogId}`)
    },

}