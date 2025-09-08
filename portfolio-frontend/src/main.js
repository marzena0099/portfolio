import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/main.css'

// Font Awesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faFacebook, faLinkedin, faGithub } from '@fortawesome/free-brands-svg-icons'

library.add(faFacebook, faLinkedin, faGithub)

const app = createApp(App)

app.component('font-awesome-icon', FontAwesomeIcon)

app.use(router).mount('#app')
