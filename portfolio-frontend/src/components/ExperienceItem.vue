
<template>
  <div class="experience-item">
    <h4>{{ experience.title }} – {{ experience.company }}</h4>
    <p>{{ formattedDates }}</p>

    <!-- Lista podpunktów -->
    <ul>
      <li v-for="(line, index) in descriptionLines" :key="index">{{ line }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    experience: { type: Object, required: true }
  },
  computed: {
    formattedDates() {
      const start = this.experience.startDate;
      const end = this.experience.endDate || 'present';
      return `${start} – ${end}`;
    },
    // Tworzymy tablicę z podpunktów rozdzielonych \n
    descriptionLines() {
      // if (!this.experience.description) return [];
      // return this.experience.description
      //     .split('\n')
      //     .map(line => line.trim().replace(/^•\s*/, '')) // usuwa pierwszą kropkę i spację
      //     .filter(line => line.length > 0);

      if (!this.experience.description) return [];
      return this.experience.description.split('\n').map(line => line.trim()).filter(line => line.length > 0);
    }
  }
};
</script>

<style scoped>
.experience-item {
  margin-bottom: 1rem;
  padding-bottom: 0.5rem;
  border-bottom: 1px solid #ddd;
}

ul {
  padding-left: 1.2rem;
  margin-top: 0.5rem;
}

li {
  margin-bottom: 0.3rem;
}
</style>

<!--<template>-->
<!--  <div class="experience-item">-->
<!--    &lt;!&ndash; nagłówek: stanowisko i firma &ndash;&gt;-->
<!--    <div class="header">-->
<!--      <h4 class="title">{{ experience.title }}</h4>-->
<!--      <span class="company">{{ experience.company }}</span>-->
<!--    </div>-->

<!--    &lt;!&ndash; daty &ndash;&gt;-->
<!--    <p class="dates">{{ formattedDates }}</p>-->

<!--    &lt;!&ndash; lista zadań &ndash;&gt;-->
<!--    <ul class="description">-->
<!--      <li v-for="(line, index) in descriptionLines" :key="index">-->
<!--        {{ line }}-->
<!--      </li>-->
<!--    </ul>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  props: {-->
<!--    experience: { type: Object, required: true }-->
<!--  },-->
<!--  computed: {-->
<!--    formattedDates() {-->
<!--      const start = this.experience.startDate;-->
<!--      const end = this.experience.endDate || "Obecnie";-->
<!--      return `${start} – ${end}`;-->
<!--    },-->
<!--    descriptionLines() {-->
<!--      if (!this.experience.description) return [];-->
<!--      return this.experience.description-->
<!--          .split("\n")-->
<!--          .map(line => line.trim())-->
<!--          .filter(line => line.length > 0);-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.experience-item {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem;-->
<!--  margin-bottom: 1.5rem;-->
<!--  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.experience-item:hover {-->
<!--  transform: translateY(-4px);-->
<!--  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.12);-->
<!--}-->

<!--/* nagłówek */-->
<!--.header {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--  align-items: baseline;-->
<!--  margin-bottom: 0.5rem;-->
<!--}-->

<!--.title {-->
<!--  font-size: 1.2rem;-->
<!--  font-weight: 600;-->
<!--  color: #1f2937; /* ciemny szary */-->
<!--}-->

<!--.company {-->
<!--  font-size: 1rem;-->
<!--  color: #2563eb; /* niebieski akcent */-->
<!--  font-weight: 500;-->
<!--  font-style: italic;-->
<!--}-->

<!--/* daty */-->
<!--.dates {-->
<!--  font-size: 0.95rem;-->
<!--  color: #6b7280;-->
<!--  margin-bottom: 0.8rem;-->
<!--}-->

<!--/* opis jako lista */-->
<!--.description {-->
<!--  padding-left: 1.5rem;-->
<!--  color: #374151;-->
<!--  line-height: 1.6;-->
<!--}-->

<!--.description li {-->
<!--  list-style-type: disc;-->
<!--  margin-bottom: 0.4rem;-->
<!--}-->
<!--</style>-->







<!--<template>-->
<!--  <div>-->
<!--    &lt;!&ndash; Sekcja O mnie &ndash;&gt;-->
<!--    <section class="section-box">-->
<!--      <h2>O mnie</h2>-->
<!--      <p>Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu, jak i frontendu…</p>-->
<!--    </section>-->

<!--    &lt;!&ndash; Sekcja Doświadczenie (jedna chmurka akordeonu) &ndash;&gt;-->
<!--    <section class="section-box">-->
<!--      <div class="section-header" @click="toggleExperience">-->
<!--        <h2>Doświadczenie</h2>-->
<!--        <span class="triangle" :class="{ open: isExperienceOpen }"></span>-->
<!--      </div>-->

<!--      <transition name="expand">-->
<!--        <div v-show="isExperienceOpen" class="experience-content">-->
<!--          <ExperienceItem-->
<!--              v-for="exp in experience"-->
<!--              :key="exp.id"-->
<!--              :experience="exp"-->
<!--          />-->
<!--        </div>-->
<!--      </transition>-->
<!--    </section>-->

<!--    &lt;!&ndash; Sekcja Projekty &ndash;&gt;-->
<!--    <section class="section-box">-->
<!--      <h2>Projekty</h2>-->
<!--      <div class="projects-grid">-->
<!--        <ProjectCard-->
<!--            v-for="proj in projects"-->
<!--            :key="proj.id"-->
<!--            :project="proj"-->
<!--        />-->
<!--      </div>-->
<!--    </section>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ProjectCard from '../components/ProjectCard.vue';-->
<!--import ExperienceItem from '../components/ExperienceItem.vue';-->
<!--import axios from 'axios';-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      projects: [],-->
<!--      isExperienceOpen: false-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get('http://localhost:8080/api/experience')-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error(err));-->

<!--    axios.get('http://localhost:8080/api/projects')-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error(err));-->
<!--  },-->
<!--  methods: {-->
<!--    toggleExperience() {-->
<!--      this.isExperienceOpen = !this.isExperienceOpen;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.section-box {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem 2rem;-->
<!--  margin: 1.5rem 0;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: box-shadow 0.2s ease;-->
<!--}-->

<!--.section-box:hover { box-shadow: 0 6px 16px rgba(0,0,0,0.12); }-->

<!--.section-header {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--  align-items: center;-->
<!--  cursor: pointer;-->
<!--  color: #f687b3;-->
<!--  font-weight: 600;-->
<!--}-->

<!--.triangle {-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->
<!--.triangle.open { transform: rotate(180deg); }-->

<!--.expand-enter-active, .expand-leave-active { transition: all 0.3s ease; }-->
<!--.expand-enter-from, .expand-leave-to { max-height: 0; opacity: 0; overflow: hidden; }-->
<!--.expand-enter-to, .expand-leave-from { max-height: 2000px; opacity: 1; }-->
<!--</style>-->
