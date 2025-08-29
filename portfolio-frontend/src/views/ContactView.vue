
<!--<template>-->
<!--  <div class="section-box">-->
<!--    <h2>Kontakt</h2>-->
<!--    <form class="contact-form">-->
<!--      <label>Imię:</label>-->
<!--      <input type="text" placeholder="Twoje imię" />-->

<!--      <label>Email:</label>-->
<!--      <input type="email" placeholder="Twój email" />-->

<!--      <label>Wiadomość:</label>-->
<!--      <textarea placeholder="Twoja wiadomość"></textarea>-->

<!--      <button type="submit">Wyślij</button>-->
<!--    </form>-->
<!--  </div>-->
<!--</template>-->

<!--<style>-->
<!--.section-box {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  margin-bottom: 2rem;-->
<!--}-->

<!--.contact-form {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--.contact-form input,-->
<!--.contact-form textarea {-->
<!--  padding: 0.5rem 1rem;-->
<!--  border-radius: 0.5rem;-->
<!--  border: 1px solid #fbb6ce;-->
<!--  background: rgba(255, 255, 255, 0.9);-->
<!--}-->

<!--.contact-form button {-->
<!--  padding: 0.5rem 1rem;-->
<!--  background: #fbb6ce;-->
<!--  color: white;-->
<!--  font-weight: bold;-->
<!--  border-radius: 0.5rem;-->
<!--  border: none;-->
<!--  cursor: pointer;-->
<!--  transition: background 0.3s;-->
<!--}-->

<!--.contact-form button:hover {-->
<!--  background: #f687b3;-->
<!--}-->
<!--</style>-->

<!--<template>-->
<!--  <div class="contact-container">-->
<!--    <h2 class="section-title">Skontaktuj się ze mną</h2>-->
<!--    <form class="contact-form">-->
<!--      <input type="text" placeholder="Twoje imię" />-->
<!--      <input type="email" placeholder="Twój email" />-->
<!--      <textarea placeholder="Twoja wiadomość"></textarea>-->
<!--      <button type="submit">Wyślij</button>-->
<!--    </form>-->
<!--  </div>-->
<!--</template>-->

<!--<style scoped>-->
<!--.contact-container {-->
<!--  max-width: 900px;-->
<!--  margin: 2rem auto;-->
<!--  padding: 2rem;-->
<!--  /* opcjonalne lekko półprzezroczyste tło, ale bez box-shadow */-->
<!--  background: rgba(255, 255, 255, 0.6);-->
<!--  border-radius: 1rem;-->
<!--}-->

<!--.section-title {-->
<!--  font-size: 1.5rem;-->
<!--  color: #d6336c; /* pudrowy róż */-->
<!--  text-align: center;-->
<!--  margin-bottom: 1.5rem;-->
<!--}-->

<!--.contact-form {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1.5rem;-->
<!--}-->

<!--.contact-form input,-->
<!--.contact-form textarea {-->
<!--  width: 100%;-->
<!--  padding: 0.75rem 1rem;-->
<!--  border-radius: 0.5rem;-->
<!--  border: 1px solid #fbb6ce;-->
<!--  background: rgba(255, 255, 255, 0.9);-->
<!--  font-size: 1rem;-->
<!--}-->

<!--.contact-form textarea {-->
<!--  min-height: 250px;-->
<!--  resize: vertical;-->
<!--}-->

<!--.contact-form button {-->
<!--  align-self: flex-start;-->
<!--  padding: 0.5rem 1.5rem;-->
<!--  background: #fbb6ce;-->
<!--  color: white;-->
<!--  font-weight: bold;-->
<!--  border-radius: 0.5rem;-->
<!--  border: none;-->
<!--  cursor: pointer;-->
<!--  transition: background 0.3s;-->
<!--}-->

<!--.contact-form button:hover {-->
<!--  background: #f687b3;-->
<!--}-->

<!--/* Responsywność */-->
<!--@media (min-width: 768px) {-->
<!--  .contact-form {-->
<!--    gap: 2rem;-->
<!--  }-->

<!--  .contact-form input,-->
<!--  .contact-form textarea {-->
<!--    font-size: 1.1rem;-->
<!--  }-->

<!--  .contact-form textarea {-->
<!--    min-height: 300px;-->
<!--  }-->
<!--}-->
<!--</style>-->



<!--<template>-->
<!--  <div class="contact-container">-->
<!--    <h2 class="contact-title">Skontaktuj się ze mną</h2>-->
<!--    <form class="contact-form" @submit.prevent="submitForm">-->
<!--      <div class="form-group">-->
<!--        <label for="name">Imię i nazwisko</label>-->
<!--        <input type="text" id="name" v-model="form.name" required />-->
<!--      </div>-->

<!--      <div class="form-group">-->
<!--        <label for="email">Email</label>-->
<!--        <input type="email" id="email" v-model="form.email" required />-->
<!--      </div>-->

<!--      <div class="form-group">-->
<!--        <label for="message">Wiadomość</label>-->
<!--        <textarea id="message" v-model="form.message" rows="6" required></textarea>-->
<!--      </div>-->

<!--      <button type="submit" class="submit-btn">Wyślij wiadomość</button>-->
<!--    </form>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "ContactView",-->
<!--  data() {-->
<!--    return {-->
<!--      form: {-->
<!--        name: '',-->
<!--        email: '',-->
<!--        message: ''-->
<!--      }-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    submitForm() {-->
<!--      alert(`Dziękuję, ${this.form.name}! Twoja wiadomość została wysłana.`);-->
<!--      this.form.name = '';-->
<!--      this.form.email = '';-->
<!--      this.form.message = '';-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.contact-container {-->
<!--  width: 95%;-->
<!--  max-width: 900px;-->
<!--  margin: 2rem auto;-->
<!--  padding: 2rem;-->
<!--  background: rgba(255, 255, 255, 0.6); /* półprzezroczyste tło */-->
<!--  border-radius: 1rem;-->
<!--  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);-->
<!--}-->

<!--.contact-title {-->
<!--  font-size: 1.75rem;-->
<!--  margin-bottom: 1.5rem;-->
<!--  text-align: center;-->
<!--  color: #d6336c; /* pudrowy róż dla tytułu */-->
<!--}-->

<!--.contact-form {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--.form-group {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--}-->

<!--.form-group label {-->
<!--  margin-bottom: 0.5rem;-->
<!--  font-weight: 600;-->
<!--  color: #333;-->
<!--}-->

<!--.form-group input,-->
<!--.form-group textarea {-->
<!--  padding: 1rem 1.25rem;-->
<!--  border: 1px solid #ccc;-->
<!--  border-radius: 0.75rem;-->
<!--  font-size: 1rem;-->
<!--  font-family: inherit;-->
<!--  resize: vertical;-->
<!--}-->

<!--.form-group input:focus,-->
<!--.form-group textarea:focus {-->
<!--  outline: none;-->
<!--  border-color: #d6336c;-->
<!--  box-shadow: 0 0 0 3px rgba(214, 51, 108, 0.2);-->
<!--}-->

<!--.submit-btn {-->
<!--  padding: 0.75rem 1.5rem;-->
<!--  font-size: 1rem;-->
<!--  font-weight: 600;-->
<!--  color: white;-->
<!--  background: #d6336c;-->
<!--  border: none;-->
<!--  border-radius: 0.75rem;-->
<!--  cursor: pointer;-->
<!--  transition: background 0.3s;-->
<!--  align-self: flex-start;-->
<!--}-->

<!--.submit-btn:hover {-->
<!--  background: #e05587;-->
<!--}-->

<!--@media (min-width: 1024px) {-->
<!--  .contact-container {-->
<!--    width: 90%;-->
<!--  }-->
<!--}-->
<!--</style>-->






<!--<template>-->
<!--  <div class="section-box">-->
<!--    <h2>Kontakt</h2>-->
<!--    <form @submit.prevent="submitForm" class="contact-form">-->
<!--      <div class="form-row">-->
<!--        <label>-->
<!--          Imię:-->
<!--          <input v-model="name" type="text" required />-->
<!--        </label>-->
<!--        <label>-->
<!--          Email:-->
<!--          <input v-model="email" type="email" required />-->
<!--        </label>-->
<!--      </div>-->

<!--      <label class="full-width">-->
<!--        Wiadomość:-->
<!--        <textarea v-model="message" rows="8" required></textarea>-->
<!--      </label>-->

<!--      <button type="submit">Wyślij</button>-->
<!--    </form>-->
<!--    <p v-if="successMessage" class="success-msg">{{ successMessage }}</p>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "ContactView",-->
<!--  data() {-->
<!--    return {-->
<!--      name: '',-->
<!--      email: '',-->
<!--      message: '',-->
<!--      successMessage: ''-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    async submitForm() {-->
<!--      try {-->
<!--        const res = await fetch('http://localhost:8080/api/messages', {-->
<!--          method: 'POST',-->
<!--          headers: { 'Content-Type': 'application/json' },-->
<!--          body: JSON.stringify({-->
<!--            name: this.name,-->
<!--            email: this.email,-->
<!--            message: this.message-->
<!--          })-->
<!--        });-->
<!--        if (res.ok) {-->
<!--          this.successMessage = "Wiadomość wysłana!";-->
<!--          this.name = '';-->
<!--          this.email = '';-->
<!--          this.message = '';-->
<!--        } else {-->
<!--          alert("Błąd przy wysyłaniu wiadomości.");-->
<!--        }-->
<!--      } catch (err) {-->
<!--        console.error(err);-->
<!--        alert("Nie udało się połączyć z serwerem.");-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style>-->
<!--.section-box {-->
<!--  background: rgba(255, 255, 255, 0.7);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--  margin-bottom: 2rem;-->
<!--}-->

<!--/* Formularz responsywny */-->
<!--.contact-form {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--.form-row {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--label {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  font-weight: 500;-->
<!--  color: #d6336c;-->
<!--}-->

<!--input, textarea {-->
<!--  padding: 0.5rem;-->
<!--  border-radius: 0.5rem;-->
<!--  border: 1px solid #ccc;-->
<!--  font-size: 1rem;-->
<!--  margin-top: 0.25rem;-->
<!--  width: 100%;-->
<!--  box-sizing: border-box;-->
<!--}-->

<!--.full-width textarea {-->
<!--  min-height: 150px;-->
<!--}-->

<!--button {-->
<!--  background-color: #f687b3;-->
<!--  color: white;-->
<!--  border: none;-->
<!--  padding: 0.75rem 1.5rem;-->
<!--  border-radius: 0.5rem;-->
<!--  font-weight: bold;-->
<!--  cursor: pointer;-->
<!--  transition: background 0.3s;-->
<!--}-->
<!--button:hover {-->
<!--  background-color: #ff4d87;-->
<!--}-->

<!--.success-msg {-->
<!--  color: green;-->
<!--  margin-top: 1rem;-->
<!--  font-weight: 500;-->
<!--}-->

<!--/* Desktop: pola imię i email obok siebie */-->
<!--@media (min-width: 768px) {-->
<!--  .form-row {-->
<!--    flex-direction: row;-->
<!--    gap: 1rem;-->
<!--  }-->
<!--  .form-row label {-->
<!--    flex: 1;-->
<!--  }-->
<!--}-->
<!--</style>-->

<template>
  <div class="section-box">
    <h2>Kontakt</h2>
    <form @submit.prevent="submitForm" class="contact-form">
      <label>
        Imię:
        <input v-model="name" type="text" required />
      </label>

      <label>
        Email:
        <input v-model="email" type="email" required />
      </label>

      <label>
        Wiadomość:
        <textarea v-model="message" rows="8" required></textarea>
      </label>

      <button type="submit">Wyślij</button>
    </form>
    <p v-if="successMessage" class="success-msg">{{ successMessage }}</p>
  </div>
</template>

<script>
export default {
  name: "ContactView",
  data() {
    return {
      name: '',
      email: '',
      message: '',
      successMessage: ''
    }
  },
  methods: {
    async submitForm() {
      try {
        const res = await fetch('http://localhost:8080/api/messages', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            name: this.name,
            email: this.email,
            message: this.message
          })
        });
        if (res.ok) {
          this.successMessage = "Wiadomość wysłana!";
          this.name = '';
          this.email = '';
          this.message = '';
        } else {
          alert("Błąd przy wysyłaniu wiadomości.");
        }
      } catch (err) {
        console.error(err);
        alert("Nie udało się połączyć z serwerem.");
      }
    }
  }
}
</script>

<style>
.section-box {
  background: rgba(255, 255, 255, 0.7);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  margin-bottom: 2rem;
  max-width: 1000px; /* zwiększamy szerokość boxa */
  width: 90%;        /* zajmuje 90% dostępnej przestrzeni */
  margin-left: auto;
  margin-right: auto; /* centrujemy box */
}


/* Formularz zawsze w kolumnie */
.contact-form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

label {
  display: flex;
  flex-direction: column;
  font-weight: 500;
  color: #d6336c;
}

input, textarea {
  padding: 0.5rem;
  border-radius: 0.5rem;
  border: 1px solid #ccc;
  font-size: 1rem;
  margin-top: 0.25rem;
  width: 100%;
  box-sizing: border-box;
}

textarea {
  min-height: 150px;
}

button {
  background-color: #f687b3;
  color: white;
  border: none;
  padding: 0.75rem 1.5rem;
  border-radius: 0.5rem;
  font-weight: bold;
  cursor: pointer;
  transition: background 0.3s;
}
button:hover {
  background-color: #ff4d87;
}

.success-msg {
  color: green;
  margin-top: 1rem;
  font-weight: 500;
}
</style>
