<!--<template>-->
<!--  <div class="app-container">-->
<!--    &lt;!&ndash; Nawigacja &ndash;&gt;-->
<!--    <Navbar />-->

<!--    &lt;!&ndash; Główna treść &ndash;&gt;-->
<!--    <main class="main-content">-->
<!--      <div class="section-box">-->
<!--        <router-view />-->
<!--      </div>-->
<!--&lt;!&ndash;      <div>&ndash;&gt;-->
<!--&lt;!&ndash;        <h1>Vue Icons Gallery</h1>&ndash;&gt;-->
<!--&lt;!&ndash;        <IconsGallery />&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--    </main>-->
<!--    <router-view /> &lt;!&ndash; twoje strony/sekcje &ndash;&gt;-->
<!--    <Footer />-->
<!--    &lt;!&ndash; Stopka &ndash;&gt;-->
<!--&lt;!&ndash;    <footer class="footer">&ndash;&gt;-->
<!--&lt;!&ndash;      © 2025 Moje Portfolio • Stworzone z ❤️&ndash;&gt;-->
<!--&lt;!&ndash;    </footer>&ndash;&gt;-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import Navbar from './components/Navbar.vue';-->
<!--import Footer from "@/components/Footer.vue";-->
<!--// import IconsGallery from "@/components/IconsGallery.vue";-->

<!--export default {-->
<!--  name: "App",-->
<!--  components: {Footer, Navbar }-->
<!--}-->



<template>
  <div class="app-container">
    <!-- Nawigacja -->
    <Navbar />

    <!-- Główna treść -->
    <main class="main-content">
      <div class="section-box">
        <router-view />
      </div>
    </main>

    <!-- Stopka -->
    <Footer />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue';
import Footer from "@/components/Footer.vue";

export default {
  name: "App",
  components: { Footer, Navbar }
}
</script>
<style>
.app-container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  background: #ffe6f0; /* pastelowy róż */
  color: #1f2937;
}

/* Główna treść */
.main-content {
  flex: 1;
  display: flex;
  justify-content: center;
  padding: 2rem;
  position: relative;
}

/* Nakładka obrazka kodu */
.main-content::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: url('@/assets/images/pexels-harold-vasquez-853421-2653362.jpg') no-repeat center center;
  background-size: cover;
  opacity: 0.15;
  z-index: 0;
}

/* Główny biały box z treścią */
.section-box {
  position: relative;
  z-index: 1;
  background: rgba(255, 255, 255, 0.9); /* tylko biały box z 90% przezroczystością */
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  width: 100%;
  max-width: 1000px;

  /* usuń dodatkowe białe obramowanie / padding w tle */
  border: none;
  margin: 2rem auto;
}
</style>


<!--<style>-->
<!--/* Bazowe tło strony - pastelowy róż */-->
<!--.app-container {-->
<!--  min-height: 100vh;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  background: #ffe6f0; /* pastelowy róż */-->
<!--  color: #1f2937;-->
<!--}-->

<!--/* Główna treść */-->
<!--.main-content {-->
<!--  flex: 1;-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--  padding: 2rem;-->
<!--  position: relative;-->
<!--}-->

<!--/* Nakładka obrazka kodu */-->
<!--.main-content::before {-->
<!--  content: "";-->
<!--  position: absolute;-->
<!--  top: 0;-->
<!--  left: 0;-->
<!--  right: 0;-->
<!--  bottom: 0;-->
<!--  background: url('@/assets/images/pexels-harold-vasquez-853421-2653362.jpg') no-repeat center center;-->
<!--  background-size: cover;-->
<!--  opacity: 0.15; /* przezroczystość obrazka */-->
<!--  z-index: 0;-->
<!--}-->

<!--/* Główny biały box z treścią */-->
<!--.section-box {-->
<!--  position: relative;-->
<!--  z-index: 1; /* nad obrazkiem */-->
<!--  background: rgba(255, 255, 255, 0.9); /* biały, 90% przezroczystości */-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  width: 100%;-->
<!--  max-width: 1000px;-->
<!--}-->

<!--/* Stopka */-->
<!--.footer {-->
<!--  background: rgba(255, 255, 255, 0.85);-->
<!--  backdrop-filter: blur(4px);-->
<!--  box-shadow: inset 0 2px 4px rgba(0,0,0,0.05);-->
<!--  padding: 1rem;-->
<!--  text-align: center;-->
<!--  font-size: 0.875rem;-->
<!--  color: #4b5563;-->
<!--}-->
<!--</style>-->
