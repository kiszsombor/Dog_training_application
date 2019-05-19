import axios from 'axios';
import { longStackSupport } from 'q';
//const BASE_URL = 'https://infinite-dawn-75023.herokuapp.com';
const BASE_URL = 'http://localhost:8080';

export default{

    //http://localhost:8080/trainer/login

    login(obj){
        const token = btoa(`${obj.username}:${obj.password}`)
        return axios.post(`${BASE_URL}/trainer/login`, {}, {
            headers: { Authorization: `Basic ${token}` }
        })
        .then(res =>{
            window.localStorage.setItem('token', token)
            return Promise.resolve(res.data)
        })
    },

    logout() {
        window.localStorage.removeItem('token')
    }
}