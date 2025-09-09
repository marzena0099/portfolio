<template>
  <div class="app-container">
    <Navbar />

    <main class="main-content">
      <div class="section-box">
        <router-view />
      </div>
    </main>

    <Footer />
  </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue';
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

.main-content {
  flex: 1;
  display: flex;
  justify-content: center;
  padding: 2rem;
  position: relative;
}

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

.section-box {
  position: relative;
  z-index: 1;
  background: rgba(255, 255, 255, 0.9); /* tylko biały box z 90% przezroczystością */
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  width: 100%;
  max-width: 1000px;

  border: none;
  margin: 2rem auto;
}
</style>

