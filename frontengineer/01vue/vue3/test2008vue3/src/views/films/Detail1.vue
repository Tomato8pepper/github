<template>
  <div>
    detail
  </div>
</template>

<script>
export default {
    data() {
        return {
            filmId: ''
        }
    },
    created() {
        console.log(this.$route.params, 'id')
        this.filmId = this.$route.params.id
    }
}
</script>

<style>

</style>