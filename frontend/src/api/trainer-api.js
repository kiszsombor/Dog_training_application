import axios from 'axios';
//const BASE_URL = 'https://infinite-dawn-75023.herokuapp.com';
const BASE_URL = 'http://localhost:8080';

export default{
    getTrainerById(trainerId){
        return axios.get(`${BASE_URL}/trainer/${trainerId}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        });
    },
    getTrainerByUserName(username){
        return axios.get(`${BASE_URL}/trainer/user/${username}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        });
    },
    registration(obj){
        //console.log("registration - api ",obj)
        return axios.post(`${BASE_URL}/trainer/registration`,obj, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        });
    }

}