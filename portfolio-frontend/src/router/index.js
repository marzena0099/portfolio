
import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import ProjectsView from "@/views/ProjectsView.vue";
import CvView from "@/views/CvView.vue";
import ContactView from "@/views/ContactView.vue";


const routes = [
  { path: '/', component: HomeView },
  { path: '/projects', component: ProjectsView },
  { path: '/cv', component: CvView },
  { path: '/contact', component: ContactView }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
