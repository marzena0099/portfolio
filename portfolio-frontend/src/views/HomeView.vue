<template>
  <div>
    <!-- O mnie + doświadczenie -->
    <section id="about">
      <h1>O mnie</h1>
      <p>{{ aboutText }}</p>

      <h2>Doświadczenie</h2>
      <div>
        <!-- Użycie komponentu ExperienceItem -->
        <ExperienceItem
            v-for="exp in experience"
            :key="exp.id"
            :experience="exp"
        />
      </div>
    </section>

    <!-- Projekty -->
    <section id="projects">
      <h2>Projekty</h2>
      <div class="projects-grid">
        <ProjectCard
            v-for="proj in projects"
            :key="proj.id"
            :project="proj"
        />
      </div>
    </section>

<!--    &lt;!&ndash; CV &ndash;&gt;-->
<!--    <section id="cv">-->
<!--      <h2>CV</h2>-->
<!--      <button @click="downloadCv">Pobierz CV</button>-->
<!--    </section>-->
  </div>
</template>

<script>
import ProjectCard from '../components/ProjectCard.vue';
import ExperienceItem from '../components/ExperienceItem.vue'; // <- importujemy komponent
import axios from 'axios';

export default {
  components: { ProjectCard, ExperienceItem }, // <- dodajemy komponent
  data() {
    return {
      aboutText: 'Cześć! Jestem Marzena i zajmuję się tworzeniem aplikacji webowych w Javie i Vue.',
      experience: [],
      projects: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/api/experience')
        .then(res => this.experience = res.data)
        .catch(err => console.error('Błąd pobierania experience:', err));

    axios.get('http://localhost:8080/api/projects')
        .then(res => this.projects = res.data)
        .catch(err => console.error('Błąd pobierania projects:', err));
  },
  // methods: {
  //   downloadCv() {
  //     axios.get('http://localhost:8080/api/cv', { responseType: 'blob' })
  //         .then(res => {
  //           const url = window.URL.createObjectURL(new Blob([res.data], { type: 'application/pdf' }));
  //           const link = document.createElement('a');
  //           link.href = url;
  //           link.setAttribute('download', 'MojeCV.pdf');
  //           document.body.appendChild(link);
  //           link.click();
  //           link.remove();
  //         })
  //         .catch(err => console.error('Błąd pobierania CV:', err));
  //   }
  // }
};
</script>

<!--<style scoped>-->
<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 1rem;-->
<!--}-->
<!--</style>-->
<style>
.home-section {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  text-align: center;
}
</style>