<!--<template>-->
<!--  <div>-->
<!--    &lt;!&ndash; O mnie + doświadczenie &ndash;&gt;-->
<!--    <section id="about">-->
<!--      <h1>O mnie</h1>-->
<!--      <p>{{ aboutText }}</p>-->

<!--      <h2>Doświadczenie</h2>-->
<!--      <div>-->
<!--        &lt;!&ndash; Użycie komponentu ExperienceItem &ndash;&gt;-->
<!--        <ExperienceItem-->
<!--            v-for="exp in experience"-->
<!--            :key="exp.id"-->
<!--            :experience="exp"-->
<!--        />-->
<!--      </div>-->
<!--    </section>-->

<!--    &lt;!&ndash; Projekty &ndash;&gt;-->
<!--    <section id="projects">-->
<!--      <h2>Projekty</h2>-->
<!--      <div class="projects-grid">-->
<!--        <ProjectCard-->
<!--            v-for="proj in projects"-->
<!--            :key="proj.id"-->
<!--            :project="proj"-->
<!--        />-->
<!--      </div>-->
<!--    </section>-->

<!--&lt;!&ndash;    &lt;!&ndash; CV &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="cv">&ndash;&gt;-->
<!--&lt;!&ndash;      <h2>CV</h2>&ndash;&gt;-->
<!--&lt;!&ndash;      <button @click="downloadCv">Pobierz CV</button>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import ProjectCard from '../components/ProjectCard.vue';-->
<!--import ExperienceItem from '../components/ExperienceItem.vue'; // <- importujemy komponent-->
<!--import axios from 'axios';-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem }, // <- dodajemy komponent-->
<!--  data() {-->
<!--    return {-->
<!--      aboutText: 'Cześć! Jestem Marzena i zajmuję się tworzeniem aplikacji webowych w Javie i Vue.',-->
<!--      experience: [],-->
<!--      projects: []-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get('http://localhost:8080/api/experience')-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error('Błąd pobierania experience:', err));-->

<!--    axios.get('http://localhost:8080/api/projects')-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error('Błąd pobierania projects:', err));-->
<!--  },-->
<!--  // methods: {-->
<!--  //   downloadCv() {-->
<!--  //     axios.get('http://localhost:8080/api/cv', { responseType: 'blob' })-->
<!--  //         .then(res => {-->
<!--  //           const url = window.URL.createObjectURL(new Blob([res.data], { type: 'application/pdf' }));-->
<!--  //           const link = document.createElement('a');-->
<!--  //           link.href = url;-->
<!--  //           link.setAttribute('download', 'MojeCV.pdf');-->
<!--  //           document.body.appendChild(link);-->
<!--  //           link.click();-->
<!--  //           link.remove();-->
<!--  //         })-->
<!--  //         .catch(err => console.error('Błąd pobierania CV:', err));-->
<!--  //   }-->
<!--  // }-->
<!--};-->
<!--</script>-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;.projects-grid {&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-wrap: wrap;&ndash;&gt;-->
<!--&lt;!&ndash;  gap: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->
<!--<style>-->
<!--.home-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  text-align: center;-->
<!--}-->
<!--</style>-->

<!--<template>-->
<!--  <div>-->
<!--    &lt;!&ndash; O mnie + doświadczenie &ndash;&gt;-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->
<!--        <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--        <div class="profile-info">-->
<!--          <h1>Marzena Białończyk</h1>-->
<!--          <p class="title">Programistka Java</p>-->

<!--          <h2>Dane kontaktowe</h2>-->
<!--          <ul class="contact-info">-->
<!--            <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--            <li><strong>Telefon:</strong> +48 516 083 143</li>-->
<!--            <li><strong>LinkedIn:</strong> Marzena Białończyk</li>-->
<!--          </ul>-->

<!--          <h2>O mnie</h2>-->
<!--          <p>-->

<!--            Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu,-->
<!--            jak i frontendu – w pracy korzystam m.in. z Vue.js. Uwielbiam testować oprogramowanie,-->
<!--            pracować z bazami danych i szukać optymalnych rozwiązań dla każdego problemu.-->
<!--            Programowanie to moja pasja, która sprawia, że z przyjemnością angażuję-->
<!--            się w nowe projekty i wyzwania.-->

<!--            Chętnie podejmuję współpracę przy różnorodnych projektach,-->
<!--            gdzie mogę rozwijać swoje umiejętności, eksperymentować-->
<!--            z nowymi technologiami i wspólnie tworzyć funkcjonalne,-->
<!--            przemyślane rozwiązania. Jeśli szukasz osoby, która z pasją-->
<!--            podchodzi do kodu i cieszy się z tworzenia dobrego oprogramowania,-->
<!--            z przyjemnością podejmę się współpracy!-->
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

<!--    &lt;!&ndash; Projekty &ndash;&gt;-->
<!--    <section id="projects" class="section-box">-->
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
<!--import ProjectCard from '../components/ProjectCard.vue';-->
<!--import ExperienceItem from '../components/ExperienceItem.vue';-->
<!--import axios from 'axios';-->

