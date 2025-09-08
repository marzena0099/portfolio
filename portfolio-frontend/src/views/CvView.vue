<template>
  <div class="section-box cv-section">
    <h2>Moje CV</h2>
    <p>Pobierz moje CV klikając przycisk poniżej:</p>
    <button class="cv-button" @click="downloadCv">Pobierz CV</button>
  </div>
</template>

<script>
export default {
  name: 'CvView',
  methods: {
    downloadCv() {
      // Tworzymy dynamiczny link do pobrania
      const link = document.createElement('a');
      link.href = '/cv.pdf'; // ścieżka do pliku CV
      link.download = 'Marzena_Bialonczyk_CV.pdf';
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    }
  }
};
</script>

<style>
.cv-section {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  text-align: center;
}

.cv-button {
  display: inline-block;
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  background: #fbb6ce;
  color: white;
  border-radius: 0.5rem;
  font-weight: bold;
  border: none;
  cursor: pointer;
  transition: background 0.3s;
}

.cv-button:hover {
  background: #f687b3;
}
</style>
