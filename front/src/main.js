import { createApp } from 'vue'
import App from './App.vue'
import router from './router'; 
import axios from 'axios';

// axios 기본 URL 설정
axios.defaults.baseURL = 'http://localhost:8080';

const app = createApp(App);
app.use(router);
app.mount('#app');