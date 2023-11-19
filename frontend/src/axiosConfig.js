import axios from 'axios';

const instance = axios.create({
        // alterar o localhost pelo IP ou dominio do servidor na nuvem
        baseURL:' http://localhost:8080',
        headers: {
         'Origin': 'http://localhost:3000',
        },
});

export default instance;