import axios from "axios";

const URL_DISTRICT = "http://localhost:8080/api/v1/districts";

class DistrictService {
    getAll(){
        return axios.get(URL_DISTRICT);
    }

}

export default new DistrictService();