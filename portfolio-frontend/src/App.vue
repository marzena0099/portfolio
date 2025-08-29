
<!--<script>-->
<!--import Navbar from './components/Navbar.vue';-->
<!--export default { components: { Navbar } }-->
<!--</script>-->

<!--<template>-->
<!--  <div class="min-h-screen flex flex-col bg-gray-50 text-gray-800">-->
<!--    &lt;!&ndash; Nawigacja &ndash;&gt;-->
<!--    <nav class="bg-white shadow-md">-->
<!--      <div class="container mx-auto flex justify-between items-center p-4">-->
<!--        <h1 class="text-2xl font-bold text-blue-600">Moje Portfolio</h1>-->
<!--        <div class="space-x-4">-->
<!--          <router-link to="/" class="hover:text-blue-600">Home</router-link>-->
<!--          <router-link to="/projects" class="hover:text-blue-600">Projects</router-link>-->
<!--          <router-link to="/cv" class="hover:text-blue-600">CV</router-link>-->
<!--          <router-link to="/contact" class="hover:text-blue-600">Contact</router-link>-->

<!--        </div>-->
<!--      </div>-->
<!--    </nav>-->

<!--    &lt;!&ndash; Widok strony &ndash;&gt;-->
<!--    <main class="flex-1 container mx-auto p-6">-->
<!--      <router-view />-->
<!--    </main>-->

<!--    &lt;!&ndash; Stopka &ndash;&gt;-->
<!--    <footer class="bg-white shadow-inner p-4 text-center">-->
<!--      © 2025 Moje Portfolio-->
<!--    </footer>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import Navbar from './components/Navbar.vue';-->
<!--export default { components: { Navbar } }-->
<!--</script>-->

<!--<template>-->
<!--  <div class="min-h-screen flex flex-col bg-gray-50 text-gray-800">-->
<!--    &lt;!&ndash; Nawigacja &ndash;&gt;-->
<!--    <Navbar />-->

<!--    &lt;!&ndash; Widok strony &ndash;&gt;-->
<!--    <main class="flex-1 container mx-auto p-6">-->
<!--      <router-view />-->
<!--    </main>-->

<!--    &lt;!&ndash; Stopka &ndash;&gt;-->
<!--    <footer class="bg-white shadow-inner p-4 text-center">-->
<!--      © 2025 Moje Portfolio-->
<!--    </footer>-->
<!--  </div>-->
<!--</template>-->

<!--<style scoped>-->
<!--/* Tutaj Twoje style globalne App.vue */-->
<!--</style>-->
<script>
import Navbar from './components/Navbar.vue';
export default {
  name: 'App',
  components: { Navbar }
}
</script>

<template>
  <div class="app min-h-screen flex flex-col bg-gray-50 text-gray-800">
    <!-- Nawigacja -->
    <Navbar />

    <!-- Widok strony -->
    <main class="flex-1 container mx-auto p-6">
      <router-view />
    </main>

    <!-- Stopka -->
    <footer class="footer bg-white shadow-inner p-4 text-center">
      © 2025 Moje Portfolio
    </footer>
  </div>
</template>

<style scoped>
.app {
  font-family: Arial, sans-serif;
}

.footer {
  font-size: 0.9rem;
  color: #555;
}
</style>
