<template>
  <div>
    hello3- ref- 新写法
    {{myname}}
    <button @click="handleClick">change</button>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
    setup() {
        const myname = ref('kerwin')

        const handleClick = () => {
            myname.value = 'xiaoming'
        }
        
        return {
            myname,
            handleClick
        }
    }
}
</script>

<style>

</style>