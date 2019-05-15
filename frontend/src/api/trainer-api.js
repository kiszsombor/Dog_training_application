import axios from 'axios';

export default{
    getTrainerById(trainerId){
        return axios.get(`http://localhost:8080/trainer/${trainerId}`);
    },

}