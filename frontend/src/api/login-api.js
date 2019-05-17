import axios from 'axios';

export default{

    //http://localhost:8080/trainer/login

    login(obj){
        console.log("Api:" , obj)
        return axios.post(`http://localhost:8080/trainer/login`, obj);
    },
}