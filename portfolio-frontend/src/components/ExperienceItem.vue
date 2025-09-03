
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
