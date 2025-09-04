
<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div>&ndash;&gt;-->
<!--&lt;!&ndash;    &lt;!&ndash; O mnie + doświadczenie &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="about">&ndash;&gt;-->
<!--&lt;!&ndash;      <h1>O mnie</h1>&ndash;&gt;-->
<!--&lt;!&ndash;      <p>{{ aboutText }}</p>&ndash;&gt;-->

<!--&lt;!&ndash;      <h2>Doświadczenie</h2>&ndash;&gt;-->
<!--&lt;!&ndash;      <div>&ndash;&gt;-->
<!--&lt;!&ndash;        &lt;!&ndash; Użycie komponentu ExperienceItem &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;        <ExperienceItem&ndash;&gt;-->
<!--&lt;!&ndash;            v-for="exp in experience"&ndash;&gt;-->
<!--&lt;!&ndash;            :key="exp.id"&ndash;&gt;-->
<!--&lt;!&ndash;            :experience="exp"&ndash;&gt;-->
<!--&lt;!&ndash;        />&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; Projekty &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="projects">&ndash;&gt;-->
<!--&lt;!&ndash;      <h2>Projekty</h2>&ndash;&gt;-->
<!--&lt;!&ndash;      <div class="projects-grid">&ndash;&gt;-->
<!--&lt;!&ndash;        <ProjectCard&ndash;&gt;-->
<!--&lt;!&ndash;            v-for="proj in projects"&ndash;&gt;-->
<!--&lt;!&ndash;            :key="proj.id"&ndash;&gt;-->
<!--&lt;!&ndash;            :project="proj"&ndash;&gt;-->
<!--&lt;!&ndash;        />&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->

<!--&lt;!&ndash;&lt;!&ndash;    &lt;!&ndash; CV &ndash;&gt;&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;    <section id="cv">&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;      <h2>CV</h2>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;      <button @click="downloadCv">Pobierz CV</button>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;    </section>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;import ProjectCard from '../components/ProjectCard.vue';&ndash;&gt;-->
<!--&lt;!&ndash;import ExperienceItem from '../components/ExperienceItem.vue'; // <- importujemy komponent&ndash;&gt;-->
<!--&lt;!&ndash;import axios from 'axios';&ndash;&gt;-->

