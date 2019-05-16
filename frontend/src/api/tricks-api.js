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
    postDogTricks(dogId, trickId){
        return axios.post(`http://localhost:8080/trick/save/${dogId}/${trickId}`)
    },
    deleteDogTricksByDogIdAndTrickId(dogId, trickId){
        // console.log("api: ",seasonTicketId)
        return axios.delete(`http://localhost:8080/trick/delete/${dogId}/${trickId}`)
    },
}