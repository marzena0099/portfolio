<!--<template>-->
<!--  <nav>-->
<!--    <a href="/">Home</a>-->
<!--    <a href="/projects">Projects</a>-->
<!--    <a href="/cv">CV</a>-->
<!--    <a href="/contact">Contact</a>-->
<!--  </nav>-->
<!--</template>-->

<!--<script>-->
<!--export default {}-->
<!--</script>-->

<!--<style scoped>-->
<!--nav a { margin-right: 1rem; }-->
<!--</style>-->


<!--<template>-->
<!--  <nav class="navbar">-->
<!--    <router-link-->
<!--        v-for="tab in tabs"-->
<!--        :key="tab.name"-->
<!--        :to="tab.route"-->
<!--        class="nav-link"-->
<!--        :class="{ active: isActive(tab.route) }"-->
<!--    >-->
<!--      {{ tab.name }}-->
<!--    </router-link>-->
<!--  </nav>-->
<!--</template>-->

<!--<script>-->
<!--import { useRoute } from 'vue-router';-->

<!--export default {-->
<!--  name: "Navbar",-->
<!--  setup() {-->
<!--    const route = useRoute();-->

<!--    const tabs = [-->
<!--      { name: 'Home', route: '/' },-->
<!--      { name: 'Projekty', route: '/projects' },-->
<!--      { name: 'CV', route: '/cv' },-->
<!--      { name: 'Kontakt', route: '/contact' },-->
<!--    ];-->

<!--    const isActive = (tabRoute) => route.path === tabRoute;-->

<!--    return { tabs, isActive };-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.navbar {-->
<!--  display: flex;-->
<!--  gap: 1.5rem;-->
<!--  justify-content: center;-->
<!--  padding: 1rem 2rem; /* zwiększamy padding poziomy */-->
<!--  background: rgba(255, 255, 255, 0.85); /* lekko bardziej kryjące tło */-->
<!--  border-radius: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px; /* szerzej niż wcześniej */-->
<!--  margin: 1rem auto; /* trochę odstępu od góry */-->
<!--}-->

<!--.nav-link {-->
<!--  text-decoration: none;-->
<!--  color: #1f2937;-->
<!--  font-weight: 500;-->
<!--  padding: 0.5rem 1rem;-->
<!--  border-radius: 0.5rem;-->
<!--  transition: background 0.3s, color 0.3s;-->
<!--}-->

<!--.nav-link:hover {-->
<!--  background-color: #fbb6ce33; /* lekkie pudrowe podświetlenie */-->
<!--  color: #f687b3;-->
<!--}-->

<!--.nav-link.active {-->
<!--  background-color: #fbb6ce;-->
<!--  color: white;-->
<!--}-->
<!--</style>-->

<template>
  <nav class="navbar">
    <router-link to="/" class="nav-link">Home</router-link>
    <router-link to="/projects" class="nav-link">Projekty</router-link>
    <router-link to="/cv" class="nav-link">CV</router-link>
    <router-link to="/contact" class="nav-link">Kontakt</router-link>
  </nav>
</template>

<script>
export default {
  name: "Navbar"
};
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: center;
  gap: 2rem; /* odległość między linkami */
  padding: 1rem 3rem; /* szerokie okno */
  background: linear-gradient(90deg, #ffe6f0, #fff5f8, #ffd1e5);
  border-radius: 1.5rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  max-width: 1200px;
  margin: 1rem auto;
  flex-wrap: wrap; /* responsywność */
}

.nav-link {
  position: relative;
  padding: 0.5rem 1rem;
  text-decoration: none;
  color: #1f2937;
  font-weight: 600;
  transition: color 0.3s, background 0.3s;
}

.nav-link:hover {
  color: #f687b3;
}

/* pionowe linie między linkami */
.nav-link:not(:last-child)::after {
  content: "";
  position: absolute;
  right: -1rem;
  top: 0.25rem;
  height: 1.5rem;
  width: 2px;
  background: rgba(0,0,0,0.1);
  transition: background 0.3s, height 0.3s;
}

/* efekt hover na liniach */
.nav-link:hover::after {
  background: #f687b3;
  height: 2rem;
}
</style>
