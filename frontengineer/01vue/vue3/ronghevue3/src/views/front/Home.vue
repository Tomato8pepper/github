<template>
  <div>
    <el-button @click="handleTest">点击测试</el-button>
  </div>
</template>

<script setup>
import request from '../../utils/request'
const handleTest = () => {
  request.get('/web/test').then(res => {
    console.log(res)
  })
}
</script>

<style>

</style>