<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  components: { ProjectCard, ExperienceItem }, // <- dodajemy komponent&ndash;&gt;-->
<!--&lt;!&ndash;  data() {&ndash;&gt;-->
<!--&lt;!&ndash;    return {&ndash;&gt;-->
<!--&lt;!&ndash;      aboutText: 'Cześć! Jestem Marzena i zajmuję się tworzeniem aplikacji webowych w Javie i Vue.',&ndash;&gt;-->
<!--&lt;!&ndash;      experience: [],&ndash;&gt;-->
<!--&lt;!&ndash;      projects: []&ndash;&gt;-->
<!--&lt;!&ndash;    };&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  mounted() {&ndash;&gt;-->
<!--&lt;!&ndash;    axios.get('http://localhost:8080/api/experience')&ndash;&gt;-->
<!--&lt;!&ndash;        .then(res => this.experience = res.data)&ndash;&gt;-->
<!--&lt;!&ndash;        .catch(err => console.error('Błąd pobierania experience:', err));&ndash;&gt;-->

<!--&lt;!&ndash;    axios.get('http://localhost:8080/api/projects')&ndash;&gt;-->
<!--&lt;!&ndash;        .then(res => this.projects = res.data)&ndash;&gt;-->
<!--&lt;!&ndash;        .catch(err => console.error('Błąd pobierania projects:', err));&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  // methods: {&ndash;&gt;-->
<!--&lt;!&ndash;  //   downloadCv() {&ndash;&gt;-->
<!--&lt;!&ndash;  //     axios.get('http://localhost:8080/api/cv', { responseType: 'blob' })&ndash;&gt;-->
<!--&lt;!&ndash;  //         .then(res => {&ndash;&gt;-->
<!--&lt;!&ndash;  //           const url = window.URL.createObjectURL(new Blob([res.data], { type: 'application/pdf' }));&ndash;&gt;-->
<!--&lt;!&ndash;  //           const link = document.createElement('a');&ndash;&gt;-->
<!--&lt;!&ndash;  //           link.href = url;&ndash;&gt;-->
<!--&lt;!&ndash;  //           link.setAttribute('download', 'MojeCV.pdf');&ndash;&gt;-->
<!--&lt;!&ndash;  //           document.body.appendChild(link);&ndash;&gt;-->
<!--&lt;!&ndash;  //           link.click();&ndash;&gt;-->
<!--&lt;!&ndash;  //           link.remove();&ndash;&gt;-->
<!--&lt;!&ndash;  //         })&ndash;&gt;-->
<!--&lt;!&ndash;  //         .catch(err => console.error('Błąd pobierania CV:', err));&ndash;&gt;-->
<!--&lt;!&ndash;  //   }&ndash;&gt;-->
<!--&lt;!&ndash;  // }&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;&lt;!&ndash;<style scoped>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;.projects-grid {&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;  display: flex;&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;  flex-wrap: wrap;&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;  gap: 1rem;&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;}&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash;</style>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;<style>&ndash;&gt;-->
<!--&lt;!&ndash;.home-section {&ndash;&gt;-->
<!--&lt;!&ndash;  background: rgba(255, 255, 255, 0.75);&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 2rem;&ndash;&gt;-->
<!--&lt;!&ndash;  box-shadow: 0 4px 15px rgba(0,0,0,0.1);&ndash;&gt;-->
<!--&lt;!&ndash;  text-align: center;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->

<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div>&ndash;&gt;-->
<!--&lt;!&ndash;    &lt;!&ndash; O mnie + doświadczenie &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="about" class="about-section section-box">&ndash;&gt;-->
<!--&lt;!&ndash;      <div class="profile-container">&ndash;&gt;-->
<!--&lt;!&ndash;        <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena Białończyk" class="profile-image" />&ndash;&gt;-->

<!--&lt;!&ndash;        <div class="profile-info">&ndash;&gt;-->
<!--&lt;!&ndash;          <h1>Marzena Białończyk</h1>&ndash;&gt;-->
<!--&lt;!&ndash;          <p class="title">Programistka Java</p>&ndash;&gt;-->

<!--&lt;!&ndash;          <h2>Dane kontaktowe</h2>&ndash;&gt;-->
<!--&lt;!&ndash;          <ul class="contact-info">&ndash;&gt;-->
<!--&lt;!&ndash;            <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><strong>Telefon:</strong> +48 516 083 143</li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li><strong>LinkedIn:</strong> Marzena Białończyk</li>&ndash;&gt;-->
<!--&lt;!&ndash;          </ul>&ndash;&gt;-->

<!--&lt;!&ndash;          <h2>O mnie</h2>&ndash;&gt;-->
<!--&lt;!&ndash;          <p>&ndash;&gt;-->

<!--&lt;!&ndash;            Jestem programistką Java z zamiłowaniem do tworzenia zarówno backendu,&ndash;&gt;-->
<!--&lt;!&ndash;            jak i frontendu – w pracy korzystam m.in. z Vue.js. Uwielbiam testować oprogramowanie,&ndash;&gt;-->
<!--&lt;!&ndash;            pracować z bazami danych i szukać optymalnych rozwiązań dla każdego problemu.&ndash;&gt;-->
<!--&lt;!&ndash;            Programowanie to moja pasja, która sprawia, że z przyjemnością angażuję&ndash;&gt;-->
<!--&lt;!&ndash;            się w nowe projekty i wyzwania.&ndash;&gt;-->

<!--&lt;!&ndash;            Chętnie podejmuję współpracę przy różnorodnych projektach,&ndash;&gt;-->
<!--&lt;!&ndash;            gdzie mogę rozwijać swoje umiejętności, eksperymentować&ndash;&gt;-->
<!--&lt;!&ndash;            z nowymi technologiami i wspólnie tworzyć funkcjonalne,&ndash;&gt;-->
<!--&lt;!&ndash;            przemyślane rozwiązania. Jeśli szukasz osoby, która z pasją&ndash;&gt;-->
<!--&lt;!&ndash;            podchodzi do kodu i cieszy się z tworzenia dobrego oprogramowania,&ndash;&gt;-->
<!--&lt;!&ndash;            z przyjemnością podejmę się współpracy!&ndash;&gt;-->
<!--&lt;!&ndash;          </p>&ndash;&gt;-->

<!--&lt;!&ndash;          <h2>Umiejętności techniczne</h2>&ndash;&gt;-->
<!--&lt;!&ndash;          <p>&ndash;&gt;-->
<!--&lt;!&ndash;            Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,&ndash;&gt;-->
<!--&lt;!&ndash;            testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów&ndash;&gt;-->
<!--&lt;!&ndash;          </p>&ndash;&gt;-->

<!--&lt;!&ndash;          <h2>Języki obce</h2>&ndash;&gt;-->
<!--&lt;!&ndash;          <p>Angielski: B1+</p>&ndash;&gt;-->

<!--&lt;!&ndash;          <h2>Doświadczenie</h2>&ndash;&gt;-->
<!--&lt;!&ndash;          <div>&ndash;&gt;-->
<!--&lt;!&ndash;            <ExperienceItem&ndash;&gt;-->
<!--&lt;!&ndash;                v-for="exp in experience"&ndash;&gt;-->
<!--&lt;!&ndash;                :key="exp.id"&ndash;&gt;-->
<!--&lt;!&ndash;                :experience="exp"&ndash;&gt;-->
<!--&lt;!&ndash;            />&ndash;&gt;-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->
<!--&lt;!&ndash;        </div>&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; Projekty &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="projects" class="section-box">&ndash;&gt;-->
<!--&lt;!&ndash;      <h2>Projekty</h2>&ndash;&gt;-->
<!--&lt;!&ndash;      <div class="projects-grid">&ndash;&gt;-->
<!--&lt;!&ndash;        <ProjectCard&ndash;&gt;-->
<!--&lt;!&ndash;            v-for="proj in projects"&ndash;&gt;-->
<!--&lt;!&ndash;            :key="proj.id"&ndash;&gt;-->
<!--&lt;!&ndash;            :project="proj"&ndash;&gt;-->
<!--&lt;!&ndash;        />&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;import ProjectCard from '../components/ProjectCard.vue';&ndash;&gt;-->
<!--&lt;!&ndash;import ExperienceItem from '../components/ExperienceItem.vue';&ndash;&gt;-->
<!--&lt;!&ndash;import axios from 'axios';&ndash;&gt;-->

<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  components: { ProjectCard, ExperienceItem },&ndash;&gt;-->
<!--&lt;!&ndash;  data() {&ndash;&gt;-->
<!--&lt;!&ndash;    return {&ndash;&gt;-->
<!--&lt;!&ndash;      experience: [],&ndash;&gt;-->
<!--&lt;!&ndash;      projects: []&ndash;&gt;-->
<!--&lt;!&ndash;    };&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  mounted() {&ndash;&gt;-->
<!--&lt;!&ndash;    axios.get('http://localhost:8080/api/experience')&ndash;&gt;-->
<!--&lt;!&ndash;        .then(res => this.experience = res.data)&ndash;&gt;-->
<!--&lt;!&ndash;        .catch(err => console.error('Błąd pobierania experience:', err));&ndash;&gt;-->

<!--&lt;!&ndash;    axios.get('http://localhost:8080/api/projects')&ndash;&gt;-->
<!--&lt;!&ndash;        .then(res => this.projects = res.data)&ndash;&gt;-->
<!--&lt;!&ndash;        .catch(err => console.error('Błąd pobierania projects:', err));&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;.about-section {&ndash;&gt;-->
<!--&lt;!&ndash;  background: rgba(255, 255, 255, 0.75);&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 2rem;&ndash;&gt;-->
<!--&lt;!&ndash;  box-shadow: 0 4px 15px rgba(0,0,0,0.1);&ndash;&gt;-->
<!--&lt;!&ndash;  max-width: 1000px;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 2rem auto;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-container {&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-wrap: wrap;&ndash;&gt;-->
<!--&lt;!&ndash;  gap: 2rem;&ndash;&gt;-->
<!--&lt;!&ndash;  align-items: flex-start;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-image {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 250px;&ndash;&gt;-->
<!--&lt;!&ndash;  height: auto;&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  object-fit: cover;&ndash;&gt;-->
<!--&lt;!&ndash;  box-shadow: 0 4px 12px rgba(0,0,0,0.1);&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-info {&ndash;&gt;-->
<!--&lt;!&ndash;  flex: 1;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-info h1 {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 0.5rem;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-info .title {&ndash;&gt;-->
<!--&lt;!&ndash;  font-weight: 600;&ndash;&gt;-->
<!--&lt;!&ndash;  color: #f687b3;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.profile-info h2 {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-top: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 0.5rem;&ndash;&gt;-->
<!--&lt;!&ndash;  color: #1f2937;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.contact-info {&ndash;&gt;-->
<!--&lt;!&ndash;  list-style: none;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 0;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 0.5rem 0 1rem 0;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.contact-info li {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 0.25rem;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.projects-grid {&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-wrap: wrap;&ndash;&gt;-->
<!--&lt;!&ndash;  gap: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->

<!--<template>-->
<!--  <div>-->
<!--    &lt;!&ndash; Sekcja 1: O mnie + doświadczenie (profesjonalne) &ndash;&gt;-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->
<!--        <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--        <div class="profile-info">-->
<!--          <h1>Marzena Białończyk</h1>-->
<!--          <p class="title">Programistka Java</p>-->

<!--          <h2>Dane kontaktowe</h2>-->
<!--          <ul class="contact-info">-->
<!--            <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--            <li><strong>Telefon:</strong> +48 516 083 143</li>-->
<!--            <li><strong>LinkedIn:</strong>-->
<!--              <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank" rel="noopener noreferrer">-->
<!--                Marzena Białończyk-->
<!--              </a>-->
<!--            </li>-->
<!--            <li><strong>GitHub:</strong>-->
<!--              <a href="https://github.com/marzena0099?tab=repositories" target="_blank" rel="noopener noreferrer">-->
<!--                marzena0099-->
<!--              </a>-->
<!--            </li>-->
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

<!--    &lt;!&ndash; Sekcja 2: Kim jestem (życie codzienne) &ndash;&gt;-->
<!--    <section id="personal" class="personal-section section-box">-->
<!--      <div class="personal-container">-->
<!--        <img src="@/assets/images/zdj_o_mnie.jpg" alt="Marzena na wakacjach" class="personal-image" />-->

<!--        <div class="personal-info">-->
<!--          <h1>Kim jestem</h1>-->
<!--          <p>-->
<!--            Poza kodem uwielbiam muzykę – gram na gitarze, co daje mi przestrzeń do wyrażania siebie i rozwijania kreatywności.-->
<!--            Regularnie biegam, dbając o kondycję fizyczną i zdrowy styl życia, a kontakt z naturą pomaga mi zachować równowagę i spokój.-->
<!--            Interesuję się także zdrowym odżywianiem i właściwościami ziół, co pozwala mi świadomie dbać o swoje samopoczucie.-->
<!--          </p>-->
<!--          <p>-->
<!--            Łączę w sobie techniczne umiejętności z ciekawością świata i pozytywnym podejściem do ludzi, dlatego chętnie podejmuję współpracę przy nowych projektach,-->
<!--            gdzie mogę rozwijać swoje kompetencje i wspólnie tworzyć wartościowe rozwiązania.-->
<!--          </p>-->
<!--        </div>-->
<!--      </div>-->
<!--    </section>-->

<!--&lt;!&ndash;    &lt;!&ndash; Projekty &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <section id="projects" class="section-box">&ndash;&gt;-->
<!--&lt;!&ndash;      <h2>Projekty</h2>&ndash;&gt;-->
<!--&lt;!&ndash;      <div class="projects-grid">&ndash;&gt;-->
<!--&lt;!&ndash;        <ProjectCard&ndash;&gt;-->
<!--&lt;!&ndash;            v-for="proj in projects"&ndash;&gt;-->
<!--&lt;!&ndash;            :key="proj.id"&ndash;&gt;-->
<!--&lt;!&ndash;            :project="proj"&ndash;&gt;-->
<!--&lt;!&ndash;        />&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </section>&ndash;&gt;-->
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
<!--.about-section,-->
<!--.personal-section {-->
<!--  background: rgba(255, 255, 255, 0.75);-->
<!--  border-radius: 1rem;-->
<!--  padding: 2rem;-->
<!--  box-shadow: 0 4px 15px rgba(0,0,0,0.1);-->
<!--  max-width: 1000px;-->
<!--  margin: 2rem auto;-->
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
<!--  height: auto;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--.profile-info,-->
<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->

<!--.profile-info h1,-->
<!--.personal-info h1 {-->
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



<!--<template>-->
<!--  <div class="home">-->

<!--    &lt;!&ndash; Sekcja: O mnie &ndash;&gt;-->
<!--    <section id="about" class="about-section section-box">-->
<!--      <div class="profile-container">-->

<!--        &lt;!&ndash; Górna część: zdjęcie + dane kontaktowe &ndash;&gt;-->
<!--        <div class="profile-top">-->
<!--          <img src="@/assets/images/MB_CV.jpg" alt="Marzena Białończyk" class="profile-image" />-->

<!--          <div class="contact-card">-->
<!--            <h2>Dane kontaktowe</h2>-->
<!--            <ul class="contact-info">-->
<!--              <li><strong>E-mail:</strong> bialonczyk9182@gmail.com</li>-->
<!--              <li><strong>Telefon:</strong> +48 516 083 143</li>-->
<!--              <li><strong>LinkedIn:</strong>-->
<!--                <a href="https://www.linkedin.com/in/marzenabialonczyk/" target="_blank">Marzena Białończyk</a>-->
<!--              </li>-->
<!--              <li><strong>GitHub:</strong>-->
<!--                <a href="https://github.com/marzena0099?tab=repositories" target="_blank">marzena0099</a>-->
<!--              </li>-->
<!--            </ul>-->
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
<!--          </div>-->

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
<!--          <div class="personal-info">-->
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

<!--    &lt;!&ndash; Sekcja: Projekty &ndash;&gt;-->
<!--    <section id="projects" class="projects-section">-->
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

<!--/* Profil */-->
<!--.profile-container {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 2rem;-->
<!--}-->

<!--/* Górna część: zdjęcie + dane kontaktowe */-->
<!--.profile-top {-->
<!--  display: flex;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.contact-card {-->
<!--  flex: 1;-->
<!--}-->

<!--/* Dolna część: O mnie, Umiejętności, Języki pod zdjęciem */-->
<!--.profile-bottom {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--  max-width: 700px; /* ograniczenie szerokości */-->
<!--  align-items: flex-start;-->
<!--  margin-left: auto;-->
<!--  margin-right: auto;-->
<!--}-->

<!--/* Karty */-->
<!--.card {-->
<!--  background: #ffffff;-->
<!--  border-radius: 1rem;-->
<!--  padding: 1.5rem;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.08);-->
<!--  width: 100%;-->
<!--  transition: transform 0.2s ease, box-shadow 0.2s ease;-->
<!--}-->

<!--.card:hover {-->
<!--  transform: translateY(-4px);-->
<!--  box-shadow: 0 6px 16px rgba(0,0,0,0.12);-->
<!--}-->

<!--/* Obrazy */-->
<!--.profile-image,-->
<!--.personal-image {-->
<!--  width: 250px;-->
<!--  border-radius: 1rem;-->
<!--  object-fit: cover;-->
<!--  box-shadow: 0 4px 12px rgba(0,0,0,0.1);-->
<!--}-->

<!--/* Tekst */-->
<!--h1 {-->
<!--  margin-bottom: 0.5rem;-->
<!--}-->

<!--.title {-->
<!--  font-weight: 600;-->
<!--  color: #f687b3;-->
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

<!--/* Doświadczenie */-->
<!--.experience-list {-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 1rem;-->
<!--}-->

<!--/* Projekty */-->
<!--.projects-grid {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 1rem;-->
<!--}-->

<!--/* Personal card */-->
<!--.personal-card {-->
<!--  max-width: 1000px;-->
<!--  margin: 0 auto;-->
<!--}-->

<!--.personal-container {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--  gap: 2rem;-->
<!--  align-items: flex-start;-->
<!--}-->

<!--.personal-info {-->
<!--  flex: 1;-->
<!--}-->
<!--</style>-->



<template>
  <div class="home">

    <!-- Sekcja: O mnie -->
    <section id="about" class="about-section section-box">
      <div class="profile-container">

        <!-- Górna część: zdjęcie + dane kontaktowe z nagłówkiem -->
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

        <!-- Dolne karty: O mnie, Umiejętności, Języki -->
        <div class="profile-bottom">
          <div class="card same-width">
            <h2>O mnie</h2>
            <p>
              Jestem programistką Java z zamiłowaniem do tworzenia backendu i frontendu – w pracy korzystam z Vue.js.
              Uwielbiam testować oprogramowanie, pracować z bazami danych i szukać optymalnych rozwiązań.
            </p>
          </div>

          <div class="card same-width">
            <h2>Umiejętności techniczne</h2>
            <p>
              Java, Spring Boot, Vue, HTML, JavaScript, REST API, Postman, Git, Docker, SQL, IntelliJ IDEA, JIRA, Confluence,
              testowanie (API, eksploracyjne, integracyjne, regresja, E2E, UAT, re-testy), zgłaszanie błędów
            </p>
          </div>

          <div class="card same-width">
            <h2>Języki obce</h2>
            <p>Angielski: B1+</p>
          </div>
        </div>

        <!-- Doświadczenie -->
        <h2>Doświadczenie</h2>
        <div class="experience-list">
          <ExperienceItem
              v-for="exp in experience"
              :key="exp.id"
              :experience="exp"
          />
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
    };
  },
  mounted() {
    axios.get("http://localhost:8080/api/experience")
        .then(res => this.experience = res.data)
        .catch(err => console.error("Błąd pobierania experience:", err));
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

/* Profil górna część: zdjęcie + header + kontakt */
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

/* Wrapper nagłówek + kontakt obok zdjęcia */
.profile-contact-wrapper {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  flex: 1;
}

/* Nagłówek */
.profile-header h1 {
  margin-bottom: 0.3rem;
}
.profile-header .title {
  font-weight: 600;
  color: #f687b3;
  margin-bottom: 1rem;
}

/* Karta kontaktowa */
.card {
  background: #ffffff;
  border-radius: 1rem;
  padding: 1rem;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  margin-bottom: 1rem;
}
.card:hover {
  transform: translateY(-4px);
  box-shadow: 0 6px 16px rgba(0,0,0,0.12);
}

/* Skrócona karta kontaktowa */
.short-card {
  max-width: 300px;
}

/* Dolne karty */
.profile-bottom {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  max-width: 700px;
  margin-top: 2rem;
}

.same-width {
  max-width: 700px; /* dopasowanie do doświadczenia */
}

/* Experience list */
.experience-list {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  max-width: 700px;
}

/* Contact list */
.contact-info {
  list-style: none;
  padding: 0;
  margin: 0.5rem 0 0.5rem 0;
}
.contact-info li {
  margin-bottom: 0.25rem;
}

/* --- RESPONSYWNOŚĆ --- */
@media (max-width: 768px) {
  .profile-top {
    flex-direction: column;
    align-items: center;
  }

  .profile-contact-wrapper {
    width: 100%;
    align-items: center;
  }

  .short-card, .same-width, .experience-list {
    max-width: 100%;
  }
}
</style>



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
<!--          </div>-->

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

