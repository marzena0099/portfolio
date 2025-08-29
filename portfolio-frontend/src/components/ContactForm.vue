<!--<template>-->
<!--  <form @submit.prevent="sendMessage">-->
<!--    <div>-->
<!--      <label for="name">Imię:</label>-->
<!--      <input type="text" id="name" v-model="form.name" required />-->
<!--    </div>-->

<!--    <div>-->
<!--      <label for="email">Email:</label>-->
<!--      <input type="email" id="email" v-model="form.email" required />-->
<!--    </div>-->

<!--    <div>-->
<!--      <label for="message">Wiadomość:</label>-->
<!--      <textarea id="message" v-model="form.message" required></textarea>-->
<!--    </div>-->

<!--    <button type="submit">Wyślij</button>-->

<!--    <p v-if="successMessage" style="color:green">{{ successMessage }}</p>-->
<!--    <p v-if="errorMessage" style="color:red">{{ errorMessage }}</p>-->
<!--  </form>-->
<!--</template>-->

<!--<script>-->
<!--import axios from 'axios';-->

<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      form: { name: '', email: '', message: '' },-->
<!--      successMessage: '',-->
<!--      errorMessage: ''-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    sendMessage() {-->
<!--      axios.post('http://localhost:8080/api/messages', this.form)-->
<!--          .then(() => {-->
<!--            this.successMessage = 'Wiadomość wysłana!';-->
<!--            this.errorMessage = '';-->
<!--            this.form = { name: '', email: '', message: '' };-->
<!--          })-->
<!--          .catch(() => {-->
<!--            this.errorMessage = 'Coś poszło nie tak, spróbuj ponownie.';-->
<!--            this.successMessage = '';-->
<!--          });-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--form div {-->
<!--  margin-bottom: 0.5rem;-->
<!--}-->
<!--input, textarea {-->
<!--  width: 100%;-->
<!--  padding: 0.5rem;-->
<!--  box-sizing: border-box;-->
<!--}-->
<!--button {-->
<!--  padding: 0.5rem 1rem;-->
<!--  cursor: pointer;-->
<!--}-->
<!--</style>-->
<template>
  <form @submit.prevent="sendMessage" class="form">
    <div class="form-group">
      <label for="name">Imię:</label>
      <input type="text" id="name" v-model="form.name" required />
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="form.email" required />
    </div>

    <div class="form-group">
      <label for="message">Wiadomość:</label>
      <textarea id="message" v-model="form.message" required></textarea>
    </div>

    <button type="submit">Wyślij</button>

    <p v-if="successMessage" class="success">{{ successMessage }}</p>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
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
.form {
  display: flex;
  flex-direction: column;
}

.form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 1.5rem;
}

label {
  margin-bottom: 0.5rem;
  font-weight: 500;
  color: #374151; /* ciemny szary */
}

input, textarea {
  padding: 0.75rem;
  border: 1px solid #D1D5DB; /* jasny szary */
  border-radius: 8px;
  font-size: 1rem;
}

textarea {
  min-height: 120px;
  resize: vertical;
}

button {
  background-color: #1D4ED8; /* niebieski */
  color: white;
  padding: 0.75rem 1rem;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: 500;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #2563EB; /* ciemniejszy niebieski */
}

.success {
  color: #16A34A; /* zielony */
  margin-top: 1rem;
}

.error {
  color: #DC2626; /* czerwony */
  margin-top: 1rem;
}
</style>
