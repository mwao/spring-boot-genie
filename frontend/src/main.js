// main.js
import { createApp } from 'vue';
import App from './App.vue';
import router from '@/router/';
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// createApp(App).mount('#app')

import axios from 'axios'
axios.defaults.baseURL='http://localhost:8282'

const app = createApp(App);
app.config.globalProperties.axios=axios;
app.use(router);
app.use(ElementPlus);
app.mount('#app');

