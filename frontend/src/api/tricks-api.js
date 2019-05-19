import axios from 'axios';
// const BASE_URL = 'https://infinite-dawn-75023.herokuapp.com';
const BASE_URL = 'http://localhost:8080';



export default{
    getAllTricks(){
        return axios.get(`${BASE_URL}/trick`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    getTricksByCategory(categoryName){
        return axios.get(`${BASE_URL}/trick/${categoryName}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    getTricksByADog(dogId){
        return axios.get(`${BASE_URL}/dog/${dogId}/tricks`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    getTricksByDogIdAndCategory(dogId,categoryName){
        return axios.get(`${BASE_URL}/dog/${dogId}/tricks/${categoryName}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    postDogTricks(dogId, trickId){
        return axios.post(`${BASE_URL}/trick/save/${dogId}/${trickId}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    deleteDogTricksByDogIdAndTrickId(dogId, trickId){
        // console.log("api: ",seasonTicketId)
        return axios.delete(`${BASE_URL}/trick/delete/${dogId}/${trickId}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
}