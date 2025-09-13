<template>
  <div class="home">
    <section id="about" class="about-section section-box">
      <div class="profile-container">

        <div class="profile-top">
          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />

          <div class="profile-contact-wrapper">
            <div class="profile-header">
              <h1>Marzena Białończyk</h1>
              <p class="title">Programistka Java</p>
            </div>

            <div class="contact-card card short-card">
              <h2>Dane kontaktowe</h2>
              <ul class="contact-info">
                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>
                <li><strong>Tel:</strong> +48 516 083 143</li>
                <li><strong>LinkedIn:</strong>
                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>
                </li>
                <li><strong>GitHub:</strong>
                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>
                </li>
              </ul>
            </div>
          </div>
        </div>

        <div class="profile-bottom">
          <div class="card same-width">
            <h2 class="expandable-header" @click="toggleExperience">
              Doświadczenie
              <span class="triangle" :class="{ open: experienceOpen }">▼</span>
            </h2>
            <div v-show="experienceOpen" class="card-content">
              <div class="experience-list">
                <ExperienceItem
                    v-for="exp in experience"
                    :key="exp.id"
                    :experience="exp"
                />
              </div>
            </div>
          </div>

          <div v-for="(section, index) in sections" :key="index" class="card same-width">
            <h2 class="expandable-header" @click="toggleSection(index)">
              {{ section.title }}
              <span v-if="section.title==='Kim jestem'" class="fancy-question">
    ❓
    <span class="fancy-text">🌟 Dowiedz się więcej o mnie</span>
  </span>
              <span v-else class="triangle" :class="{ open: section.open }">▼</span>
            </h2>

            <div v-show="section.open" class="card-content">

              <div v-if="section.title === 'Kim jestem'" class="personal-container">
                <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />
                <div class="personal-info">
                  <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>
                  <p class="extra-highlight">🌟 Odkryj, czym się pasjonuję poza kodem!</p>
                </div>
              </div>

              <div v-else>
                <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>
              </div>

            </div>
          </div>

        </div>
      </div>
    </section>
  </div>
</template>

<script>
import ExperienceItem from "@/components/ExperienceItem.vue";
import axios from "axios";

export default {
  components: { ExperienceItem },
  data() {
    return {
      experience: [],
      experienceOpen: false,
      sections: [
        { title: "O mnie", content: [
            "Jestem programistką Java z zamiłowaniem do tworzenia backendu i frontendu – w Javie korzystam z Vue.js.",
    "Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań.",
              "Chętnie podejmuję współpracę przy różnorodnych projektach," +
              "gdzie mogę rozwijać swoje umiejętności, eksperymentować z nowymi technologiami i wspólnie tworzyć " +
              "funkcjonalne, przemyślane rozwiązania."
          ], open: false },
        { title: "Umiejętności techniczne", content: [
            " Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence," +
            "testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów"
          ], open: false },
        { title: "Języki obce", content: ["Angielski: B1+"] , open: false },
        { title: "Kim jestem", content: [
            "Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.",
            "Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.",
            "Łączę techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach."
          ], open: false }
      ]
    };
  },
  mounted() {
    axios.get("/api/experience")
        .then(res => this.experience = res.data)
        .catch(err => console.error("Błąd pobierania experience:", err));
  },
  methods: {
    toggleSection(index) {
      this.sections[index].open = !this.sections[index].open;
    },
    toggleExperience() {
      this.experienceOpen = !this.experienceOpen;
    }
  }
};
</script>

<style scoped>
.about-section {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  max-width: 1000px;
  margin: 2rem auto;
}

.profile-top {
  display: flex;
  gap: 2rem;
  align-items: flex-start;
}

.profile-image {
  width: 250px;
  border-radius: 1rem;
  object-fit: cover;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.profile-contact-wrapper {
  display: flex;
  flex-direction: column;
  flex: 1;
}

.profile-header h1 {
  margin-bottom: 0.3rem;
}

.profile-header .title {
  font-weight: 600;
  color: #f687b3;
  margin-bottom: 1rem;
}

.card {
  background: #ffffff;
  border-radius: 1rem;
  padding: 1rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  margin-bottom: 1rem;
}

.card:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 16px rgba(0,0,0,0.12);
}

.short-card {
  max-width: 300px;
}

.same-width {
  max-width: 700px;
}

.profile-bottom {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  margin-top: 2rem;
}

.experience-list {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  max-width: 700px;
}

.contact-info {
  list-style: none;
  padding: 0;
  margin: 0.5rem 0 0.5rem 0;
}

.contact-info li {
  margin-bottom: 0.25rem;
}

.personal-container {
  display: flex;
  gap: 1rem;
  align-items: flex-start;
}

.personal-image {
  width: 200px;
  border-radius: 1rem;
  object-fit: cover;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.personal-info {
  flex: 1;
}

.extra-highlight {
  margin-top: 0.5rem;
  font-weight: 600;
  color: #f687b3;
  font-style: italic;
}

.expandable-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  cursor: pointer;
  color: #1f2937;
  transition: color 0.3s ease;
}

.expandable-header:hover {
  color: #f687b3; /* różowy przy hover */
}

.triangle {
  display: inline-block;
  width: 0;
  height: 0;
  margin-left: 0.5rem;
  vertical-align: middle;
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  border-top: 8px solid #f687b3;
  transition: transform 0.3s ease;
}

.triangle.open {
  transform: rotate(180deg);
}

/* Pytajnik dla „Kim jestem” */
.fancy-question {
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  color: #f687b3;
  cursor: pointer;
  transition: transform 0.3s ease, color 0.3s ease;
}

.fancy-question:hover {
  transform: scale(1.2) rotate(10deg);
}

.fancy-text {
  font-weight: 600;
  color: #f687b3;
}


</style>

