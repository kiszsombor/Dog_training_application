import axios from 'axios';

export default{

    addNewSeasonTicket(obj){
        console.log("API-add season ticket: ",obj)
        return axios.post(`http://localhost:8080/season_tickets/save`, obj)
        
    },
}