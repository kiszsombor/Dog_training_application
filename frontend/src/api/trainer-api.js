import axios from 'axios';
const BASE_URL = 'http://localhost:8080';

export default{
    getTrainerById(trainerId){
        return axios.get(`${BASE_URL}/trainer/${trainerId}`);
    },

}