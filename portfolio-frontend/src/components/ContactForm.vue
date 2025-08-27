<template>
  <form @submit.prevent="sendMessage">
    <div>
      <label for="name">Imię:</label>
      <input type="text" id="name" v-model="form.name" required />
    </div>

    <div>
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="form.email" required />
    </div>

    <div>
      <label for="message">Wiadomość:</label>
      <textarea id="message" v-model="form.message" required></textarea>
    </div>

    <button type="submit">Wyślij</button>

    <p v-if="successMessage" style="color:green">{{ successMessage }}</p>
    <p v-if="errorMessage" style="color:red">{{ errorMessage }}</p>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      form: { name: '', email: '', message: '' },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    sendMessage() {
      axios.post('http://localhost:8080/api/messages', this.form)
          .then(() => {
            this.successMessage = 'Wiadomość wysłana!';
            this.errorMessage = '';
            this.form = { name: '', email: '', message: '' };
          })
          .catch(() => {
            this.errorMessage = 'Coś poszło nie tak, spróbuj ponownie.';
            this.successMessage = '';
          });
    }
  }
};
</script>

<style scoped>
form div {
  margin-bottom: 0.5rem;
}
input, textarea {
  width: 100%;
  padding: 0.5rem;
  box-sizing: border-box;
}
button {
  padding: 0.5rem 1rem;
  cursor: pointer;
}
</style>
