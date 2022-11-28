<template>
  <div id="app">
    <Gnb/>
    <router-view/>
    <Footer></Footer>
  </div>
</template>

<script>
import Gnb from "./components/Gnb.vue"
import Footer from "./components/Footer.vue"

export default {
  name: 'App',
  components: {
    Gnb, Footer, 
  },
  data() {
    return {
      //{자료이름:자료내용} 
    }
  },
}
</script>

<style lang="scss">
@import './assets/styles/style.scss';
@import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-kr.css);
@import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-jp.css);
body {
  background: #000;
  margin: 0;
}
#app {
  font-family: 'Spoqa Han Sans Neo', 'sans-serif';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #000;
}
.banner-01 {
  padding-bottom: 0 !important;
}
</style>
