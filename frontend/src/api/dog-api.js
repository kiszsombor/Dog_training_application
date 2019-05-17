import axios from 'axios';

export default{

    getAllDogs(){
        return axios.get(`http://localhost:8080/dog`);
    },

    getDogById(dogId){
        return axios.get(`http://localhost:8080/dog/${dogId}`);
    },
    getDogsByTrainerId(trainerId){
        return axios.get(`http://localhost:8080/trainer/${trainerId}/dogs`);
    },

    getAllSeasonTicketsByDog(dogId){
        //http://localhost:8080/dog/1/season_tickets
        // return axios.get(`api/dog/${dogId}/season_tickets`);
        return axios.get(`http://localhost:8080/dog/${dogId}/season_tickets`);
    },

    deleteDogById(dogId){
        return axios.delete(`http://localhost:8080/dog/delete/${dogId}`)
    },

}