<template>
  <div class="experience-item">
    <h4>{{ experience.title }} – {{ experience.company }}</h4>
    <p>{{ experience.year }}</p>
    <p>{{ experience.description }}</p>
  </div>
</template>

<script>
export default {
  props: {
    experience: { type: Object, required: true }
  }
};
</script>

<style scoped>
.experience-item {
  margin-bottom: 1rem;
  padding-bottom: 0.5rem;
  border-bottom: 1px solid #ddd;
}
</style>
