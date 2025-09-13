<template>
  <section id="projects" class="section-box">
    <h2>Projekty</h2>

    <div v-for="(proj, index) in projects" :key="proj.id" class="card same-width">
      <h3 class="expandable-header" @click="toggleProject(index)">
        {{ proj.title }}
        <span class="triangle" :class="{ open: proj.open }">▼</span>
      </h3>

      <div v-show="proj.open" class="card-content">
        <p class="technologies-tooltip">
          <strong>Opis:</strong> {{ proj.description }}
        </p>

        <div class="project-tech-icons">
          <strong>Technologie:</strong>
          <div class="icons-list">
            <div v-for="tech in proj.technologies" :key="tech" class="tech-item">
              <img
                  :src="getIconPath(tech)"
                  :alt="tech"
                  :title="tech"
                  class="tech-icon"
              />
              <span class="tech-label">{{ tech }}</span>
            </div>
          </div>
        </div>

        <div class="project-links">
          <a v-if="proj.githubLink" :href="proj.githubLink" target="_blank">GitHub</a>
          <a :href="`/api/projects/download/${proj.id}`" download>Pobierz</a>
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
      projects: []
    };
  },
  mounted() {
    axios.get("/api/projects")
        .then(res => {
          this.projects = res.data.map(proj => ({
            ...proj,
            open: false,
            technologies: proj.technologies.split(",").map(t => t.trim())
          }));
        })
        .catch(err => console.error("Błąd pobierania projektów:", err));
  },
  methods: {
    toggleProject(index) {
      this.projects[index].open = !this.projects[index].open;
    },
    getIconPath(tech) {
      try {

        return new URL(`../assets/icons/${tech}.svg`, import.meta.url).href;
      } catch (e) {
        return new URL(`../assets/icons/default.svg`, import.meta.url).href;
      }
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

.same-width { max-width: 700px; }

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

.triangle.open { transform: rotate(180deg); }

.expandable-header {
  cursor: pointer;
  color: #1f2937;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.expandable-header:hover { color: #f687b3; }

.project-tech-icons { margin-top: 0.5rem; }

.icons-list {
  display: flex;
  flex-wrap: wrap;
  gap: 15px;
  margin-top: 5px;
}

.tech-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 12px;
  color: #333;
}

.tech-icon {
  width: 32px;
  height: 32px;
  transition: transform 0.2s ease;
  margin-bottom: 4px;
}

.tech-icon:hover { transform: scale(1.2); }

.tech-label { text-align: center; }

.project-links { margin-top: 10px; }

.project-links a {
  margin-right: 1rem;
  color: #f687b3;
  text-decoration: underline;
  font-weight: 600;
}
</style>
