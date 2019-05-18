import axios from 'axios';
const BASE_URL = 'http://localhost:8080';

export default{
    
    addNewSeasonTicket(obj){
        console.log("API-add season ticket: ",obj)
        return axios.post(`${BASE_URL}/season_tickets/save`, obj)
    },
    deleteSeasonTicketById(seasonTicketId){
        // console.log("api: ",seasonTicketId)
        return axios.delete(`${BASE_URL}/season_tickets/delete/${seasonTicketId}`)
    },
}