<template>
  <div class="editorIndex">
      <!-- <router-link to="/entalk" class="btn-index btn-entalk">ENTalk</router-link>
      <router-link to="/entalk-teaser" class="btn-index btn-teaser">ENTalk Teaser</router-link>
      <router-link to="/ceo" class="btn-index btn-ceo">CEO-Message</router-link> -->
      
      <!-- <cmtList></cmtList> -->
  </div>
</template>
  
<script>
// import cmtList from "./components/cmtList.vue"
export default {
  name: 'app',
  components: {
    // cmtList
  },
  data() {
      return {
          navList: [
        
          ],
      }
  },
};
</script>
  
  
<style lang="scss" scoped>
.editorIndex {
  // margin: 50px auto 0;
  display: flex;
  flex-direction: column;
  align-content: center;
  align-items: center;
  justify-content: center;
  height: 100%;
}
</style>
