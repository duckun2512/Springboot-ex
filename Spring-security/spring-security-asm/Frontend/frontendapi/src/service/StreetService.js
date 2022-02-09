import axios from "axios";

const URL_STREETS = "http://localhost:8080/api/v1/streets";

class StreetService {
    getAll(params){
        return axios.get(URL_STREETS,{
            params: params,
        });
    }
    addStreet(body){
        return axios.post(URL_STREETS,body);
    }
    detail(id){
        return axios.get(URL_STREETS + "/" + id)
    }

}

export default new StreetService();