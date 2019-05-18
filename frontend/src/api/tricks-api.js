import axios from 'axios';
const BASE_URL = 'http://localhost:8080';

export default{
    getAllTricks(){
        return axios.get(`${BASE_URL}/trick`)
    },
    getTricksByCategory(categoryName){
        return axios.get(`${BASE_URL}/trick/${categoryName}`)
    },
    getTricksByADog(dogId){
        return axios.get(`${BASE_URL}/dog/${dogId}/tricks`)
    },
    postDogTricks(dogId, trickId){
        return axios.post(`${BASE_URL}/trick/save/${dogId}/${trickId}`)
    },
    deleteDogTricksByDogIdAndTrickId(dogId, trickId){
        // console.log("api: ",seasonTicketId)
        return axios.delete(`${BASE_URL}/trick/delete/${dogId}/${trickId}`)
    },
}