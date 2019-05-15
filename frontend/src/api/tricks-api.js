import axios from 'axios';

export default{
    getAllTricks(){
        return axios.get(`http://localhost:8080/trick`)
    },
    getTricksByCategory(categoryName){
        return axios.get(`http://localhost:8080/trick/${categoryName}`)
    },
    getTricksByADog(dogId){
        return axios.get(`http://localhost:8080/dog/${dogId}/tricks`)
    },
}