<template>
  <div>
    hello3- 新写法
    {{myname}}
    {{myage}}
    <button @click="handleClick">change</button>
  </div>
</template>

<script>
import { reactive, toRefs } from 'vue'  
export default {
    // vue3老写法， 原vue中beforeCreated、created  生命周期=== setup
    setup() {
        const obj = reactive({
            myname: 'kerwin',
            myage: 18
        })

        const handleClick = () => {
            obj.myage = 20
        }

        return {
            ...toRefs(obj),
            handleClick
        }
    }
}
</script>

<style>

</style>