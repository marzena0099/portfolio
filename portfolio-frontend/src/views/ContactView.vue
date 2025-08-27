<template>
  <div>
    <h1>Kontakt</h1>
    <p>Masz pytania? Napisz do mnie!</p>
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
h1 {
  margin-bottom: 1rem;
}
</style>
