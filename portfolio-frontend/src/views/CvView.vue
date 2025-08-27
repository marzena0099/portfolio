<template>
  <div>
    <h1>Moje CV</h1>
    <button @click="downloadCv">Pobierz CV</button>
  </div>
</template>

<script>
import { downloadCv } from '@/services/cvService';

export default {
  name: 'CvView',
  methods: {
    downloadCv
  }
};
</script>
