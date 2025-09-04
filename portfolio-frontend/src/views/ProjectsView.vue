<!--<template>-->
<!--  <div>-->
<!--    <h1>Projects</h1>-->
<!--  </div>-->
<!--&lt;!&ndash;  <section id="projects" class="section-box">&ndash;&gt;-->
<!--&lt;!&ndash;    <h2>Projekty</h2>&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="projects-grid">&ndash;&gt;-->
<!--&lt;!&ndash;      <ProjectCard&ndash;&gt;-->
<!--&lt;!&ndash;          v-for="proj in projects"&ndash;&gt;-->
<!--&lt;!&ndash;          :key="proj.id"&ndash;&gt;-->
<!--&lt;!&ndash;          :project="proj"&ndash;&gt;-->
<!--&lt;!&ndash;      />&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--&lt;!&ndash;  </section>&ndash;&gt;-->
<!--</template>-->

<!--<script>-->
<!--import ProjectCard from "@/components/ProjectCard.vue";-->

<!--export default {-->
<!--  name: "Projects",-->
<!--  components: {ProjectCard}-->
<!--}-->

<!--</script>-->
<!--<style>-->
<!--.portfolio-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--}-->
<!--</style>-->

<!--<template>-->
<!--  <section id="projects" class="section-box">-->
<!--    <h2>Projekty</h2>-->
<!--    <div v-for="(proj, index) in projects" :key="index" class="card same-width">-->
<!--      <h3 class="expandable-header" @click="toggleProject(index)">-->
<!--        {{ proj.title }}-->
<!--        <span class="triangle" :class="{ open: proj.open }">▼</span>-->
<!--      </h3>-->
<!--      <div v-show="proj.open" class="card-content">-->
<!--        <p>{{ proj.description }}</p>-->
<!--        <div class="project-links">-->
<!--          <a v-if="proj.githubLink" :href="proj.githubLink" target="_blank">GitHub</a>-->
<!--          <a :href="`/api/projects/download/${proj.id}`" download>Pobierz</a>-->
<!--        </div>-->

