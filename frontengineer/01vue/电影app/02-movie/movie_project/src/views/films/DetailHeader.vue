<template>
  <div class="header">
    <van-icon class="icon" name="arrow-left" @click="handleBack" />
    <slot></slot>
  </div>
</template>

<script>
export default {
    methods: {
        handleBack() {
            this.$router.back()
        }
    }
}
</script>

<style lang="scss" scoped>
    .header{
        // position: fixed;
        // top: 0;       
        // width: 100vw;
        height: 50px;
        line-height: 50px;
        background-color: white;
        text-align: center;
        .icon{
            position: fixed;
            left: 10px;
            height: 50px;
            line-height: 50px;
        }
    }
    
</style>