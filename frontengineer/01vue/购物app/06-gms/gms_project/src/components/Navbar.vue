<template>
  <div>
    <mt-header :title="title">
      <router-link to="/" slot="left">
        <mt-button icon="back" @click="goback">返回</mt-button>
      </router-link>
      <mt-button slot="right"></mt-button>
    </mt-header>
  </div>
</template>

<script>
export default {
    props: ['title'],
    methods: {
        goback() {
            this.$router.go(-1)
        }
    }
}
</script>

<style scoped>
.mint-header{
    background-color: yellowgreen;
}
</style>