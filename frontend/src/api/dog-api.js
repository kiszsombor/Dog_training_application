import axios from 'axios';
//const BASE_URL = 'https://infinite-dawn-75023.herokuapp.com';
const BASE_URL = 'http://localhost:8080';

export default{

    

    getAllDogs(){
        return axios.get(`${BASE_URL}/dog`
        // , {
        //     headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        // }
        
        );
    },

    getDogById(dogId){
        return axios.get(`${BASE_URL}/dog/${dogId}`
        // , {
        //     headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        // }
        );
    },

    getDogsByTrainerId(trainerId){
        return axios.get(`${BASE_URL}/trainer/${trainerId}/dogs`
        // , {
        //     headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        // }
        );
    },

    getOwnerByDog(dogId){
        return axios.get(`${BASE_URL}/dog/${dogId}/owner`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        });
    },

    getAllSeasonTicketsByDog(dogId){
        //http://localhost:8080/dog/1/season_tickets
        // return axios.get(`api/dog/${dogId}/season_tickets`);
        return axios.get(`${BASE_URL}/dog/${dogId}/season_tickets`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        });
    },

    deleteDogById(dogId){
        return axios.delete(`${BASE_URL}/dog/delete/${dogId}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },

}