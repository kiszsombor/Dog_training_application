import axios from 'axios';
//const BASE_URL = 'https://infinite-dawn-75023.herokuapp.com';
const BASE_URL = 'http://localhost:8080';

export default{
    
    addNewSeasonTicket(obj){
        console.log("API-add season ticket: ",obj)
        return axios.post(`${BASE_URL}/season_tickets/save`, obj, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
    deleteSeasonTicketById(seasonTicketId){
        // console.log("api: ",seasonTicketId)
        return axios.delete(`${BASE_URL}/season_tickets/delete/${seasonTicketId}`, {
            headers: { Authorization: `Basic ${window.localStorage.getItem('token')}` }
        })
    },
}