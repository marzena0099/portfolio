<template>
  <div>
    <h1>Projects</h1>
  </div>
<!--  <section id="projects" class="section-box">-->
<!--    <h2>Projekty</h2>-->
<!--    <div class="projects-grid">-->
<!--      <ProjectCard-->
<!--          v-for="proj in projects"-->
<!--          :key="proj.id"-->
<!--          :project="proj"-->
<!--      />-->
<!--    </div>-->
<!--  </section>-->
</template>

<script>
import ProjectCard from "@/components/ProjectCard.vue";

export default {
  name: "Projects",
  components: {ProjectCard}
}

</script>
<style>
.portfolio-section {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}
</style>