<!--export default {-->
<!--  components: { ProjectCard, ExperienceItem },-->
<!--  data() {-->
<!--    return {-->
<!--      experience: [],-->
<!--      projects: []-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    axios.get('http://localhost:8080/api/experience')-->
<!--        .then(res => this.experience = res.data)-->
<!--        .catch(err => console.error('Błąd pobierania experience:', err));-->

<!--    axios.get('http://localhost:8080/api/projects')-->
<!--        .then(res => this.projects = res.data)-->
<!--        .catch(err => console.error('Błąd pobierania projects:', err));-->
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

<!--.profile-container {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.profile-image {-->
<!--  width: 250px;-->
<!--  height: auto;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-info {-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-info h1 {-->
<!--  margin-bottom: 0.5rem;-->
<!--}-->

<!--.profile-info .title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
<!--  margin-bottom: 1rem;-->
<!--}-->

<!--.profile-info h2 {-->
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
<!--  margin-bottom: 0.25rem;-->
<!--}-->

<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 1rem;-->
<!--}-->
<!--</style>-->

<template>
  <div>
    <!-- Sekcja 1: O mnie + doświadczenie (profesjonalne) -->
    <section id="about" class="about-section section-box">
      <div class="profile-container">
        <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />

        <div class="profile-info">
          <h1>Marzena Białończyk</h1>
          <p class="title">Programistka Java</p>

          <h2>Dane kontaktowe</h2>
          <ul class="contact-info">
            <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>
            <li><strong>Telefon:</strong> +48 516 083 143</li>
            <li><strong>LinkedIn:</strong>
              <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank" rel="noopener noreferrer">
                Marzena Białończyk
              </a>
            </li>
            <li><strong>GitHub:</strong>
              <a href="https://github.com/marzena0099?tab=repositories" target="_blank" rel="noopener noreferrer">
                marzena0099
              </a>
            </li>
          </ul>



          <h2>O mnie</h2>
          <p>
            Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu,
            jak i frontendu – w pracy korzystam m.in. z Vue.js. Uwielbiam testować oprogramowanie,
            pracować z bazami danych i szukać optymalnych rozwiązań dla każdego problemu.
            Programowanie to moja pasja, która sprawia, że z przyjemnością angażuję
            się w nowe projekty i wyzwania.

            Chętnie podejmuję współpracę przy różnorodnych projektach,
            gdzie mogę rozwijać swoje umiejętności, eksperymentować
            z nowymi technologiami i wspólnie tworzyć funkcjonalne,
            przemyślane rozwiązania. Jeśli szukasz osoby, która z pasją
            podchodzi do kodu i cieszy się z tworzenia dobrego oprogramowania,
            z przyjemnością podejmę się współpracy!
          </p>

          <h2>Umiejętności techniczne</h2>
          <p>
            Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,
            testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów
          </p>

          <h2>Języki obce</h2>
          <p>Angielski: B1+</p>

          <h2>Doświadczenie</h2>
          <div>
            <ExperienceItem
                v-for="exp in experience"
                :key="exp.id"
                :experience="exp"
            />
          </div>
        </div>
      </div>
    </section>

    <!-- Sekcja 2: Kim jestem (życie codzienne) -->
    <section id="personal" class="personal-section section-box">
      <div class="personal-container">
        <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />

        <div class="personal-info">
          <h1>Kim jestem</h1>
          <p>
            Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.
            Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.
            Interesuję się także zdrowym odżywianiem i właściwościami ziół, co pozwala mi świadomie dbać o swoje samopoczucie.
          </p>
          <p>
            Łączę w sobie techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach,
            gdzie mogę rozwijać swoje kompetencje i wspólnie tworzyć wartościowe rozwiązania.
          </p>
        </div>
      </div>
    </section>

<!--    &lt;!&ndash; Projekty &ndash;&gt;-->
<!--    <section id="projects" class="section-box">-->
<!--      <h2>Projekty</h2>-->
<!--      <div class="projects-grid">-->
<!--        <ProjectCard-->
<!--            v-for="proj in projects"-->
<!--            :key="proj.id"-->
<!--            :project="proj"-->
<!--        />-->
<!--      </div>-->
<!--    </section>-->
  </div>
</template>

<script>
import ProjectCard from '../components/ProjectCard.vue';
import ExperienceItem from '../components/ExperienceItem.vue';
import axios from 'axios';

export default {
  components: { ProjectCard, ExperienceItem },
  data() {
    return {
      experience: [],
      projects: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/api/experience')
        .then(res => this.experience = res.data)
        .catch(err => console.error('Błąd pobierania experience:', err));

    axios.get('http://localhost:8080/api/projects')
        .then(res => this.projects = res.data)
        .catch(err => console.error('Błąd pobierania projects:', err));
  }
};
</script>

<style scoped>
.about-section,
.personal-section {
  background: rgba(255, 255, 255, 0.75);
  border-radius: 1rem;
  padding: 2rem;
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  max-width: 1000px;
  margin: 2rem auto;
}

.profile-container,
.personal-container {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  align-items: flex-start;
}

.profile-image,
.personal-image {
  width: 250px;
  height: auto;
  border-radius: 1rem;
  object-fit: cover;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.profile-info,
.personal-info {
  flex: 1;
}

.profile-info h1,
.personal-info h1 {
  margin-bottom: 0.5rem;
}

.profile-info .title {
  font-weight: 600;
  color: #f687b3;
  margin-bottom: 1rem;
}

.profile-info h2 {
  margin-top: 1rem;
  margin-bottom: 0.5rem;
  color: #1f2937;
}

.contact-info {
  list-style: none;
  padding: 0;
  margin: 0.5rem 0 1rem 0;
}

.contact-info li {
  margin-bottom: 0.25rem;
}

.projects-grid {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}
</style>

