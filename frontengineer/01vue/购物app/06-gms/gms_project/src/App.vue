<template>
  <div>
    <mt-header title="购物信息系统"></mt-header>

    <router-view />

    <mt-tabbar v-model="selected">
      <mt-tab-item id="index">
        <img slot="icon" src="./assets/index.png" />
        首页
      </mt-tab-item>
      <mt-tab-item id="vip">
        <img slot="icon" src="./assets/vip.png" />
        会员
      </mt-tab-item>
      <mt-tab-item id="shopcart">
        <img slot="icon" src="./assets/shopcart.png" />
        购物车
      </mt-tab-item>
      <mt-tab-item id="find">
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
  created() {
    
  }
}
</script>

<style>
</style>
