import axios from 'axios';
const BASE_URL = 'http://localhost:8080';

export default{

    //http://localhost:8080/trainer/login

    login(obj){
        console.log("Api:" , obj)
        return axios.post(`${BASE_URL}/trainer/login`, obj);
    },
}