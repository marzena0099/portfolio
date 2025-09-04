<template>
  <div class="home">
    <section id="about" class="about-section section-box">
      <div class="profile-container">

        <!-- Górna część: zdjęcie + dane kontaktowe -->
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

        <!-- Doświadczenie (wyżej niż reszta sekcji) -->
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

          <!-- Inne sekcje akordeonowe -->
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
    axios.get("http://localhost:8080/api/experience")
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

/* Karty */
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

/* Nagłówki akordeonu */
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

/* Trójkąty różowe */
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

<!--<template>-->
<!--  <div class="home">-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="profile-contact-wrapper">-->
<!--            <div class="profile-header">-->
<!--              <h1>Marzena Białończyk</h1>-->
<!--              <p class="title">Programistka Java</p>-->
<!--            </div>-->

<!--            <div class="contact-card card short-card">-->
<!--              <h2>Dane kontaktowe</h2>-->
<!--              <ul class="contact-info">-->
<!--                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--                <li><strong>Tel:</strong> +48 516 083 143</li>-->
<!--                <li><strong>LinkedIn:</strong>-->
<!--                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--                </li>-->
<!--                <li><strong>GitHub:</strong>-->
<!--                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Doświadczenie &ndash;&gt;-->
<!--        <div class="profile-bottom">-->
<!--          <div class="card same-width">-->
<!--            <h2 class="expandable-header" @click="toggleExperience">-->
<!--              Doświadczenie-->
<!--              <span class="triangle" :class="{ open: experienceOpen }">▼</span>-->
<!--            </h2>-->
<!--            <div v-show="experienceOpen" class="card-content">-->
<!--              <div class="experience-list">-->
<!--                <ExperienceItem-->
<!--                    v-for="exp in experience"-->
<!--                    :key="exp.id"-->
<!--                    :experience="exp"-->
<!--                />-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->

<!--          &lt;!&ndash; Inne sekcje akordeonowe &ndash;&gt;-->
<!--          <div v-for="(section, index) in sections" :key="index" class="card same-width">-->
<!--            <h2 class="expandable-header" @click="toggleSection(index)">-->
<!--              {{ section.title }}-->
<!--              <span class="triangle" :class="{ open: section.open }">-->
<!--                &lt;!&ndash; Specjalnie dla "Kim jestem" ekstra ikona &ndash;&gt;-->
<!--                <span v-if="section.title==='Kim jestem'">❓</span>-->
<!--                <span v-else>▼</span>-->
<!--              </span>-->
<!--            </h2>-->
<!--            <div v-show="section.open" class="card-content">-->

<!--              <div v-if="section.title === 'Kim jestem'" class="personal-container">-->
<!--                <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->
<!--                <div class="personal-info">-->
<!--                  <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--                  <p class="extra-highlight">🌟 Odkryj, czym się pasjonuję poza kodem!</p>-->
<!--                </div>-->
<!--              </div>-->

<!--              <div v-else>-->
<!--                <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--              </div>-->

<!--            </div>-->
<!--          </div>-->

