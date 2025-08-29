<!--<template>-->
<!--  <div>-->
<!--    <h1>Kontakt</h1>-->
<!--    <p>Masz pytania? Napisz do mnie!</p>-->
<!--    <ContactForm />-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ContactForm from '../components/ContactForm.vue';-->

<!--export default {-->
<!--  components: { ContactForm }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--h1 {-->
<!--  margin-bottom: 1rem;-->
<!--}-->
<!--</style>-->
<template>
  <div class="contact-container">
    <h1 class="title">Kontakt</h1>
    <p class="subtitle">Masz pytania? Napisz do mnie!</p>
    <ContactForm />
  </div>
</template>

<script>
import ContactForm from '../components/ContactForm.vue';

export default {
  components: { ContactForm }
};
</script>

<style scoped>
.contact-container {
  max-width: 600px;
  margin: 2rem auto;
  padding: 2rem;
  background-color: #f9fafb; /* jasny szary */
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

.title {
  font-size: 2rem;
  font-weight: bold;
  color: #1D4ED8; /* niebieski */
  margin-bottom: 0.5rem;
}

.subtitle {
  font-size: 1.1rem;
  color: #4B5563; /* ciemniejszy szary */
  margin-bottom: 2rem;
}
</style>
