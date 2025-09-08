<template>

  <section id="projects" class="section-box">
    <h2>Projekty</h2>
    <div v-for="(proj, index) in projects" :key="proj.id" class="card same-width">
      <h3 class="expandable-header" @click="toggleProject(index)">
        {{ proj.title }}
        <span class="triangle" :class="{ open: proj.open }">▼</span>
      </h3>
      <div v-show="proj.open" class="card-content">
        <p
            class="technologies-tooltip"
            :title="'Opis projektu:\n' + proj.description"
        >
          <strong>Opis:</strong> {{ proj.description }}

        </p>

        <p
            class="technologies-tooltip"
            :title="'Technologie użyte w projekcie:\n' + proj.technologies"
        >
          <strong>Technologie:</strong> {{ proj.technologies }}
        </p>


      <div class="project-links">
          <a v-if="proj.githubLink" :href="proj.githubLink" target="_blank">GitHub</a>
          <a :href="`http://localhost:8080/api/projects/download/${proj.id}`" download>
            Pobierz
          </a>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      projects: [] // tu już pusta tablica, bo uzupełni ją backend
    };
  },
  mounted() {
    axios.get("http://localhost:8080/api/projects")
        .then(res => {
          // dodajemy "open: false" do każdego projektu, żeby działał akordeon
          this.projects = res.data.map(proj => ({ ...proj, open: false }));
        })
        .catch(err => console.error("Błąd pobierania projektów:", err));
  },
  methods: {
    toggleProject(index) {
      this.projects[index].open = !this.projects[index].open;
    }
  }
};
</script>

<style scoped>
.section-box {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  max-width: 1000px;
  margin: 2rem auto;
}

.card {
  background: #fff;
  border-radius: 1rem;
  padding: 1rem;
  margin-bottom: 1rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.card:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 16px rgba(0,0,0,0.12);
}

.same-width {
  max-width: 700px;
}

.triangle {
  display: inline-block;
  margin-left: 0.5rem;
  width: 0;
  height: 0;
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  border-top: 8px solid #f687b3;
  transition: transform 0.3s ease;
}

.triangle.open {
  transform: rotate(180deg);
}

.project-links a {
  margin-right: 1rem;
  color: #f687b3;
  text-decoration: underline;
  font-weight: 600;
}

.expandable-header {
  cursor: pointer;
  color: #1f2937;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.expandable-header:hover {
  color: #f687b3;
}

  .technologies-tooltip {
    display: block;        /* <-- to wymusza nową linię */
    margin: 0.5rem 0;      /* odstęp między opisem a technologiami */
    cursor: help;
    padding: 4px 6px;
    border-radius: 6px;
    transition: background 0.3s ease, color 0.3s ease;
  }

  .technologies-tooltip:hover {
    background: rgba(246, 135, 179, 0.15);
    color: #f687b3;
  }

</style>