<!--        </div>-->
<!--      </div>-->
<!--    </section>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      experienceOpen: false,-->
<!--      sections: [-->
<!--        { title: "O mnie", content: [-->
<!--            "Jestem programistką Java z zamiłowaniem do backendu i frontendu.",-->
<!--            "Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań."-->
<!--          ], open: false },-->
<!--        { title: "Umiejętności techniczne", content: [-->
<!--            "Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence"-->
<!--          ], open: false },-->
<!--        { title: "Języki obce", content: ["Angielski: B1+"] , open: false },-->
<!--        { title: "Kim jestem", content: [-->
<!--            "Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.",-->
<!--            "Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.",-->
<!--            "Łączę techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach."-->
<!--          ], open: false }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->
<!--  },-->
<!--  methods: {-->
<!--    toggleSection(index) {-->
<!--      this.sections[index].open = !this.sections[index].open;-->
<!--    },-->
<!--    toggleExperience() {-->
<!--      this.experienceOpen = !this.experienceOpen;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.about-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-contact-wrapper {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-header h1 {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--.profile-header .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--/* Karty */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--.short-card {-->
<!--  max-width: 300px;-->
<!--}-->

<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  max-width: 700px;-->
<!--}-->

<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 0.5rem 0;-->
<!--}-->
<!--.contact-info li {-->
<!--  margin-bottom: 0.25rem;-->
<!--}-->

<!--.personal-container {-->
<!--  display: flex;-->
<!--  gap: 1rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.personal-image {-->
<!--  width: 200px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--.extra-highlight {-->
<!--  margin-top: 0.5rem;-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  font-style: italic;-->
<!--}-->

<!--/* Trójkąty różowe */-->
<!--.triangle {-->
<!--  display: inline-block;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  margin-left: 0.5rem;-->
<!--  vertical-align: middle;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->
<!--</style>-->


<!--<template>-->
<!--  <div class="home">-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="profile-contact-wrapper">-->
<!--            <div class="profile-header">-->
<!--              <h1>Marzena Białończyk</h1>-->
<!--              <p class="title">Programistka Java</p>-->
<!--            </div>-->

<!--            <div class="contact-card card short-card">-->
<!--              <h2>Dane kontaktowe</h2>-->
<!--              <ul class="contact-info">-->
<!--                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--                <li><strong>Tel:</strong> +48 516 083 143</li>-->
<!--                <li><strong>LinkedIn:</strong>-->
<!--                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--                </li>-->
<!--                <li><strong>GitHub:</strong>-->
<!--                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Dolne sekcje z akordeonem &ndash;&gt;-->
<!--        <div class="profile-bottom">-->
<!--          <div v-for="(section, index) in sections" :key="index" class="card same-width">-->
<!--            <h2 class="expandable-header"-->
<!--                @click="toggleSection(index)"-->
<!--                :class="{ active: section.open }"-->
<!--            >-->
<!--              {{ section.title }}-->
<!--              <span class="triangle" :class="{ open: section.open }">▼</span>-->
<!--            </h2>-->
<!--            <div v-show="section.open" class="card-content">-->

<!--              &lt;!&ndash; Specjalnie dla "Kim jestem" dodajemy zdjęcie &ndash;&gt;-->
<!--              <div v-if="section.title === 'Kim jestem'" class="personal-container">-->
<!--                <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->
<!--                <div class="personal-info">-->
<!--                  <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--                </div>-->
<!--              </div>-->

<!--              &lt;!&ndash; Pozostałe sekcje pozostają tylko tekstem &ndash;&gt;-->
<!--              <div v-else>-->
<!--                <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--              </div>-->

<!--            </div>-->
<!--          </div>-->

<!--          &lt;!&ndash; Doświadczenie &ndash;&gt;-->
<!--          <div class="card same-width">-->
<!--            <h2 class="expandable-header"-->
<!--                @click="toggleExperience"-->
<!--                :class="{ active: experienceOpen }"-->
<!--            >-->
<!--              Doświadczenie-->
<!--              <span class="triangle" :class="{ open: experienceOpen }">▼</span>-->
<!--            </h2>-->
<!--            <div v-show="experienceOpen" class="card-content">-->
<!--              <div class="experience-list">-->
<!--                <ExperienceItem-->
<!--                    v-for="exp in experience"-->
<!--                    :key="exp.id"-->
<!--                    :experience="exp"-->
<!--                />-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->

<!--        </div>-->
<!--      </div>-->
<!--    </section>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      experienceOpen: false,-->
<!--      sections: [-->
<!--        { title: "O mnie", content: [-->
<!--            "Jestem programistką Java z zamiłowaniem do backendu i frontendu.",-->
<!--            "Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań."-->
<!--          ], open: false },-->
<!--        { title: "Umiejętności techniczne", content: [-->
<!--            "Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence"-->
<!--          ], open: false },-->
<!--        { title: "Języki obce", content: ["Angielski: B1+"] , open: false },-->
<!--        { title: "Kim jestem", content: [-->
<!--            "Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.",-->
<!--            "Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.",-->
<!--            "Łączę techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach."-->
<!--          ], open: false }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->
<!--  },-->
<!--  methods: {-->
<!--    toggleSection(index) {-->
<!--      this.sections[index].open = !this.sections[index].open;-->
<!--    },-->
<!--    toggleExperience() {-->
<!--      this.experienceOpen = !this.experienceOpen;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.about-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-contact-wrapper {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-header h1 {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--.profile-header .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--/* Karty */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--  margin-bottom: 1rem;-->
<!--  cursor: pointer;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--.card.active, .card:hover .expandable-header {-->
<!--  color: #f687b3;-->
<!--}-->

<!--.short-card {-->
<!--  max-width: 300px;-->
<!--}-->

<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 0.5rem 0;-->
<!--}-->
<!--.contact-info li {-->
<!--  margin-bottom: 0.25rem;-->
<!--}-->

<!--/* Sekcja Kim jestem */-->
<!--.personal-container {-->
<!--  display: flex;-->
<!--  gap: 1rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.personal-image {-->
<!--  width: 200px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--/* Fikuśny trójkąt różowy */-->
<!--.triangle {-->
<!--  display: inline-block;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  margin-left: 0.5rem;-->
<!--  vertical-align: middle;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->

<!--.expandable-header {-->
<!--  display: flex;-->
<!--  align-items: center;-->
<!--  justify-content: space-between;-->
<!--  margin: 0;-->
<!--  font-size: 1.2rem;-->
<!--  transition: color 0.3s ease;-->
<!--}-->

<!--.expandable-header:hover {-->
<!--  color: #f687b3;-->
<!--}-->

<!--.expandable-header.active {-->
<!--  color: #f687b3;-->
<!--}-->

<!--.card-content {-->
<!--  margin-top: 0.8rem;-->
<!--  line-height: 1.6;-->
<!--}-->
<!--</style>-->



<!--<template>-->
<!--  <div class="home">-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="profile-contact-wrapper">-->
<!--            <div class="profile-header">-->
<!--              <h1>Marzena Białończyk</h1>-->
<!--              <p class="title">Programistka Java</p>-->
<!--            </div>-->

<!--            <div class="contact-card card short-card">-->
<!--              <h2>Dane kontaktowe</h2>-->
<!--              <ul class="contact-info">-->
<!--                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--                <li><strong>Tel:</strong> +48 516 083 143</li>-->
<!--                <li><strong>LinkedIn:</strong>-->
<!--                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--                </li>-->
<!--                <li><strong>GitHub:</strong>-->
<!--                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Dolne sekcje z akordeonem &ndash;&gt;-->
<!--        <div class="profile-bottom">-->
<!--          <div v-for="(section, index) in sections" :key="index" class="card same-width">-->
<!--            <h2 class="expandable-header" @click="toggleSection(index)">-->
<!--              {{ section.title }}-->
<!--              <span class="triangle" :class="{ open: section.open }">▼</span>-->
<!--            </h2>-->
<!--            <div v-show="section.open" class="card-content">-->

<!--              &lt;!&ndash; Specjalnie dla "Kim jestem" dodajemy zdjęcie &ndash;&gt;-->
<!--              <div v-if="section.title === 'Kim jestem'" class="personal-container">-->
<!--                <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->
<!--                <div class="personal-info">-->
<!--                  <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--                </div>-->
<!--              </div>-->

<!--              &lt;!&ndash; Pozostałe sekcje pozostają tylko tekstem &ndash;&gt;-->
<!--              <div v-else>-->
<!--                <p v-for="(line, idx) in section.content" :key="idx">{{ line }}</p>-->
<!--              </div>-->

<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Doświadczenie &ndash;&gt;-->
<!--               <h2>Doświadczenie</h2>-->
<!--                <div class="experience-list">-->
<!--                  <ExperienceItem-->
<!--                      v-for="exp in experience"-->
<!--                      :key="exp.id"-->
<!--                      :experience="exp"-->
<!--                  />-->
<!--                </div>-->

<!--              </div>-->
<!--            </section>-->

<!--          </div>-->
<!--        </template>-->


<!--<script>-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      sections: [-->
<!--        { title: "O mnie", content: [-->
<!--            "Jestem programistką Java z zamiłowaniem do backendu i frontendu.",-->
<!--            "Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań."-->
<!--          ], open: false },-->
<!--        { title: "Umiejętności techniczne", content: [-->
<!--            "Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence"-->
<!--          ], open: false },-->
<!--        { title: "Języki obce", content: ["Angielski: B1+"] , open: false },-->
<!--        { title: "Kim jestem", content: [-->
<!--            "Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.",-->
<!--            "Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.",-->
<!--            "Łączę techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach."-->
<!--          ], open: false }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->
<!--  },-->
<!--  methods: {-->
<!--    toggleSection(index) {-->
<!--      this.sections[index].open = !this.sections[index].open; // przełączanie-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.about-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-contact-wrapper {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-header h1 {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--.profile-header .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--/* Karty */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->





<!--.short-card {-->
<!--  max-width: 300px;-->
<!--}-->

<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  max-width: 700px;-->
<!--}-->

<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 0.5rem 0;-->
<!--}-->
<!--.contact-info li {-->
<!--  margin-bottom: 0.25rem;-->
<!--}-->

<!--/* Sekcja Kim jestem */-->
<!--.personal-container {-->
<!--  display: flex;-->
<!--  gap: 1rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.personal-image {-->
<!--  width: 200px; /* mniejsze niż główne zdjęcie */-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--/* Fikuśny trójkąt różowy */-->
<!--.triangle {-->
<!--  display: inline-block;-->
<!--  width: 0;-->
<!--  height: 0;-->
<!--  margin-left: 0.5rem;-->
<!--  vertical-align: middle;-->
<!--  border-left: 6px solid transparent;-->
<!--  border-right: 6px solid transparent;-->
<!--  border-top: 8px solid #f687b3; /* różowy odcień pasujący do nagłówków */-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.triangle.open {-->
<!--  transform: rotate(180deg);-->
<!--}-->


<!--</style>-->



<!--<template>-->
<!--  <div class="home">-->

<!--    &lt;!&ndash; Sekcja: O mnie &ndash;&gt;-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="profile-contact-wrapper">-->
<!--            <div class="profile-header">-->
<!--              <h1>Marzena Białończyk</h1>-->
<!--              <p class="title">Programistka Java</p>-->
<!--            </div>-->

<!--            <div class="contact-card card short-card">-->
<!--              <h2>Dane kontaktowe</h2>-->
<!--              <ul class="contact-info">-->
<!--                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--                <li><strong>Tel:</strong> +48 516 083 143</li>-->
<!--                <li><strong>LinkedIn:</strong>-->
<!--                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--                </li>-->
<!--                <li><strong>GitHub:</strong>-->
<!--                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Dolne akordeony: O mnie, Umiejętności, Języki &ndash;&gt;-->
<!--        <div class="profile-bottom">-->
<!--          <div-->
<!--              class="card same-width accordion"-->
<!--              :class="{ open: openSection === 'about' }"-->
<!--              @click="toggleSection('about')"-->
<!--          >-->
<!--            <h2>O mnie</h2>-->
<!--            <div class="accordion-content">-->
<!--              <p>-->
<!--                Jestem programistką Java z zamiłowaniem do tworzenia backendu i frontendu – w pracy korzystam z Vue.js.-->
<!--                Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań.-->
<!--              </p>-->
<!--            </div>-->
<!--          </div>-->

<!--          <div-->
<!--              class="card same-width accordion"-->
<!--              :class="{ open: openSection === 'skills' }"-->
<!--              @click="toggleSection('skills')"-->
<!--          >-->
<!--            <h2>Umiejętności techniczne</h2>-->
<!--            <div class="accordion-content">-->
<!--              <p>-->
<!--                Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,-->
<!--                testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów-->
<!--              </p>-->
<!--            </div>-->
<!--          </div>-->

<!--          <div-->
<!--              class="card same-width accordion"-->
<!--              :class="{ open: openSection === 'languages' }"-->
<!--              @click="toggleSection('languages')"-->
<!--          >-->
<!--            <h2>Języki obce</h2>-->
<!--            <div class="accordion-content">-->
<!--              <p>Angielski: B1+</p>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Doświadczenie &ndash;&gt;-->
<!--        <h2>Doświadczenie</h2>-->
<!--        <div class="experience-list">-->
<!--          <ExperienceItem-->
<!--              v-for="exp in experience"-->
<!--              :key="exp.id"-->
<!--              :experience="exp"-->
<!--          />-->
<!--        </div>-->

<!--      </div>-->
<!--    </section>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      openSection: null, // który akordeon jest otwarty-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->
<!--  },-->
<!--  methods: {-->
<!--    toggleSection(section) {-->
<!--      this.openSection = this.openSection === section ? null : section;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.about-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-contact-wrapper {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: flex-start;-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-header h1 {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--.profile-header .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--/* Karty */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease, max-height 0.3s ease;-->
<!--  margin-bottom: 1rem;-->
<!--  cursor: pointer;-->
<!--}-->
<!--.card:hover {-->
<!--  transform: translateY(-2px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--/* Kontakt przy zdjęciu */-->
<!--.short-card {-->
<!--  max-width: 300px;-->
<!--}-->

<!--/* Dolne karty akordeon */-->
<!--.accordion .accordion-content {-->
<!--  max-height: 0;-->
<!--  overflow: hidden;-->
<!--  transition: max-height 0.3s ease;-->
<!--}-->

<!--.accordion.open .accordion-content {-->
<!--  max-height: 200px; /* dostosuj do potrzeb */-->
<!--}-->

<!--/* Szerokość dopasowana do ExperienceItem */-->
<!--.same-width {-->
<!--  max-width: 700px;-->
<!--}-->

<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--/* Experience list */-->
<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  max-width: 700px;-->
<!--}-->

<!--/* Contact list */-->
<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 0.5rem 0;-->
<!--}-->
<!--.contact-info li {-->
<!--  margin-bottom: 0.25rem;-->
<!--}-->

<!--/* -&#45;&#45; RESPONSYWNOŚĆ -&#45;&#45; */-->
<!--@media (max-width: 768px) {-->
<!--  .profile-top {-->
<!--    flex-direction: column;-->
<!--    align-items: center;-->
<!--  }-->

<!--  .profile-contact-wrapper {-->
<!--    width: 100%;-->
<!--    align-items: center;-->
<!--  }-->

<!--  .short-card, .same-width, .experience-list {-->
<!--    max-width: 100%;-->
<!--  }-->
<!--}-->
<!--</style>-->









<!--<template>-->
<!--  <div class="home">-->

<!--    &lt;!&ndash; Sekcja: O mnie &ndash;&gt;-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + nagłówek + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="profile-right">-->
<!--            <div class="profile-header">-->
<!--              <h1>Marzena Białończyk</h1>-->
<!--              <p class="title">Programistka Java</p>-->
<!--            </div>-->

<!--            <div class="contact-card card">-->
<!--              <h2>Dane kontaktowe</h2>-->
<!--              <ul class="contact-info">-->
<!--                <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--                <li><strong>Telefon:</strong> +48 516 083 143</li>-->
<!--                <li><strong>LinkedIn:</strong>-->
<!--                  <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--                </li>-->
<!--                <li><strong>GitHub:</strong>-->
<!--                  <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Dolna część: O mnie, Umiejętności techniczne, Języki obce &ndash;&gt;-->
<!--        <div class="profile-bottom">-->
<!--          <div class="card">-->
<!--            <h2>O mnie</h2>-->
<!--            <p>-->
<!--              Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu,-->
<!--              jak i frontendu – w pracy korzystam m.in. z Vue.js. Uwielbiam testować oprogramowanie,-->
<!--              pracować z bazami danych i szukać optymalnych rozwiązań dla każdego problemu.-->
<!--            </p>-->
<!--            <p>-->
<!--              Chętnie podejmuję współpracę przy różnorodnych projektach,-->
<!--              gdzie mogę rozwijać swoje umiejętności, eksperymentować-->
<!--              z nowymi technologiami i wspólnie tworzyć funkcjonalne,-->
<!--              przemyślane rozwiązania.-->
<!--            </p>-->
<!--          </div>-->

<!--          <div class="card">-->
<!--            <h2>Umiejętności techniczne</h2>-->
<!--            <p>-->
<!--              Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,-->
<!--              testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów-->
<!--            </p>-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->

<!--          <div class="card">-->
<!--            <h2>Języki obce</h2>-->
<!--            <p>Angielski: B1+</p>-->
<!--          </div>-->
<!--        </div>-->

<!--        &lt;!&ndash; Doświadczenie &ndash;&gt;-->
<!--        <h2>Doświadczenie</h2>-->
<!--        <div class="experience-list">-->
<!--          <ExperienceItem-->
<!--              v-for="exp in experience"-->
<!--              :key="exp.id"-->
<!--              :experience="exp"-->
<!--          />-->
<!--        </div>-->

<!--      </div>-->
<!--    </section>-->

<!--    &lt;!&ndash; Sekcja: Kim jestem prywatnie &ndash;&gt;-->
<!--    <section id="personal" class="personal-section section-box">-->
<!--      <div class="personal-card">-->
<!--        <div class="personal-container">-->
<!--          <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->
<!--          <div class="personal-info card">-->
<!--            <h1>Kim jestem</h1>-->
<!--            <p>-->
<!--              Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.-->
<!--              Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.-->
<!--            </p>-->
<!--            <p>-->
<!--              Interesuję się także zdrowym odżywianiem i właściwościami ziół, co pozwala mi świadomie dbać o swoje samopoczucie.-->
<!--              Łączę w sobie techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi.-->
<!--            </p>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </section>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ProjectCard from "@/components/ProjectCard.vue";-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      projects: []-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->

<!--    axios.get("http://localhost:8080/api/projects")-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania projects:", err));-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.about-section,-->
<!--.personal-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
<!--}-->

<!--/* Profil górna część: zdjęcie + header + kontakt */-->
<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-right {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: flex-start;-->
<!--  flex: 1;-->
<!--}-->

<!--/* Nagłówek */-->
<!--.profile-header h1 {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->

<!--.profile-header .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--/* Karta kontaktowa */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  width: 100%;-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-4px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--/* Profile bottom: O mnie, umiejętności, języki */-->
<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  max-width: 700px; /* dopasowane do ExperienceItem */-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--/* Experience list */-->
<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--/* Personal */-->
<!--.personal-container {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--/* Contact list */-->
<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 1rem 0;-->
<!--}-->

<!--.contact-info li {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->
<!--</style>-->






<!--<template>-->
<!--  <div class="home">-->
<!--    &lt;!&ndash; Sekcja: O mnie + doświadczenie &ndash;&gt;-->
<!--    <section id="about" class="home-section">-->
<!--      <div class="profile-container">-->
<!--        <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--        <div class="profile-info">-->
<!--          <h1 class="name">Marzena Białończyk</h1>-->
<!--          <p class="title">Programistka Java</p>-->

<!--          <h2>Dane kontaktowe</h2>-->
<!--          <ul class="contact-info">-->
<!--            <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--            <li><strong>Telefon:</strong> +48 516 083 143</li>-->
<!--            <li>-->
<!--              <strong>LinkedIn:</strong>-->
<!--              <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--            </li>-->
<!--            <li>-->
<!--              <strong>GitHub:</strong>-->
<!--              <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--            </li>-->
<!--          </ul>-->

<!--          <h2>O mnie</h2>-->
<!--          <p>-->
<!--            Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu,-->
<!--            jak i frontendu – w pracy korzystam m.in. z Vue.js. Uwielbiam testować oprogramowanie,-->
<!--            pracować z bazami danych i szukać optymalnych rozwiązań dla każdego problemu.-->
<!--            Programowanie to moja pasja, która sprawia, że z przyjemnością angażuję-->
<!--            się w nowe projekty i wyzwania.-->
<!--          </p>-->

<!--          <h2>Umiejętności techniczne</h2>-->
<!--          <p>-->
<!--            Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,-->
<!--            testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów-->
<!--          </p>-->

<!--          <h2>Języki obce</h2>-->
<!--          <p>Angielski: B1+</p>-->

<!--          <h2>Doświadczenie</h2>-->
<!--          <div>-->
<!--            <ExperienceItem-->
<!--                v-for="exp in experience"-->
<!--                :key="exp.id"-->
<!--                :experience="exp"-->
<!--            />-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </section>-->

<!--    &lt;!&ndash; Sekcja: Kim jestem prywatnie &ndash;&gt;-->
<!--    <section id="personal" class="home-section">-->
<!--      <div class="personal-container">-->
<!--        <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->

<!--        <div class="personal-info">-->
<!--          <h1>Kim jestem</h1>-->
<!--          <p>-->
<!--            Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.-->
<!--            Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.-->
<!--          </p>-->
<!--          <p>-->
<!--            Interesuję się także zdrowym odżywianiem i właściwościami ziół, co pozwala mi świadomie dbać o swoje samopoczucie.-->
<!--            Łączę w sobie techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi.-->
<!--          </p>-->
<!--        </div>-->
<!--      </div>-->
<!--    </section>-->

<!--    &lt;!&ndash; Sekcja: Projekty &ndash;&gt;-->
<!--    <section id="projects" class="home-section">-->
<!--      <h2>Projekty</h2>-->
<!--      <div class="projects-grid">-->
<!--        <ProjectCard-->
<!--            v-for="proj in projects"-->
<!--            :key="proj.id"-->
<!--            :project="proj"-->
<!--        />-->
<!--      </div>-->
<!--    </section>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ProjectCard from "../components/ProjectCard.vue";-->
<!--import ExperienceItem from "../components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      projects: []-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->

<!--    axios.get("http://localhost:8080/api/projects")-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania projects:", err));-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--/* wszystkie sekcje na home mają styl taki jak ExperienceItem */-->
<!--.home-section {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem;-->
<!--  margin-bottom: 1.5rem;-->
<!--  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.home-section:hover {-->
<!--  transform: translateY(-4px);-->
<!--  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.12);-->
<!--}-->

<!--.profile-container,-->
<!--.personal-container {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image,-->
<!--.personal-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-info,-->
<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--.name {-->
<!--  font-size: 1.8rem;-->
<!--  font-weight: 700;-->
<!--  color: #1f2937;-->
<!--}-->

<!--.title {-->
<!--  font-weight: 600;-->
<!--  color: #2563eb; /* taki sam niebieski jak firma w ExperienceItem */-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--h2 {-->
<!--  margin-top: 1rem;-->
<!--  margin-bottom: 0.5rem;-->
<!--  color: #1f2937;-->
<!--}-->

<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 1rem 0;-->
<!--}-->

<!--.contact-info li {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->

<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 1rem;-->
<!--}-->
<!--</style>-->



<!--<script>-->
<!--import ProjectCard from "@/components/ProjectCard.vue";-->
<!--import ExperienceItem from "@/components/ExperienceItem.vue";-->
<!--import axios from "axios";-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      projects: []-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get("http://localhost:8080/api/experience")-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania experience:", err));-->

<!--    axios.get("http://localhost:8080/api/projects")-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error("Błąd pobierania projects:", err));-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--/* Karta taka sama jak ExperienceItem */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem;-->
<!--  margin-bottom: 1.5rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-4px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--.profile-container,-->
<!--.personal-container {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image,-->
<!--.personal-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-info,-->
<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--.name {-->
<!--  font-size: 1.8rem;-->
<!--  font-weight: 700;-->
<!--  color: #1f2937;-->
<!--}-->

<!--.title {-->
<!--  font-weight: 600;-->
<!--  color: #2563eb;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--h2 {-->
<!--  margin-top: 1rem;-->
<!--  margin-bottom: 0.5rem;-->
<!--  color: #1f2937;-->
<!--}-->

<!--.contact-info {-->
<!--  list-style: none;-->
<!--  padding: 0;-->
<!--  margin: 0.5rem 0 1rem 0;-->
<!--}-->

<!--.contact-info li {-->
<!--  margin-bottom: 0.3rem;-->
<!--}-->

<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 1rem;-->
<!--}-->

<!--/* Specjalnie dla ExperienceItem w home */-->
<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--/* Karta osobista */-->
<!--.personal-card {-->
<!--  max-width: 1000px;-->
<!--  margin: 0 auto;-->
<!--}-->
<!--</style>-->

