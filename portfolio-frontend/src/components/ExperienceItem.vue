<template>
  <div class="experience-item">
    <h4>{{ experience.title }} – {{ experience.company }}</h4>
    <p>{{ formattedDates }}</p>

    <ul>
      <li v-for="(line, index) in descriptionLines" :key="index">{{ line }}</li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { computed, defineProps } from 'vue';

interface Experience {
  title: string;
  company: string;
  startDate: string;
  endDate?: string;
  description?: string;
}

const props = defineProps<{
  experience: Experience
}>();


const formattedDates = computed(() => {
  const start = props.experience.startDate;
  const end = props.experience.endDate || 'present';
  return `${start} – ${end}`;
});


const descriptionLines = computed(() => {
  if (!props.experience.description) return [];
  return props.experience.description
      .split('\n')
      .map(line => line.trim())
      .filter(line => line.length > 0);
});
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
