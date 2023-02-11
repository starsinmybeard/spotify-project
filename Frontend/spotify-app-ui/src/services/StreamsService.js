import axios from 'axios';



const http = axios.create({
    baseURL: "http://localhost:3000",
    headers: {
        'Access-Control-Allow-Origin' : '*',
        'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        }
});


export default {

    getAllStreams(){
        return http.get('/');
    },

    fillDbFromFile(){
        return http.post('/');
    },
    
}