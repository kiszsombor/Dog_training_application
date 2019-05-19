import axios from 'axios';
const BASE_URL = 'http://localhost:8080';

export default{
    getTrainerById(trainerId){
        return axios.get(`${BASE_URL}/trainer/${trainerId}`);
    },
    registration(obj){
        //console.log("registration - api ",obj)
        return axios.post(`${BASE_URL}/trainer/registration`,obj);
    }

}