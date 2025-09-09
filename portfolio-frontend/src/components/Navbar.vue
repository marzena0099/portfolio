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
  gap: 2rem;
  padding: 1rem 3rem;
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
