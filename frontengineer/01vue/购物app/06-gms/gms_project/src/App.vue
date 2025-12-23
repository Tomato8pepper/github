<template>
  <div>
    <mt-header title="购物信息系统"></mt-header>

    <router-view />

    <mt-tabbar v-model="selected">
      <mt-tab-item id="Home">
        <img slot="icon" src="./assets/index.png" />
        首页
      </mt-tab-item>
      <mt-tab-item id="Member">
        <img slot="icon" src="./assets/vip.png" />
        会员
      </mt-tab-item>
      <mt-tab-item id="Shopcart">
        <img slot="icon" src="./assets/shopcart.png" />
        购物车
      </mt-tab-item>
      <mt-tab-item id="Find">
        <img slot="icon" src="./assets/find.png" />
        查找
      </mt-tab-item>
    </mt-tabbar>
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected: ''
    }
  },
  watch: {
    selected(newV, oldV) {
      this.$router.push({ name: newV })
    }
  }
}
</script>

<style>
</style>
