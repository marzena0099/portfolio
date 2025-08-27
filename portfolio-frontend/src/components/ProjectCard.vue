<template>
  <div class="project-card">
    <h3>{{ project.title }}</h3>
    <p>{{ project.description }}</p>
    <p><strong>Technologie:</strong> {{ project.technologies }}</p>
    <div class="links">
      <a v-if="project.githubLink" :href="project.githubLink" target="_blank">GitHub</a>
      <a v-if="project.demoLink" :href="project.demoLink" target="_blank">Demo</a>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    project: { type: Object, required: true }
  }
};
</script>

<style scoped>
.project-card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
  width: 300px;
}
.links a {
  margin-right: 1rem;
  color: blue;
  text-decoration: underline;
}
</style>
