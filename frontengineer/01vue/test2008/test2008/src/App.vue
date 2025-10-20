<template>
  <div id="app">
    
    <router-view/>
    
    <tabbar v-show="$store.state.isTabbarShow"></tabbar>
  </div>
</template>
<script>
import Tabbar from './views/films/Tabbar.vue'
export default {
   
  components: {
    Tabbar
  }
   
}

</script>

<style lang="scss">
*{
  padding: 0;
  margin: 0;
}
 
</style>
