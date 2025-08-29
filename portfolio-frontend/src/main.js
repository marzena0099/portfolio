// import './assets/main.css'
//
// import { createApp } from 'vue'
// import App from './App.vue'
// import router from './router'
//
// const app = createApp(App)
//
// app.use(router)
//
// app.mount('#app')





import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import './assets/main.css'  // <-- tutaj Tailwind

createApp(App)
    .use(router)
    .mount('#app');
