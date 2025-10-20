<template>
  <div>
    hello
    <input type="text" v-model="mytext"/>
    {{mytext}}
    <div v-hello>11</div>

    <ul v-show="$store.state.isShowTabbar">
      <router-link to="/films">films</router-link>
      <router-link to="/cinemas">cinemas</router-link>
      <router-link to="/center">center</router-link>
    </ul>

    <h5>--------------------</h5>

    <router-view></router-view>

  </div>

  
</template>

<script>
export default {
  data() {
    return {
      mytext: ''
    }
  },
  directives: {
    hello: {
      mounted(el) {
        el.style.color = 'red'
      }
    }
  }
}
</script>

<style>

</style>