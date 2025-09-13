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
        const res = await fetch('/api/messages', {
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
