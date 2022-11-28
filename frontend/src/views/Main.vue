<template>
    <mainVisual></mainVisual>
    <Banner :file="require('../../public/images/banner_01.png')" :className="`banner banner-01`"></Banner>
    <Contents :title="`최신영상`"></Contents>
    <Contents :title="`핫클립`"></Contents>
    <Banner :file="require('../../public/images/banner_02.png')"></Banner>
    <Banner :file="require('../../public/images/banner_03.jpg')"></Banner>
</template>
  
<script>
import mainVisual from "../components/mainVisual.vue"
import Banner from "../components/Banner.vue"
import Contents from "../components/Contents.vue"

export default {
    name: 'Main',
    components: {
        mainVisual, Banner, Contents,
    },
    data() {
        return {
        //{자료이름:자료내용} 
        }
    },
}
</script>
  
<style lang="scss">
@import '@/assets/styles/style.scss';
.banner-01 {
    padding-bottom: 0 !important;
}
</style>
  