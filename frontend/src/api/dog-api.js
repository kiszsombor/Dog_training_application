import axios from 'axios';

export default{
    getDogById(dogId){
        return axios.get(`http://localhost:8080/dog/${dogId}`);
    },

    getAllSeasonTicketsByDog(dogId){
        //http://localhost:8080/dog/1/season_tickets
        // return axios.get(`api/dog/${dogId}/season_tickets`);
        return axios.get(`http://localhost:8080/dog/${dogId}/season_tickets`);
    }

}