<!--      </div>-->
<!--    </div>-->
<!--  </section>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      projects: [-->
<!--        {-->
<!--          id: 1,-->
<!--          title: "Projekt 1",-->
<!--          description: "Krótki opis projektu backendowego...",-->
<!--          githubLink: "https://github.com/TwojRepo/projekt1",-->
<!--          downloadLink: "", // jeśli nie ma GitHuba, backend generuje plik-->
<!--          open: false-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          title: "Projekt 2",-->
<!--          description: "Inny projekt backendowy...",-->
<!--          githubLink: "",-->
<!--          downloadLink: "", // link do pobrania generowany dynamicznie z id-->
<!--          open: false-->
<!--        }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    toggleProject(index) {-->
<!--      this.projects[index].open = !this.projects[index].open;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.section-box {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.card {-->
<!--  background: #fff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  margin-bottom: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.triangle {-->
<!--  display: inline-block;-->
<!--  margin-left: 0.5rem;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->

<!--.project-links a {-->
<!--  margin-right: 1rem;-->
<!--  color: #f687b3;-->
<!--  text-decoration: underline;-->
<!--  font-weight: 600;-->
<!--}-->

<!--.expandable-header {-->
<!--  cursor: pointer;-->
<!--  color: #1f2937;-->
<!--  display: flex;-->
<!--  align-items: center;-->
<!--  justify-content: space-between;-->
<!--}-->

<!--.expandable-header:hover {-->
<!--  color: #f687b3;-->
<!--}-->
<!--</style>-->


<template>
  <section id="projects" class="section-box">
    <h2>Projekty</h2>
    <div v-for="(proj, index) in projects" :key="proj.id" class="card same-width">
      <h3 class="expandable-header" @click="toggleProject(index)">
        {{ proj.title }}
        <span class="triangle" :class="{ open: proj.open }">▼</span>
      </h3>
      <div v-show="proj.open" class="card-content">
        <p>{{ proj.description }}</p>
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
</style>



<!--<template>-->
<!--  <section id="projects" class="section-box">-->
<!--    <h2>Projekty</h2>-->
<!--    <div v-for="(proj, index) in projects" :key="index" class="card same-width">-->
<!--      <h3 class="expandable-header" @click="toggleProject(index)">-->
<!--        {{ proj.title }}-->
<!--        <span class="triangle" :class="{ open: proj.open }">▼</span>-->
<!--      </h3>-->
<!--      <div v-show="proj.open" class="card-content">-->
<!--        <p>{{ proj.description }}</p>-->
<!--        <div class="project-links">-->
<!--          <a v-if="proj.githubLink" :href="proj.githubLink" target="_blank">GitHub</a>-->
<!--          <a v-if="proj.downloadLink" :href="proj.downloadLink" download>Pobierz</a>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </section>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      projects: [-->
<!--        {-->
<!--          title: "Projekt 1",-->
<!--          description: "Krótki opis projektu backendowego...",-->
<!--          githubLink: "https://github.com/TwojRepo/projekt1",-->
<!--          downloadLink: "", // jeśli nie ma githuba, podajesz link do pliku-->
<!--          open: false-->
<!--        },-->
<!--        {-->
<!--          title: "Projekt 2",-->
<!--          description: "Inny projekt backendowy...",-->
<!--          githubLink: "",-->
<!--          downloadLink: "/downloads/projekt2.zip",-->
<!--          open: false-->
<!--        }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    toggleProject(index) {-->
<!--      this.projects[index].open = !this.projects[index].open;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.card {-->
<!--  background: #fff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  margin-bottom: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->
<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->
<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->
<!--.triangle {-->
<!--  display: inline-block;-->
<!--  margin-left: 0.5rem;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->
<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->
<!--.project-links a {-->
<!--  margin-right: 1rem;-->
<!--  color: #f687b3;-->
<!--  text-decoration: underline;-->
<!--}-->
<!--</style>-->


<!--<template>-->
<!--  <section id="projects" class="portfolio-section section-box">-->
<!--    <h2>Projekty</h2>-->
<!--    <div class="projects-grid">-->
<!--      <div v-for="(proj, index) in projects" :key="proj.id" class="card same-width">-->
<!--        <h3 class="expandable-header" @click="toggleProject(index)">-->
<!--          {{ proj.title }}-->
<!--          <span class="triangle" :class="{ open: proj.open }">▼</span>-->
<!--        </h3>-->
<!--        <div v-show="proj.open" class="card-content">-->
<!--          <p>{{ proj.description }}</p>-->
<!--          <p><strong>Technologie:</strong> {{ proj.technologies }}</p>-->
<!--          <div class="links">-->
<!--            <a v-if="proj.githubLink" :href="proj.githubLink" target="_blank">GitHub</a>-->
<!--            <a v-if="proj.demoLink" :href="proj.demoLink" target="_blank">Demo</a>-->
<!--            <a v-if="proj.downloadLink" :href="proj.downloadLink" target="_blank">Pobierz</a>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </section>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "Projects",-->
<!--  data() {-->
<!--    return {-->
<!--      projects: [-->
<!--        {-->
<!--          id: 1,-->
<!--          title: "Portfolio Online",-->
<!--          description: "Responsywne portfolio z Vue i CSS, pokazujące doświadczenie i projekty.",-->
<!--          technologies: "Vue 3, HTML, CSS, JavaScript",-->
<!--          githubLink: "https://github.com/marzena0099/portfolio",-->
<!--          demoLink: "",-->
<!--          downloadLink: "",-->
<!--          open: false-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          title: "Aplikacja ToDo",-->
<!--          description: "Prosta aplikacja do zarządzania zadaniami z lokalnym przechowywaniem danych.",-->
<!--          technologies: "Vue 3, JavaScript, LocalStorage",-->
<!--          githubLink: "https://github.com/marzena0099/todo-app",-->
<!--          demoLink: "",-->
<!--          downloadLink: "",-->
<!--          open: false-->
<!--        }-->
<!--      ]-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    toggleProject(index) {-->
<!--      this.projects[index].open = !this.projects[index].open;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.portfolio-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.expandable-header {-->
<!--  display: flex;-->
<!--  align-items: center;-->
<!--  justify-content: space-between;-->
<!--  cursor: pointer;-->
<!--  color: #1f2937;-->
<!--  transition: color 0.3s ease;-->
<!--}-->

<!--.expandable-header:hover {-->
<!--  color: #f687b3;-->
<!--}-->

<!--.triangle {-->
<!--  display: inline-block;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  margin-left: 0.5rem;-->
<!--  vertical-align: middle;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->

<!--.links a {-->
<!--  margin-right: 1rem;-->
<!--  color: #2563eb;-->
<!--  text-decoration: underline;-->
<!--}-->
<!--</style>-->
