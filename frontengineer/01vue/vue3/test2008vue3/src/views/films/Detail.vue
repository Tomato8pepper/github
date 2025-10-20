<template>
  <div>
    detail
  </div>
</template>

<script>
import { onMounted, onUnmounted, reactive } from 'vue'
import { useRoute } from 'vue-router'
import { useStore } from 'vuex'
export default {
    
    setup() {
      const obj = reactive({
        filmId: ''
      })
      
      const route = useRoute() 
      const store = useStore()

      onMounted(() => {
        store.commit('show')
        obj.filmId = route.params.id
      })

      onUnmounted(() => {
        store.commit('hide')
      })
    }
}
</script>

<style>

</style>