
<!--<template>-->
<!--  <div class="experience-item">-->
<!--    <h4>{{ experience.title }} – {{ experience.company }}</h4>-->
<!--    <p>{{ formattedDates }}</p>-->

<!--    &lt;!&ndash; Lista podpunktów &ndash;&gt;-->
<!--    <ul>-->
<!--      <li v-for="(line, index) in descriptionLines" :key="index">{{ line }}</li>-->
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
<!--      const end = this.experience.endDate || 'present';-->
<!--      return `${start} – ${end}`;-->
<!--    },-->
<!--    // Tworzymy tablicę z podpunktów rozdzielonych \n-->
<!--    descriptionLines() {-->
<!--      // if (!this.experience.description) return [];-->
<!--      // return this.experience.description-->
<!--      //     .split('\n')-->
<!--      //     .map(line => line.trim().replace(/^•\s*/, '')) // usuwa pierwszą kropkę i spację-->
<!--      //     .filter(line => line.length > 0);-->

<!--      if (!this.experience.description) return [];-->
<!--      return this.experience.description.split('\n').map(line => line.trim()).filter(line => line.length > 0);-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.experience-item {-->
<!--  margin-bottom: 1rem;-->
<!--  padding-bottom: 0.5rem;-->
<!--  border-bottom: 1px solid #ddd;-->
<!--}-->

<!--ul {-->
<!--  padding-left: 1.2rem;-->
<!--  margin-top: 0.5rem;-->
<!--}-->

<!--li {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--</style>-->

<template>
  <div class="experience-item">
    <!-- nagłówek: stanowisko i firma -->
    <div class="header">
      <h4 class="title">{{ experience.title }}</h4>
      <span class="company">{{ experience.company }}</span>
    </div>

    <!-- daty -->
    <p class="dates">{{ formattedDates }}</p>

    <!-- lista zadań -->
    <ul class="description">
      <li v-for="(line, index) in descriptionLines" :key="index">
        {{ line }}
      </li>
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
      const end = this.experience.endDate || "Obecnie";
      return `${start} – ${end}`;
    },
    descriptionLines() {
      if (!this.experience.description) return [];
      return this.experience.description
          .split("\n")
          .map(line => line.trim())
          .filter(line => line.length > 0);
    }
  }
};
</script>

<style scoped>
.experience-item {
  background: #ffffff;
  border-radius: 1rem;
  padding: 1.5rem;
  margin-bottom: 1.5rem;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.experience-item:hover {
  transform: translateY(-4px);
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.12);
}

/* nagłówek */
.header {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  margin-bottom: 0.5rem;
}

.title {
  font-size: 1.2rem;
  font-weight: 600;
  color: #1f2937; /* ciemny szary */
}

.company {
  font-size: 1rem;
  color: #2563eb; /* niebieski akcent */
  font-weight: 500;
  font-style: italic;
}

/* daty */
.dates {
  font-size: 0.95rem;
  color: #6b7280;
  margin-bottom: 0.8rem;
}

/* opis jako lista */
.description {
  padding-left: 1.5rem;
  color: #374151;
  line-height: 1.6;
}

.description li {
  list-style-type: disc;
  margin-bottom: 0.4rem;
}
</style>
